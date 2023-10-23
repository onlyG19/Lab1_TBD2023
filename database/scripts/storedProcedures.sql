CREATE OR REPLACE FUNCTION reporte_emergencia() 
RETURNS TABLE (id_coordinador INTEGER, operacion_emergencia_log VARCHAR(255), cantidad INTEGER)
LANGUAGE plpgsql AS $$
BEGIN
    CREATE TEMP TABLE datos_reporte AS
    SELECT el.id_coordinador, el.operacion_emergencia_log, count(*)::INTEGER as cantidad
    FROM emergencia_log as el
    WHERE el.operacion_emergencia_log = 'UPDATE'
    GROUP BY el.id_coordinador, el.operacion_emergencia_log;

    RETURN QUERY EXECUTE 'SELECT * FROM datos_reporte';
END;
$$;

-- Ejemplo de uso de reporte_emergencia
-- SELECT * FROM reporte_emergencia(); 
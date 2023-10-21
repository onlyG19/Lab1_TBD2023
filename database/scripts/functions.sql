CREATE FUNCTION TareasActivasEmergencia(BIGINT) returns BIGINT
AS
$$
DECLARE
    tareasActivas BIGINT;
BEGIN
    SELECT count(tarea.id_tarea) FILTER ( WHERE tarea.estado_tarea = true ) INTO tareasActivas FROM tarea
    JOIN emergencia ON emergencia.id_emergencia = tarea.id_emergencia
    WHERE emergencia.id_emergencia = $1;
    RETURN tareasActivas;
END;
$$
LANGUAGE plpgsql;
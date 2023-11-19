-- Función para calcular la cantidad de tareas activas de cada emergencia
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

-- Función para calcular mostrar y calcular el ranking pero sin inserción
CREATE OR REPLACE FUNCTION calcular_ranking_lite(tarea INT, rank_range INT) RETURNS TABLE (
    id_tarea INT,
	id_voluntario INT,
    total_puntos INT,
    lugar INT,
    se_asigna BOOLEAN
) AS $$
BEGIN
    RETURN QUERY
    SELECT
		tarea AS id_tarea,
        v.id_voluntario,
        COALESCE(SUM(th.puntaje_tarea_habilidad)::INT, 0) AS total_puntos,
        ROW_NUMBER() OVER (ORDER BY COALESCE(SUM(th.puntaje_tarea_habilidad)::INT, 0) DESC)::INT AS lugar,
        CASE
            WHEN ROW_NUMBER() OVER (ORDER BY COALESCE(SUM(th.puntaje_tarea_habilidad)::INT, 0) DESC) <= rank_range THEN true
            ELSE false
        END AS se_asigna	
    FROM
        voluntario v
    LEFT JOIN
        vol_habilidad vh ON v.id_voluntario = vh.id_voluntario
    LEFT JOIN
        tarea_habilidad th ON vh.id_habilidad = th.id_habilidad AND th.id_tarea = tarea
    GROUP BY
        v.id_voluntario
    ORDER BY
        total_puntos DESC;
END;
$$ LANGUAGE plpgsql;

-- Testeo de calcular_ranking_lite
--SELECT * FROM calcular_ranking_lite(1, 3);  

-- Función que calcula el ranking y lo inserta a la tabla ranking
CREATE OR REPLACE FUNCTION calcular_ranking(tarea INT, rank_range INT) RETURNS VOID AS $$
BEGIN
    WITH ranking_cte AS (
        SELECT
            v.id_voluntario,
            ROW_NUMBER() OVER (ORDER BY COALESCE(SUM(th.puntaje_tarea_habilidad)::INT, 0) DESC)::INT AS posicion_ranking,
            tarea AS id_tarea,
            CASE
                WHEN ROW_NUMBER() OVER (ORDER BY COALESCE(SUM(th.puntaje_tarea_habilidad)::INT, 0) DESC) <= rank_range THEN true
                ELSE false
            END AS asignado_ranking,
            COALESCE(SUM(th.puntaje_tarea_habilidad)::INT, 0) AS puntaje_ranking
        FROM
            voluntario v
        LEFT JOIN
            vol_habilidad vh ON v.id_voluntario = vh.id_voluntario
        LEFT JOIN
            tarea_habilidad th ON vh.id_habilidad = th.id_habilidad AND th.id_tarea = tarea
        GROUP BY
            v.id_voluntario
    )
    
    INSERT INTO ranking (id_voluntario, posicion_ranking, id_tarea, asignado_ranking)
    SELECT id_voluntario, posicion_ranking, id_tarea, asignado_ranking
    FROM ranking_cte;

END;
$$ LANGUAGE plpgsql;

-- Testeo de calcular_ranking
-- SELECT * FROM calcular_ranking(1, 3); 

SELECT * FROM calcular_ranking(1, 5); 



-- Funcion que obtiene los volutiarios inscritos en una emergencia y que estan dentro de un Radio
CREATE OR REPLACE FUNCTION obtener_voluntarios_emergencia_radio(id_emergencia_param INT, radio FLOAT)
    RETURNS TABLE (
                      id_voluntario INT,
                      nombre_voluntario VARCHAR(255),
                      apellido_voluntario VARCHAR(255),
                      telefono_voluntario VARCHAR(15),
                      direccion_voluntario VARCHAR(255),
                      fecha_nacimiento_voluntario DATE,
                      disponibilidad_voluntario DATE,
                      email_voluntario VARCHAR(255),
                      geom GEOMETRY(Point, 4326)
                  ) AS $$
BEGIN
    RETURN QUERY
        SELECT DISTINCT
            v.id_voluntario,
            v.nombre_voluntario,
            v.apellido_voluntario,
            v.telefono_voluntario,
            v.direccion_voluntario,
            v.fecha_nacimiento_voluntario,
            v.disponibilidad_voluntario,
            v.email_voluntario,
            v.geom
        FROM
            voluntario v
                JOIN ranking r ON v.id_voluntario = r.id_voluntario  -- AND r.asignado_ranking = TRUE 
				-- Para tomar voluntarios asignados a las tareas (TRUE), no asignados(FALSE) o todos (Comentar el AND)
                JOIN tarea t ON t.id_tarea = r.id_tarea
                JOIN emergencia e ON t.id_emergencia = e.id_emergencia
        WHERE
                e.id_emergencia = id_emergencia_param
          AND ST_DWITHIN(v.geom::geography, e.geom_emergencia::geography, radio); -- Radio en metros
END;
$$ LANGUAGE plpgsql;

-- Ejemplo de uso con id_emergencia = 1 y 8km de radio
-- SELECT * FROM obtener_voluntarios_emergencia_radio(1, 8000);
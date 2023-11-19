
--------------------------------- Consulta para probar intersección ------------------------------------------------------
SELECT vol.*
FROM voluntario AS vol
WHERE ST_DWITHIN(vol.geom::geography, ST_GeographyFromText('POINT(-70.692909 -33.444485)'), 5000); --Donde 1000 es el radio en metros

-- Estructura de ST_Buffer(Geometría, Distancia, Forma de la geometría), en geom estamos usando un punto, la distancia está en grados de arco (111.1km c/u)
-- para la forma usamos el string 'quad_segs=8' que es la estandard circular alrededor del punto, se usa ST_SetSRID para configurar el sistema coordenado
-- 4326->WGS84

-- Por lo que para sacar los grados a utilizar considerando radio en km es: X/111.1 = Grados


--------------------------------- Consulta de prueba para obtener los voluntarios relacionados a una emergencia ---------------------------------------
-- Por modelo voluntario se relaciona con ranking, raking a tarea, tarea a emergencia.
SELECT vol.*
FROM voluntario AS vol
JOIN ranking AS rk ON rk.id_voluntario = vol.id_voluntario AND rk.asignado_ranking = TRUE
JOIN tarea AS ta ON rk.id_tarea = ta.id_tarea
JOIN emergencia AS eme
ON ta.id_emergencia = 1 AND eme.id_emergencia = 1;
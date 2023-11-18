
--------------------------------- Consulta para probar intersección ------------------------------------------------------
SELECT vol.*
FROM voluntario AS vol
WHERE ST_DWITHIN(vol.geom::geography, ST_GeographyFromText('POINT(-70.692909 -33.444485)'),1000); --Donde 1000 es el radio en metros

-- Estructura de ST_Buffer(Geometría, Distancia, Forma de la geometría), en geom estamos usando un punto, la distancia está en grados de arco (111.1km c/u)
-- para la forma usamos el string 'quad_segs=8' que es la estandard circular alrededor del punto, se usa ST_SetSRID para configurar el sistema coordenado
-- 4326->WSG84

-- Por lo que para sacar los grados a utilizar considerando radio en km es: X/111.1 = Grados

--------------------------------- Refactor de la función de intersecciones de voluntarios con una emergencia ------------------------------------------
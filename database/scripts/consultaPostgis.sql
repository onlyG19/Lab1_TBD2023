
--------------------------------- Consulta para probar intersección ------------------------------------------------------
SELECT vol.*
FROM voluntario AS vol
WHERE ST_Within(vol.geom, ST_SetSRID(ST_Buffer(ST_GeomFromText('POINT(-70.692909 -33.444485)'), 0.05650, 'quad_segs=8'), 4326));

-- Estructura de ST_Buffer(Geometría, Distancia, Forma de la geometría), en geom estamos usando un punto, la distancia está en grados de arco (111.1km c/u)
-- para la forma usamos el string 'quad_segs=8' que es la estandard circular alrededor del punto, se usa ST_SetSRID para configurar el sistema coordenado
-- 4326->WSG84

-- Por lo que para sacar los grados a utilizar considerando radio en km es: X/111.1 = Grados

--------------------------------- Refactor de la función de intersecciones de voluntarios con una emergencia ------------------------------------------
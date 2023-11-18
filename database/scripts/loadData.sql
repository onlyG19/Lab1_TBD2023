-- noinspection SqlNoDataSourceInspectionForFile

--------------------------------------------------- CARGA DE DATOS ----------------------------------------------------
INSERT INTO voluntario (nombre_voluntario, apellido_voluntario, telefono_voluntario, direccion_voluntario, fecha_nacimiento_voluntario, disponibilidad_voluntario, email_voluntario, password_voluntario, geom)
VALUES
    -- $2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW es encriptacion para 12345678
    ('Juan', 'Pérez', '+56901234567', 'Nueva Imperial N° 4261', '1990-01-01', '2023-11-20', 'juan.perez@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-70.692909 -33.444485)'), 4326)),
    ('Maria', 'González', '+56907654321', 'Eliodoro Yañez N°2.881', '1985-05-15', '2023-11-22', 'maria.gonzalez@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-70.593534 -33.42792)'), 4326)),
    ('Pedro', 'Soto', '+56909876543', 'Leal N° 499', '1993-09-20', '2023-11-25', 'pedro.soto@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-70.635748 -33.491304)'), 4326)),
    ('Carla', 'López', '+56901234567', 'Av. Vicuña Mackenna N° 584', '1988-03-12', '2023-11-28', 'carla.lopez@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-70.631806 -33.44859)'), 4326)),
    ('Miguel', 'Martínez', '+56907654321', 'Venancia Leiva N° 2311', '1995-07-30', '2023-12-01', 'miguel.martinez@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-70.633001 -33.558203)'), 4326)),
    ('Fernanda', 'Gómez', '+56909876543', 'Isidora Goyenechea Nº 3614', '1983-11-05', '2023-12-04', 'fernanda.gomez@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-70.5922 -33.4137)'), 4326)),
    ('Diego', 'Hernández', '+56901234567', 'Pasaje Las Malvas N° 179', '1992-04-18', '2023-12-07', 'diego.hernandez@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-70.740746 -33.366722)'), 4326)),
    ('Ana', 'Torres', '+56907654321', 'Diagonal Paraguay N° 406', '1986-08-22', '2023-12-10', 'ana.torres@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-70.641562 -33.442884)'), 4326)),
    ('Gonzalo', 'Ramírez', '+56909876543', 'Artesanos N° 750', '1998-02-10', '2023-12-13', 'gonzalo.ramirez@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-70.650925 -33.431587)'), 4326)),
    ('Camila', 'Silva', '+56901234567', 'Av. Einstein Nº 684', '1991-06-25', '2023-12-16', 'camila.silva@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-70.645477 -33.405472)'), 4326)),
    ('Ricardo', 'Fuentes', '+56907654321', 'Calle San Joaquín 291, Rancagua', '1984-12-15', '2023-12-19', 'ricardo.fuentes@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-70.7015 -34.1725)'), 4326)),
    ('Lorena', 'Herrera', '+56909876543', 'Union Obrera, 284 1048 Rancagua', '1997-10-08', '2023-12-22', 'lorena.herrera@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-70.73225982995358 -34.166472476475676)'), 4326)),
    ('Pablo', 'Cáceres', '+56901234567', 'Calle 3 Norte 346, Talca', '1989-03-28', '2023-12-25', 'pablo.caceres@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-71.6618 -35.4271)'), 4326)),
    ('Catalina', 'Vargas', '+56907654321', 'San Pedro Nolasco 380, Concepción,', '1994-07-03', '2023-12-28', 'catalina.vargas@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-73.0457 -36.7777)'), 4326)),
    ('Felipe', 'Mendoza', '+56909876543', 'Aníbal Pinto 335, Concepción', '1987-11-18', '2023-12-31', 'felipe.mendoza@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-73.0489 -36.8279)'), 4326)),
    ('Isabel', 'Ortiz', '+56901234567', 'Doñigue 620, Punta Arenas', '1996-05-05', '2023-11-18', 'isabel.ortiz@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-70.9499 -53.12011)'), 4326)),
    ('Martín', 'Lara', '+56907654321', 'Pasaje Antonio Benedicto Cebrian 621, Punta Arenas', '1990-09-12', '2023-11-21', 'martin.lara@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-70.9167 -53.15)'), 4326)),
    ('Javiera', 'Rojas', '+56909876543', 'Regimiento Reforzado Nº20, Antofagasta', '1982-02-28', '2023-11-24', 'javiera.rojas@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-70.4163 -23.6870)'), 4326)),
    ('Nicolás', 'Gutiérrez', '+56901234567', 'Venezuela 894, Antofagasta', '1981-07-15', '2023-11-27', 'nicolas.gutierrez@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-70.4001 -23.6524)'), 4326)),
    ('Valentina', 'Hidalgo', '+56907654321', 'Manuel Bulnes 110, Iquique', '1989-12-03', '2023-11-30', 'valentina.hidalgo@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW', ST_SetSRID(ST_GeomFromText('POINT(-70.1357 -20.2208)'), 4326));

INSERT INTO habilidad (nombre_habilidad)
VALUES
    ('Primeros Auxilios'),
    ('Rescate Acuático'),
    ('Manejo de Equipos de Emergencia'),
    ('Atención Médica Avanzada');


INSERT INTO institucion (nombre_institucion)
VALUES
    ('Cruz Roja'),
    ('Fundación de Ayuda Humanitaria'),
    ('Protección Civil de Chile');


INSERT INTO coordinador (nombre_coordinador, apellido_coordinador, id_institucion, email_coordinador, password_coordinador)
VALUES
	-- $2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW es encriptacion para 12345678
    ('Luis', 'Sánchez', 1, 'luis@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW'),
    ('Ana', 'Rodríguez', 2, 'ana@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW'),
    ('Carlos', 'Martínez', 3, 'carlos@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW'),
    ('Isabel', 'Gómez', 1, 'isabel@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW');


INSERT INTO vol_habilidad (id_voluntario, id_habilidad)
VALUES
    (1, 1), -- Voluntario 1 tiene Habilidad 1
    (1, 2), -- Voluntario 1 tiene Habilidad 2
    (1, 3), -- Voluntario 1 tiene Habilidad 3
    (1, 4), -- Voluntario 1 tiene Habilidad 4
    (2, 1), -- Voluntario 2 tiene Habilidad 1
    (2, 2), -- Voluntario 2 tiene Habilidad 2
    (3, 3), -- Voluntario 3 tiene Habilidad 3
    (3, 4), -- Voluntario 3 tiene Habilidad 4
    (4, 1), -- Voluntario 4 tiene Habilidad 1
    (4, 2), -- Voluntario 4 tiene Habilidad 2
    (5, 3), -- Voluntario 5 tiene Habilidad 3
    (5, 4); -- Voluntario 5 tiene Habilidad 4


INSERT INTO emergencia (nombre_emergencia, descripcion_emergencia, fecha_creacion_emergencia, id_coordinador, id_institucion, estado_emergencia, geom_emergencia)
VALUES
    ('Incendio Forestal', 'Emergencia por fuego en bosque', '2023-10-19 14:30:00', 1, 1, false, ST_SetSRID(ST_GeomFromText('POINT(-70.692909 -33.444485)'), 4326)), -- Coordinador 1 e Institución 1
    ('Inundación', 'Emergencia por inundaciones', '2023-10-20 12:15:00', 2, 2, true, ST_SetSRID(ST_GeomFromText('POINT(-70.650925 -33.431587)'), 4326)), -- Coordinador 2 e Institución 2
    ('Terremoto', 'Emergencia sísmica', '2023-10-21 09:45:00', 3, 3, false, ST_SetSRID(ST_GeomFromText('POINT(-70.650925 -33.431587)'), 4326)), -- Coordinador 3 e Institución 3
    ('Deslizamiento de tierra', 'Emergencia por deslizamiento', '2023-10-22 17:20:00', 4, 1, true, ST_SetSRID(ST_GeomFromText('POINT(-70.650925 -33.431587)'), 4326)); -- Coordinador 4 e Institución 1


INSERT INTO eme_habilidad (id_eme_habilidad, id_emergencia, id_habilidad)
VALUES
    (1, 1, 1), -- Emergencia 1 tiene Habilidad 1
    (2, 1, 2), -- Emergencia 1 tiene Habilidad 2
    (3, 2, 3), -- Emergencia 2 tiene Habilidad 3
    (4, 2, 4), -- Emergencia 2 tiene Habilidad 4
    (5, 3, 1), -- Emergencia 3 tiene Habilidad 1
    (6, 3, 3), -- Emergencia 3 tiene Habilidad 3
    (7, 4, 2), -- Emergencia 4 tiene Habilidad 2
    (8, 4, 4); -- Emergencia 4 tiene Habilidad 4

INSERT INTO tarea (descripcion_tarea, id_emergencia, estado_tarea)
VALUES
    ('Evacuación de Zona A', 1, TRUE),
    ('Control de Fuego', 1, FALSE),
    ('Asistencia Médica', 2, TRUE),
    ('Rescate Acuático', 2, FALSE),
    ('Búsqueda y Rescate', 3, TRUE),
    ('Control de Fuego', 4, FALSE);


INSERT INTO tarea_habilidad (id_tarea, id_habilidad, puntaje_tarea_habilidad)
VALUES
    (1, 1, 90),
	(1, 3, 90),
    (2, 2, 80),
    (3, 2, 85),
    (4, 4, 75),
    (4, 3, 95);


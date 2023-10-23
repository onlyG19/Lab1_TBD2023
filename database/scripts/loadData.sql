-- noinspection SqlNoDataSourceInspectionForFile

--------------------------------------------------- CARGA DE DATOS -------------------------------------------------
INSERT INTO voluntario (nombre_voluntario, apellido_voluntario, telefono_voluntario, direccion_voluntario, fecha_nacimiento_voluntario, disponibilidad_voluntario, email_voluntario, password_voluntario)
VALUES
	-- $2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW es encriptacion para 12345678
    ('Manuel', 'Pérez', '+56912345678', 'Calle Los Pinos 123', '1990-05-10', '2023-10-19', 'manuel@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW'),
    ('María', 'López', '+56998765432', 'Avenida Central 456', '1988-08-15', '2023-10-20', 'maria@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW'),
    ('Alejandro', 'González', '+56976543210', 'Ruta del Mar 789', '1995-03-22', '2023-10-21', 'alejandro@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW'),
    ('Isabel', 'Torres', '+56955555555', 'Avenida del Sol 987', '1987-12-05', '2023-10-22', 'isabel@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW'),
    ('Felipe', 'Vega', '+56933333333', 'Calle de las Flores 234', '1992-06-30', '2023-10-23', 'felipe@example.com', '$2a$10$.PUQRDWaQhRXEEepitbtl.Qgt6qm2GdduFrOdZ88Bo4VMQQapNmPW');

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


INSERT INTO emergencia (nombre_emergencia, descripcion_emergencia, fecha_creacion_emergencia, id_coordinador, id_institucion, estado_emergencia)
VALUES
    ('Incendio Forestal', 'Emergencia por fuego en bosque', '2023-10-19 14:30:00', 1, 1, false), -- Coordinador 1 e Institución 1
    ('Inundación', 'Emergencia por inundaciones', '2023-10-20 12:15:00', 2, 2, true), -- Coordinador 2 e Institución 2
    ('Terremoto', 'Emergencia sísmica', '2023-10-21 09:45:00', 3, 3, false), -- Coordinador 3 e Institución 3
    ('Deslizamiento de tierra', 'Emergencia por deslizamiento', '2023-10-22 17:20:00', 4, 1, true); -- Coordinador 4 e Institución 1


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


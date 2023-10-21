-- noinspection SqlNoDataSourceInspectionForFile

--------------------------------------------------- CARGA DE DATOS -------------------------------------------------
INSERT INTO voluntario (id_voluntario, nombre_voluntario, apellido_voluntario, telefono_voluntario, direccion_voluntario, fecha_nacimiento_voluntario, disponibilidad_voluntario, email_voluntario, password_voluntario)
VALUES
    (1, 'Manuel', 'Pérez', '+56912345678', 'Calle Los Pinos 123', '1990-05-10', '2023-10-19', 'manuel@example.com', 'contraseña123'),
    (2, 'María', 'López', '+56998765432', 'Avenida Central 456', '1988-08-15', '2023-10-20', 'maria@example.com', 'clave456'),
    (3, 'Alejandro', 'González', '+56976543210', 'Ruta del Mar 789', '1995-03-22', '2023-10-21', 'alejandro@example.com', 'miclave123'),
    (4, 'Isabel', 'Torres', '+56955555555', 'Avenida del Sol 987', '1987-12-05', '2023-10-22', 'isabel@example.com', 'clave1234'),
    (5, 'Felipe', 'Vega', '+56933333333', 'Calle de las Flores 234', '1992-06-30', '2023-10-23', 'felipe@example.com', 'contrasena5678');

INSERT INTO habilidad (id_habilidad, nombre_habilidad)
VALUES
    (1, 'Primeros Auxilios'),
    (2, 'Rescate Acuático'),
    (3, 'Manejo de Equipos de Emergencia'),
    (4, 'Atención Médica Avanzada');


INSERT INTO institucion (id_institucion, nombre_institucion)
VALUES
    (1, 'Cruz Roja'),
    (2, 'Fundación de Ayuda Humanitaria'),
    (3, 'Protección Civil de Chile');


INSERT INTO coordinador (id_coordinador, nombre_coordinador, apellido_coordinador, id_institucion, email_coordinador, password_coordinador)
VALUES
    (1, 'Luis', 'Sánchez', 1, 'luis@example.com', 'clave123'),
    (2, 'Ana', 'Rodríguez', 2, 'ana@example.com', 'clave456'),
    (3, 'Carlos', 'Martínez', 3, 'carlos@example.com', 'clave789'),
    (4, 'Isabel', 'Gómez', 1, 'isabel@example.com', 'clave101112');


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


INSERT INTO emergencia (id_emergencia, nombre_emergencia, descripcion_emergencia, fecha_creacion_emergencia, id_coordinador, id_institucion, estado_emergencia)
VALUES
    (1, 'Incendio Forestal', 'Emergencia por fuego en bosque', '2023-10-19 14:30:00', 1, 1, false), -- Coordinador 1 e Institución 1
    (2, 'Inundación', 'Emergencia por inundaciones', '2023-10-20 12:15:00', 2, 2, true), -- Coordinador 2 e Institución 2
    (3, 'Terremoto', 'Emergencia sísmica', '2023-10-21 09:45:00', 3, 3, false), -- Coordinador 3 e Institución 3
    (4, 'Deslizamiento de tierra', 'Emergencia por deslizamiento', '2023-10-22 17:20:00', 4, 1, true); -- Coordinador 4 e Institución 1


INSERT INTO emergencia_log (id_emergencia, operacion_emergencia_log, id_coordinador, consulta_emergencia_log)
VALUES
    (1, 'Creación de emergencia', 1, 'Ninguna consulta'),
    (2, 'Actualización de emergencia', 2, 'Detalles de la situación actualizados'),
    (3, 'Registro de incidente', 3, 'Reporte de daños y víctimas'),
    (4, 'Respuesta a emergencia', 4, 'Coordinación de equipos en el terreno');


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

INSERT INTO tarea (id_tarea, descripcion_tarea, id_emergencia, estado_tarea)
VALUES
    (1, 'Evacuación de Zona A', 1, TRUE),
    (2, 'Control de Fuego', 1, FALSE),
    (3, 'Asistencia Médica', 2, TRUE),
    (4, 'Rescate Acuático', 2, FALSE),
    (5, 'Búsqueda y Rescate', 3, TRUE),
    (6, 'Control de Fuego', 4, FALSE);


INSERT INTO tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad, puntaje_tarea_habilidad)
VALUES
    (1, 1, 1, 90),
    (2, 2, 2, 80),
    (3, 3, 2, 85),
    (4, 4, 4, 75),
    (5, 4, 3, 95);

INSERT INTO ranking (id_ranking, id_voluntario, posicion_ranking, id_tarea, asignado_ranking)
VALUES
    (1, 1, 1, 1, TRUE),
    (2, 2, 2, 1, TRUE),
    (3, 3, 3, 1, TRUE),
    (4, 4, 4, 1, FALSE),
    (5, 5, 5, 1, TRUE),
    (6, 1, 6, 2, FALSE),
    (7, 2, 2, 2, FALSE);

-------------------------------------------------- Variables para auditar -------------------------------------------
SET app.id_coordinador_editor = '10';

-------------------------------------------------- Consulta UPDATE --------------------------------------------------
UPDATE public.emergencia SET descripcion_emergencia='NUEVA DESC 30' WHERE id_emergencia=1;
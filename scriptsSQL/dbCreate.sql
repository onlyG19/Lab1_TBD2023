CREATE EXTENSION IF NOT EXISTS postgis;

CREATE TABLE IF NOT EXISTS voluntario(
    id_voluntario serial PRIMARY KEY,
    nombre varchar(255),
    apellido VARCHAR(255),
    email VARCHAR(255),
    telefono VARCHAR(15),
    direccion VARCHAR(255),
    fecha_de_nacimiento DATE,
    genero VARCHAR(10),
    ranking int,
    ubicacion_voluntario GEOMETRY(Point, 4326),
    id_coordinador_asignado INT,
    CONSTRAINT fk_coordinador_asignado
        FOREIGN KEY (id_coordinador_asignado)
        REFERENCES voluntario(id_voluntario)
);

CREATE TABLE IF NOT EXISTS habilidad(
    id_habilidad serial PRIMARY KEY,
    nombre_habilidad varchar(255)
);

CREATE TABLE IF NOT EXISTS vol_habilidad (
    id_vol_habilidad serial PRIMARY KEY,
    id_voluntario int, -- Referencia al voluntario (clave foránea)
    id_habilidad int,  -- Referencia a la habilidad (clave foránea)
    CONSTRAINT fk_vol_habilidad_voluntario
        FOREIGN KEY (id_voluntario)
        REFERENCES voluntario(id_voluntario),
    CONSTRAINT fk_vol_habilidad_habilidad
        FOREIGN KEY (id_habilidad)
        REFERENCES habilidad(id_habilidad)
);

CREATE TABLE IF NOT EXISTS emergencia (
    id_emergencia serial PRIMARY KEY,
    nombre_emergencia varchar(255),
    descripcion varchar(255),
    fecha_hora_creacion timestamp,
    ubicacion_emergencia GEOMETRY(Point, 4326),
    id_coordinador INT NOT NULL, -- ID del coordinador que crea la emergencia
    CONSTRAINT fk_emergencia_coordinador
        FOREIGN KEY (id_coordinador)
        REFERENCES voluntario(id_voluntario)
);

CREATE TABLE IF NOT EXISTS eme_habilidad (
    id_eme_habilidad serial PRIMARY KEY,
    id_emergencia INT, -- Referencia a la emergencia (clave foránea)
    id_habilidad INT,  -- Referencia a la habilidad (clave foránea)
    CONSTRAINT fk_eme_habilidad_emergencia
        FOREIGN KEY (id_emergencia)
        REFERENCES emergencia(id_emergencia),
    CONSTRAINT fk_eme_habilidad_habilidad
        FOREIGN KEY (id_habilidad)
        REFERENCES habilidad(id_habilidad)
);

CREATE TABLE IF NOT EXISTS institucion(
    id_institucion serial PRIMARY KEY,
    nombre_institucion varchar(255)
);

CREATE TABLE IF NOT EXISTS estado_tarea(
    id_estado_tarea serial PRIMARY KEY,
    nombre_estado varchar(32)
);


CREATE TABLE IF NOT EXISTS tarea (
    id_tarea serial PRIMARY KEY,
    descripcion varchar(255),
    fecha_asignacion date,
    id_emergencia INT, -- Referencia a la emergencia (clave foránea)
    id_estado_tarea INT, -- Referencia al estado de la tarea (clave foránea)
    CONSTRAINT fk_tarea_emergencia
        FOREIGN KEY (id_emergencia)
        REFERENCES emergencia(id_emergencia),
    CONSTRAINT fk_tarea_estado_tarea
        FOREIGN KEY (id_estado_tarea)
        REFERENCES estado_tarea(id_estado_tarea)
);

CREATE TABLE IF NOT EXISTS tarea_habilidad (
    id_tarea_habilidad serial PRIMARY KEY,
    id_tarea INT, -- Referencia a la tarea (clave foránea)
    id_habilidad INT, -- Referencia a la habilidad (clave foránea)
    CONSTRAINT fk_tarea_habilidad_tarea
        FOREIGN KEY (id_tarea)
        REFERENCES tarea(id_tarea),
    CONSTRAINT fk_tarea_habilidad_habilidad
        FOREIGN KEY (id_habilidad)
        REFERENCES habilidad(id_habilidad)
);

CREATE TABLE IF NOT EXISTS ranking (
    id_ranking serial PRIMARY KEY,
    id_voluntario INT, -- Referencia al voluntario (clave foránea)
    puntuacion INT,
    fecha timestamp,
    CONSTRAINT fk_ranking_voluntario
        FOREIGN KEY (id_voluntario)
        REFERENCES voluntario(id_voluntario)
);


--CREATE EXTENSION IF NOT EXISTS postgis;

CREATE TABLE IF NOT EXISTS voluntario(
    id_voluntario SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    email VARCHAR(255),
    telefono VARCHAR(15),
    direccion VARCHAR(255),
    fecha_de_nacimiento DATE,
    genero VARCHAR(10),
    ranking INT,
    --ubicacion_voluntario GEOMETRY(Point, 4326),
    id_coordinador_asignado INT,
    CONSTRAINT fk_coordinador_asignado
        FOREIGN KEY (id_coordinador_asignado)
        REFERENCES voluntario(id_voluntario)
);

CREATE TABLE IF NOT EXISTS coordinador(
    id_coordinador SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    estado_salud VARCHAR (32);
    
)


CREATE TABLE IF NOT EXISTS habilidad(
    id_habilidad SERIAL PRIMARY KEY,
    nombre_habilidad VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS institucion(
    id_institucion SERIAL PRIMARY KEY,
    nombre_institucion VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS estado_tarea(
    id_estado_tarea SERIAL PRIMARY KEY,
    nombre_estado VARCHAR(32)
);

CREATE TABLE IF NOT EXISTS vol_habilidad (
    id_vol_habilidad SERIAL PRIMARY KEY,
    id_voluntario INT, -- Referencia al voluntario (clave foránea)
    id_habilidad INT,  -- Referencia a la habilidad (clave foránea)
    CONSTRAINT fk_vol_habilidad_voluntario
        FOREIGN KEY (id_voluntario)
        REFERENCES voluntario(id_voluntario),
    CONSTRAINT fk_vol_habilidad_habilidad
        FOREIGN KEY (id_habilidad)
        REFERENCES habilidad(id_habilidad)
);

CREATE TABLE IF NOT EXISTS emergencia (
    id_emergencia SERIAL PRIMARY KEY,
    nombre_emergencia VARCHAR(255),
    descripcion VARCHAR(255),
    fecha_hora_creacion TIMESTAMP,
    --ubicacion_emergencia GEOMETRY(Point, 4326),
    id_coordinador INT NOT NULL, -- ID del coordinador que crea la emergencia
    id_institucion INT NOT NULL, -- ID de la institucion que proviene la creacion de la emergencia
    CONSTRAINT fk_emergencia_coordinador
        FOREIGN KEY (id_coordinador)
        REFERENCES voluntario(id_voluntario),
    CONSTRAINT fk_emergencia_institucion
        FOREIGN KEY (id_institucion)
        REFERENCES institucion(id_institucion)
);

CREATE TABLE IF NOT EXISTS eme_habilidad (
    id_eme_habilidad SERIAL PRIMARY KEY,
    id_emergencia INT, -- Referencia a la emergencia (clave foránea)
    id_habilidad INT,  -- Referencia a la habilidad (clave foránea)
    CONSTRAINT fk_eme_habilidad_emergencia
        FOREIGN KEY (id_emergencia)
        REFERENCES emergencia(id_emergencia),
    CONSTRAINT fk_eme_habilidad_habilidad
        FOREIGN KEY (id_habilidad)
        REFERENCES habilidad(id_habilidad)
);

CREATE TABLE IF NOT EXISTS tarea (
    id_tarea SERIAL PRIMARY KEY,
    descripcion VARCHAR(255),
    fecha_asignacion DATE,
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
    id_tarea_habilidad SERIAL PRIMARY KEY,
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
    id_ranking SERIAL PRIMARY KEY,
    id_voluntario INT, -- Referencia al voluntario (clave foránea)
    puntuacion INT,
    fecha TIMESTAMP,
    CONSTRAINT fk_ranking_voluntario
        FOREIGN KEY (id_voluntario)
        REFERENCES voluntario(id_voluntario)
);
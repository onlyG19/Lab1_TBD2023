--------------------------- Agregar Extension Postgis ------------------------
CREATE EXTENSION IF NOT EXISTS postgis;


--------------------------- Creación de tablas ---------------------------------
CREATE TABLE IF NOT EXISTS voluntario(
    id_voluntario SERIAL PRIMARY KEY,
    nombre_voluntario VARCHAR(255),
    apellido_voluntario VARCHAR(255),
    telefono_voluntario VARCHAR(15),
    direccion_voluntario VARCHAR(255),
    fecha_nacimiento_voluntario DATE,
    disponibilidad_voluntario DATE, -- Referente a un día en particular por simplicidad
	email_voluntario VARCHAR(255),
	password_voluntario VARCHAR(255),
    geom GEOMETRY(Point, 4326)
);

CREATE TABLE IF NOT EXISTS habilidad(
    id_habilidad SERIAL PRIMARY KEY,
    nombre_habilidad VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS institucion(
    id_institucion SERIAL PRIMARY KEY,
    nombre_institucion VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS coordinador(
    id_coordinador SERIAL PRIMARY KEY,
    nombre_coordinador VARCHAR(255),
    apellido_coordinador VARCHAR(255),
    id_institucion INT, -- Referencia a la instución del coordinador
	email_coordinador VARCHAR(255),
	password_coordinador VARCHAR(255),
	CONSTRAINT fk_coordinador_institucion
        FOREIGN KEY (id_institucion)
        REFERENCES institucion(id_institucion)
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
    descripcion_emergencia VARCHAR(255),
    fecha_creacion_emergencia TIMESTAMP,
    id_coordinador INT NOT NULL, -- ID del coordinador que crea la emergencia
    id_institucion INT NOT NULL, -- ID de la institucion que proviene la creacion de la emergencia
    estado_emergencia BOOLEAN NOT NULL,
    geom_emergencia GEOMETRY(Polygon, 4326),
    CONSTRAINT fk_emergencia_coordinador
        FOREIGN KEY (id_coordinador)
        REFERENCES coordinador(id_coordinador),
    CONSTRAINT fk_emergencia_institucion
        FOREIGN KEY (id_institucion)
        REFERENCES institucion(id_institucion)
);

CREATE TABLE IF NOT EXISTS emergencia_log (
	id_emergencia_log SERIAL PRIMARY KEY,
	id_emergencia INT,
	operacion_emergencia_log VARCHAR(255),
	id_coordinador INT,
	consulta_emergencia_log TEXT,
	timestamp TIMESTAMPTZ DEFAULT NOW()
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
    descripcion_tarea VARCHAR(255),
    id_emergencia INT, -- Referencia a la emergencia (clave foránea)
    estado_tarea BOOL, -- Referencia al estado de la tarea (clave foránea)
    CONSTRAINT fk_tarea_emergencia
        FOREIGN KEY (id_emergencia)
        REFERENCES emergencia(id_emergencia)
);

CREATE TABLE IF NOT EXISTS tarea_habilidad (
    id_tarea_habilidad SERIAL PRIMARY KEY,
    id_tarea INT, -- Referencia a la tarea (clave foránea)
    id_habilidad INT, -- Referencia a la habilidad (clave foránea)
	puntaje_tarea_habilidad INT,
    CONSTRAINT fk_tarea_habilidad_tarea
        FOREIGN KEY (id_tarea)
        REFERENCES tarea(id_tarea)
);

CREATE TABLE IF NOT EXISTS ranking (
    id_ranking SERIAL PRIMARY KEY,
    id_voluntario INT, -- Referencia al voluntario (clave foránea)
    posicion_ranking INT, -- Valor que indica el lugar en el ranking para esa tarea
    id_tarea INT,
	asignado_ranking BOOL, -- Bool que indica si la tarea fue asignada al voluntario
    CONSTRAINT fk_ranking_voluntario
        FOREIGN KEY (id_voluntario)
        REFERENCES voluntario(id_voluntario),
	CONSTRAINT fk_ranking_tarea
        FOREIGN KEY (id_tarea)
        REFERENCES tarea(id_tarea)
);

--------------------------------- Triggers ---------------------------------------

CREATE OR REPLACE FUNCTION funcion_log()
RETURNS TRIGGER AS $$
DECLARE
	id_coordinador_editor INT;
	query_text TEXT;
BEGIN 
	IF (TG_OP = 'UPDATE') THEN
		-- id_coordinador_editor := current_setting('app.id_coordinador_editor', true)::INT; -- Se extrae la id del coordinador editor
		
		query_text = 'UPDATE emergencia SET id_emergencia=' || NEW.id_emergencia || ', nombre_emergencia="' || NEW.nombre_emergencia ||
		'", descripcion_emergencia="' || NEW.descripcion_emergencia || '", fecha_creacion_emergencia=' || NEW.fecha_creacion_emergencia || 
		', id_coordinador=' || NEW.id_coordinador || ', id_institucion=' || NEW.id_institucion || ', estado_emergencia=' || NEW.estado_emergencia ||
		' WHERE id_emergencia =' || NEW.id_emergencia;
		
		INSERT INTO emergencia_log (id_emergencia, operacion_emergencia_log, 
								   id_coordinador, consulta_emergencia_log)
		VALUES (OLD.id_emergencia, 'UPDATE', OLD.id_coordinador, query_text); 
	END IF;
	RETURN NEW;
END
$$ LANGUAGE plpgsql;

CREATE TRIGGER log_trigger
AFTER UPDATE ON emergencia
FOR EACH ROW
EXECUTE FUNCTION funcion_log();

SET pg_stat_statements.enabled = on;



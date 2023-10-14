--------------------------------------------------- CARGA DE DATOS -------------------------------------------------
INSERT INTO public.institucion(
	id_institucion, nombre_institucion)
	VALUES (1, 'COLEGIO DE RESCATISTAS');
	
INSERT INTO public.coordinador(
	id_coordinador, nombre_coordinador, apellido_coordinador, id_institucion, email_coordinador, "contraseña_coordinador")
	VALUES (1, 'JUAN', 'MONTESUR', 1, 'a@a', '1234');
	
INSERT INTO public.emergencia(
	id_emergencia, nombre_emergencia, descripcion_emergencia, fecha_creacion_emergencia, id_coordinador, id_institucion)
	VALUES (1, 'DERRUMBE', 'DERRUMBE EN VALPARAISO', '2023-10-14', 1, 1);

-------------------------------------------------- Variables para auditar -------------------------------------------
SET app.id_coordinador_editor = '10';

-------------------------------------------------- Consulta UPDATE --------------------------------------------------
UPDATE public.emergencia SET descripcion_emergencia='NUEVA DESC 30' WHERE id_emergencia=1;
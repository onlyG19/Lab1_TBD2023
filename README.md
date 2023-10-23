### Lab1_TBD2023
Proyecto para el Laboratorio del curso Taller de Base de Datos 02-2023

## Instrucciones para correr el proyecto

# Prerrequisitos
Se debe contar con las siguientes tecnologías para la ejecución optima del proyecto:
	
	• PgAdmin4
	• Node.js
	• IDE Intellij
	• JDK 17
	• Postgres 12


# Clonar el Repositorio
Se debe clonar o descargar el proyecto desde GitHub, la URL al repositorio del proyecto es https://github.com/onlyG19/Lab1_TBD2023


# Base de Datos
Se debe crear una base de datos llamada postgres1, luego es necesario utilizando PgAdmin4
correr los archivos de script que se encuentran en la ruta database/scripts en el siguiente orden:
	1- dbCreate.sql : Es el archivo que contiene la creación de tablas y el trigger

	2- functions.sql : Aquí se encuentran la función de conteo de tareas activas y las de ranking

	3- storedProcedures.sql : Aquí está el procedimiento almacenado para los reportes

	4- loadData.sql : Finalmente en este archivo están las inserciones para tener datos
	con los que trabajar

Nota: Los scripts debes ejecutarse sobre la base de datos previamente creada, como ya se
mencionó esta debe tener el nombre de postgres1.

# Backend
Dentro del directorio base del repositorio tenemos una carpeta src, luego debe acceder a la carpeta del backend homónima. Idealmente se debe abrir esta carpeta de backend con el IDE Intellij.

Una vez abierto el proyecto, en la carpeta src/main/resources/ se tiene un archivo llamado application.properties. Aquí se deben asignar ó reemplazar, de ser necesario, las credenciales de acceso a la base de datos postgres (usuario, contraseña y url de la base de datos).

Nota: Es importante que la configuración de application.properties coincida con el detalle de nuestra base de datos. Además, por defecto el puerto del server backend es 8080.

Para ejecutar el código se debe abrir la carpeta raíz del proyecto de ruta Lab1_TBD2023/src/backend con el IDE Intellij y abrir el archivo BackendApplication.java y presionar el boton de play verde “Run” en el editor.

Notar que antes de ejecutar la aplicación se deben instalar las dependencias. A través del IDE Intellij, se pueden instalar automáticamente utilizando el plugin de Maven
durante la operación de build.

# Frontend
El código fuente de la parte del frontend del proyecto se encuentra en la carpeta src del
directorio raíz del repositorio, cuidar de abrir src/frontend/frontend-lab1.

Antes de poder ejecutar el frontend se deben instalar las dependencias en una consola
utilizando el siguiente comando:

	npm install

Luego, para poder ejecutar un servidor web de pruebas para el frontend se utiliza el siguiente código:

	npm run dev

Si se ejecutó lo anterior sin problemas, a continuación se podrá visualizar la interfaz gráfica de la aplicación en el navegador donde se encontraran las vistas del sistema. Por defecto se puede acceder al frontend en con la url http://localhost:3030/

Tener en cuenta que para el correcto funcionamiento se debe estar corriendo el backend
y la base de datos debe contener la información que se provee en los scripts.

## Instrucciones de uso Funcionalidades

- Login y registro para voluntario y coordinador: Se acceden desde el frontend, en la vista principal en la esquina superior derecha se encuentra el botón "Iniciar Sesión",
al centro de la vista principal se encuentra el botón "Regístrate!"

- Vista de emergencias y botón de activar/desactivar: Para interactuar con esta funcionalidad, apretar las 3 lineas de la esquina superior izquierda, esto despliega
el componente drawer, donde entre otras cosas se encuentra el botón para visualizar emergencias. 

Alternativamente al hacer inicio de sesión con un usuario coordinador redirecciona automáticamente a la vista de emergencias.

Para activar o desactivar la emergencia basta con hacer click en el botón que se encuentra en la tarjeta de la emergencia respectiva.

Se puede acceder a la lista de Tareas asociadas a la emergencia apretando el menú debajo del botón activar/desactivar

- Trigger: Existe un único trigger el cual se encarga de registrar los cambios hechos a la tabla de emergencia, para ver la acción de este trigger se recomiendan los siguientes pasos:
	1. Iniciar sesión con usuario coordinador 
	(por ejemplo, correo: luis@example.com, contraseña: 12345678)
	2. Activar/Desactivar una emergencia
	3. Ver la tabla emergencia_log la cual guarda los datos obtenidos por el trigger

- Reporte: En el archivo storedProcedures.sql se encuentra comentada una consulta que acciona al procedimiento almacenado, alternativamente se puede abrir la herramienta query tool dentro de la base de datos postgres1 para correr la consulta:
	
	SELECT * FROM reporte_emergencia(); 

La cual muestra la tabla simple de reporte que cuenta con, id de coordinador que genera el cambio, la operación que se hace a la tabla, en este caso siempre son del tipo UPDATE y finalmente la cantidad de operaciones realizadas.

- Funciones de ranking: Existen 2 funciones de ranking distintas que cumplen roles similares, rankingLite(id_tarea, c_voluntarios); que se encarga de mostrar una tabla de rankings simplificada, esto a través de entregar los datos en formato JSON, luego está rankingFull(id_tarea, c_voluntarios); que genera un cálculo general pero en lugar de mostrar la información, inserta la misma en la tabla ranking de la base de datos

Para utilizarlas seguir los siguientes pasos utilizando Postman:

	1. Poner en marcha el backend
	2. En Postman elegir cual de las 2 funcionalidades se quiere utilizar
		a. En caso de querer rankingLite();, escribir la ruta: 
		http://localhost:8080/ranking/listaRanking/{id_tarea}/{c_voluntario}
		a1. Reemplazar {id_tarea} con el valor de la id de la tarea solicitada
		y {c_voluntario} con la cantidad de voluntarios requeridos
		a2. Enviar la consulta en formato GET, si quisieramos por ejemplo 3 voluntarios para la tarea de id 1, debería verse así
		GET: http://localhost:8080/ranking/listaRanking/1/3
		a3. Observar los contenidos en la consola de Postman

		b. En caso de querer rankingFull();, escribir la ruta: 
		http://localhost:8080/ranking/full_ranking/{id_tarea}/{c_voluntario}
		b1. Reemplazar {id_tarea} con el valor de la id de la tarea solicitada
		y {c_voluntario} con la cantidad de voluntarios requeridos
		b2. Enviar la consulta en formato GET, si quisieramos por ejemplo 3 voluntarios para la tarea de id 1, debería verse así
		POST: http://localhost:8080/ranking/listaRanking/1/3
# Gestión de Estudiantes 🎓📚

¡Bienvenido/a al sistema de Gestión de Estudiantes! Este mini proyecto (MP) es una simulación de una base de datos para la gestión de estudiantes, implementada en Java con enfoque en POO, polimorfismo y listas.

## Objetivo 🎯

El objetivo de este proyecto es permitir la gestión de estudiantes. Los usuarios podrán registrar nuevos estudiantes, actualizar su información, eliminar estudiantes y ver la lista completa de estudiantes registrados. Además, podrán buscar estudiantes por nombre o apellido, y refrescar la pantalla.

## Características ✨

- Tablero de Estudiantes: [x] Muestra los estudiantes con información breve como nombre, apellidos y correo. Permite visualizar todos los datos de un estudiante y editarlos. También permite seleccionar estudiantes para eliminarlos.
- Registro de Estudiantes: [x] Permite agregar nuevos estudiantes a la base de datos. Cada estudiante debe tener un nombre, apellido, fecha de nacimiento, número de documento de identidad, correo electrónico, imagen de perfil, peso, altura, género, hobbies y turno.
- Actualización de Estudiantes: [x] Permite actualizar la información de un estudiante existente en la base de datos, incluyendo el estado (activo o inactivo).
- Eliminación de Estudiantes: [x] Permite eliminar estudiantes de la base de datos.
- Búsqueda de Estudiantes: [x] Permite buscar estudiantes por nombre o apellido.

## Requisitos 🛠️

- Java Development Kit (JDK) 8 o superior.
- NetBeans IDE (opcional, pero recomendado para facilidad de desarrollo).
- MySQL
- JSTL

## Instrucciones de Uso 📖

1. Clona o descarga el repositorio del proyecto desde GitHub.
2. Abre el proyecto en NetBeans o tu IDE preferido.
3. Sigue las instrucciones en pantalla para interactuar con el sistema y gestionar los estudiantes.

## Estructura del Proyecto 🏗️

El proyecto está organizado en los siguientes paquetes y clases:

- estudiantes: Paquete principal del proyecto.
- dao: Contiene las interfaces y clases para el acceso a la base de datos.
- entity: Contiene las clases que representan las entidades de la base de datos.
- test: Contiene las pruebas unitarias.
- util: Contiene las clases de utilidad, como la conexión a la base de datos.
- web: Contiene el servlet y el validador.

## Base de Datos 🗄️

La base de datos consta de las siguientes tablas:

- Estudiante: Tabla principal con campos como id_estudiante, nombre, apellido, fecha_nacimiento, n_doc_identidad, correo, imagen_perfil, peso, altura, genero, turno, fecha_registro, estado.
- Genero: Tabla con campos id_genero, genero.
- Turno: Tabla con campos id_turno, turno.
- Pasatiempo: Tabla con campos id_pasatiempo, pasatiempo.
- EstudPasat: Tabla de intersección entre estudiante y pasatiempo con campos id_estudpasat, estudiante, pasatiempo.
- Estudiante_view: Vista que se asemeja a la tabla estudiante pero diseñada para ser legible, mostrando el turno en lugar del id del turno.

## Tecnologías Utilizadas 🚀

- Java
- NetBeans IDE
- MySQL
- JSTL
- Apache Tomcat
- Servlets
- CSS
- HTML

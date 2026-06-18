=======================================================
   SISTEMA DE INSTITUTO EDUCATIVO
   Programación 1 - Análisis de Sistemas - IFES
=======================================================

Integrantes:
  - Nicolas Fausto
  - Bryan Hernandez
  - Santino Resch

-------------------------------------------------------
DESCRIPCIÓN
-------------------------------------------------------

Sistema de gestión para un instituto educativo desarrollado
en Java aplicando Programación Orientada a Objetos.

Permite registrar y gestionar cursos (Materia, Taller y
Seminario), alumnos y docentes, controlar inscripciones
según el estado de cada curso, y persistir la información
entre ejecuciones mediante serialización.

Funcionalidades principales:
  - Agregar cursos (Materia, Taller, Seminario)
  - Registrar alumnos
  - Inscribir alumnos a cursos
  - Dar de baja inscripciones
  - Mostrar cursos abiertos
  - Mostrar oferta ordenada por nombre
  - Mostrar cantidad de inscriptos por curso
  - Persistencia automática al salir del programa

-------------------------------------------------------
INSTRUCCIONES DE EJECUCIÓN
-------------------------------------------------------

Requisitos:
  - JDK 11 o superior
  - VS Code con Java Extension Pack (recomendado)

Pasos:
  1. Clonar o descargar el repositorio
  2. Abrir la carpeta del proyecto en VS Code
  3. Ejecutar la clase: dominio.main.Main
  4. Interactuar con el menú por consola

Nota: los archivos cursos.dat y personas.dat se generan
automáticamente al salir con la opción 0. No es necesario
crearlos manualmente.

-------------------------------------------------------
ESTRUCTURA DEL PROYECTO
-------------------------------------------------------

  dominio/
    Persona.java        (abstracta, Serializable)
    Alumno.java
    Docente.java
    Curso.java          (abstracta, Serializable)
    Materia.java
    Taller.java
    Seminario.java
    Menu.java

  dominio/interfaces/
    IInscribible.java
    IRepositorio.java

  dominio/main/
    Main.java

  enums/
    EstadoCurso.java    (ABIERTO, CERRADO, CANCELADO)

  excepciones/
    InscripcionException.java

  servicios/
    Instituto.java
    Repositorio.java

=======================================================

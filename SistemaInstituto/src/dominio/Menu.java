package dominio;
import java.util.List;
import java.util.Scanner;

import dominio.interfaces.InscripcionException;
import enums.EstadoCurso;
import servicios.Instituto;

public class Menu {
    private Scanner scanner;
    private Instituto instituto;

    //***CONSTRUCTOR***
    public Menu(){
        this.scanner = new Scanner(System.in);
        this.instituto = new Instituto();
    }

    //***METODOS***
    public void agregarCurso(){
        System.out.println("Que tipo de curso desea agregar?");
        System.out.println();
        System.out.println("1. Materia");
        System.out.println("2. Taller");
        System.out.println("3. Seminario");

        int tipo = scanner.nextInt();

        System.out.println("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.println("Ingrese el cupo maximo");
        int cupoMax = scanner.nextInt();
        
        System.out.println("Ingrese el estado (ABIERTO, CERRADO, CANCELADO):");
        String estadoStr = scanner.nextLine();
        EstadoCurso estado = EstadoCurso.valueOf(estadoStr.toUpperCase());

        switch (tipo) {
            case 1:
                System.out.println("Ingrese las horas semanales:");
                int horas = scanner.nextInt();
                System.out.println("Ingrese correlativa:");
                instituto.agregarCurso(new Materia(0, nombre, cupoMax, 0, estado, horas, estadoStr));
                break;
            case 2:
                System.out.println("Ingresar materiales requeridos:");
                String materiales = scanner.nextLine();
                System.out.println("Es presencial (True/False):");
                boolean esPractico = scanner.nextBoolean();
                instituto.agregarCurso(new Taller(0, nombre, cupoMax, 0, estado, materiales, esPractico));
                break;
            case 3:
                System.out.println("Ingrese duracion de dias:");
                int duracion = scanner.nextInt();
                System.out.println("Es virtual (true/false):");
                boolean esVirtual = scanner.nextBoolean();
                instituto.agregarCurso(new Seminario(0, nombre, cupoMax, 0, estado, duracion, esVirtual));
            default:
                System.out.println("Opcion invalida");
                break;
        }
        System.out.println("Curso agregado exitosamente");
    }

    public void registrarAlumno(){
        System.out.println("Ingrese el dni del alumno:");
        int dni = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nombre del alumno:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido del alumno:");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese el legajo del alumno:");
        int legajo = scanner.nextInt();
        scanner.nextLine();

        Alumno alumno = new Alumno(dni, nombre, apellido, legajo);
        instituto.registrarPersona(alumno);
    }

    public void inscribirAlumno(){
        System.out.println("Ingrese el nombre del alumno");
        int dni = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nombre del curso:");
        String nombre = scanner.nextLine();
        try{
            instituto.InscribirAlumnoACurso(dni, nombre);
        } catch(InscripcionException e) {
            System.out.println("ERROR "+e.getMessage());
        }finally{
            System.out.println("Operacion finalizada");
            System.out.println();
            System.out.println("Cursos inscriptos del alumno:");
            Alumno alumno = instituto.buscarAlumno(dni);
            if (alumno != null) {
                alumno.mostrarCursos();
            }
        }
        
    }

    public void  darDeBaja(){
        System.out.println("Ingrese el dni del alumno:");
        int dni = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nombre del curso al que desea dar de baja:");
        String nombre = scanner.nextLine();

        Alumno alumno = instituto.buscarAlumno(dni);
        Curso curso = instituto.buscarCurso(nombre);
        if (alumno == null || curso == null){
            System.out.println("Alumno o curso no encontrado");
            return;
        }
        alumno.darDeBaja(curso);
    }

    public void mostrarAbiertos(){
        List<Curso> cursosAbirtos = instituto.mostrarCursosAbiertos();
        for (Curso curso:cursosAbirtos){
            curso.monstrarInfo();
        }
    }

    public void mostrarOrdenados(){
        instituto.mostrarCursosOrdenados();
    }
    
    public void mostrarInscriptos(){
        System.out.println("Ingrese el nombre del curso que desea ver:");
        String nombre = scanner.nextLine();
        long cantidad = instituto.contarInscriptos(nombre);
        if(cantidad ==0){
            System.out.println("No hay inscriptos en este curso");
        }else{
            System.out.println("Hay un total de "+cantidad+" inscriptos en este curso");
        }

    }
    
    //**INICIAR
    public void Iniciar(){
        instituto.cargarDatos();
        int opcion; //va a servir para saber que eleccion va a tomar el usuario
        do{
            System.out.println("Bienvenido al programa! Por favor selecione una de las opciones");
            System.out.println();
            System.out.println("1. Agregar curso");
            System.out.println("2. Registrar alumno");
            System.out.println("3. Inscribir alumno");
            System.out.println("4. Dar de baja inscripcion");
            System.out.println("5. Mostrar cursos abiertos");
            System.out.println("6. Mostrar oferta ordenada por nombre");
            System.out.println("7. Mostrar cantidad de inscriptos en el curso");
            System.out.println("0. Salir");
            System.out.println();

            opcion = scanner.nextInt();
            switch (opcion) {
                case 0:
                    instituto.guardarDatos();
                    System.out.println("Saliendo...");
                    System.out.println("El programa a sido finalizado");
                case 1:
                    agregarCurso();
                    break;
                case 2:
                    registrarAlumno();
                    break;
                case 3:
                    inscribirAlumno();
                    break;
                case 4:
                    darDeBaja();
                    break;
                case 5:
                    mostrarAbiertos();
                    break;
                case 6:
                    mostrarOrdenados();
                    break;
                case 7:
                    mostrarInscriptos();
                    break;
                default:
                    System.out.println("Valor ingresado errroneo, intente de nuevo...");
                    break;
            }
        } while (opcion != 0);
    }
}

package dominio;
import java.util.Scanner;

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

    public void inscribirAlumno(){
        System.out.println("Ingrese el nombre del alumno");
        int dni = scanner.nextInt();
        System.out.println("Ingrese el nombre del curso:");
        String nombre = scanner.nextLine();
        instituto.inscribirAlumno();
        instituto.buscarCurso();
    }

    //**INICIAR
    public void Iniciar(){
        int opcion; //va a servir para saber que eleccion va a tomar el usuario
        do{
            System.out.println("Bienvenido al programa! Por favor selecione una de las opciones");
            System.out.println();
            System.out.println("1. Agregar curso");
            System.out.println("2. Inscribir alumno");
            System.out.println("3. Mostrar cursos abiertos");
            System.out.println("0. Salir");
            System.out.println();

            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    agregarCurso();
                    break;
                case 2:

                default:
                    break;
            }
        } while (opcion != 0);
    }
}

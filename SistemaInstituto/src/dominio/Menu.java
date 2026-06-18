package dominio;
import java.util.Scanner;
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
        System.err.println("Ingresar nombre del curso");
        

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
                    
                    break;
            
                default:
                    break;
            }
        } while (opcion != 0);
    }
}

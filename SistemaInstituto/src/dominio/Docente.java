package dominio;

import java.util.ArrayList;

public class Docente extends Persona{
    private String titulo;
    private String area;
    private ArrayList<Curso> listaCursos;
    
    //***CONSTRUCTOR***
    public Docente(int dni, String nombre, String apellido, String titulo, String area){
        super(dni, nombre, apellido);
        this.titulo = titulo;
        this.area = area;
        this.listaCursos = new ArrayList<>();
    }
    //***METODO MOSTRAR INFO***/
    @Override
    public void mostrarInfo() {
        System.out.println("DNI:"+ getDni());    
        System.out.println("Nombre:"+ getNombre());  
        System.out.println("Apellido:"+ getApellido());  
        System.out.println("Titulo:"+ titulo);  
        System.out.println("Area:"+ area);      
    }

    //***METODO REGISTRAR CURSO***/
    //Metodo para que el docente acepte los cursos donde dara clase
    public void registrarCurso(Curso c){
        listaCursos.add(c);
        System.out.println("CURSO:"+ c.getNombre());
        System.out.println("Agregado");
    }

}

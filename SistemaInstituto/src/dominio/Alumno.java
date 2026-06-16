package dominio;
import java.util.ArrayList;

public class Alumno extends Persona{
    private ArrayList<Curso> cursosInscriptos;
    private int legajo;

    public Alumno(int dni, String nombre, String apellido, int legajo){
        super(dni, nombre, apellido);
        this.legajo = legajo;
        this.cursosInscriptos = new ArrayList<>();
    }

    @Override
    public void mostrarInfo() {
        System.out.println("DNI:"+ getDni());    
        System.out.println("Nombre:"+ getNombre());  
        System.out.println("Apellido:"+ getApellido());
        System.out.println("Legajo:"+ legajo);
    }

    public void inscribirCurso(Curso c){
        cursosInscriptos.add(c);
        System.out.println("Curso:"+ c.getNombre());
    }
    public void darDeBaja(){
        
    }
}

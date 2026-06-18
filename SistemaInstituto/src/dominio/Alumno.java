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
        
        //verificar si el alumno posee cursos inscriptos mediante isEmpty()
        if(cursosInscriptos.isEmpty()){
            System.out.println("No se encuentra inscripto a ningun curso");
        }else{
            System.out.println("Cursos inscriptos:");
            for(Curso curso : cursosInscriptos){
                System.out.println("- " + curso.getNombre());
            }
        }
    }

    public void inscribirCurso(Curso c){
        cursosInscriptos.add(c);
        System.out.println("Curso:"+ c.getNombre());
    }
    public void darDeBaja(){
    }

    public ArrayList<Curso> getCursosInscriptos() {
    return cursosInscriptos;
    }

    public int getLegajo() {
    return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

}

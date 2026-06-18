package dominio;
import java.util.ArrayList;
import dominio.interfaces.InscripcionException;
import enums.EstadoCurso;

public class Alumno extends Persona{
    private ArrayList<Curso> cursosInscriptos;
    private int legajo;

    //**CONSTRUCTOR**
    public Alumno(int dni, String nombre, String apellido, int legajo){
        super(dni, nombre, apellido);
        this.legajo = legajo;
        this.cursosInscriptos = new ArrayList<>();
    }
    //**METODO MOSTRAR INFO**
    @Override
    public void mostrarInfo() {
        System.out.println("DNI:"+ getDni());    
        System.out.println("Nombre:"+ getNombre());  
        System.out.println("Apellido:"+ getApellido());
        System.out.println("Legajo:"+ legajo);
    }
    //**METODO INSCRIBIR CURSO**
    public void inscribirCurso(Curso c) throws InscripcionException {
        if(c.getEstado() == EstadoCurso.CERRADO){
            throw new InscripcionException("Inscripcion rechazada. El curso esta cerrado");
        } else if (c.getEstado() == EstadoCurso.CANCELADO){
            throw new InscripcionException("Inscripcion rechazada. El curso a sido cancelado");
        }else if (c.getEstado() == EstadoCurso.ABIERTO){
            cursosInscriptos.add(c);
            System.out.println("Curso:"+ c.getNombre());
        }
    }
    //**METODO DAR DE BAJA**
    public void darDeBaja(Curso c){
        if(!cursosInscriptos.contains(c)){
            System.out.println("El alumno no esta inscripto a la materia");
        }else {
            cursosInscriptos.remove(c);
        }
    }
    //**METODO MOSTRAR CURSOS**
    public void mostrarCursos(){
        System.out.println("Cursos inscriptos:");
        for(Curso c : cursosInscriptos){
            c.monstrarInfo();
        }
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

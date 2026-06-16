package servicios;

import java.util.ArrayList;
import java.util.HashMap;
import dominio.Persona;
import dominio.Curso;

public class Instituto {

    private ArrayList<Curso> cursos;
    private HashMap<Integer, Persona> personas;

    public Instituto(){
        this.cursos = new ArrayList<>();
        this.personas = new HashMap<>();
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public HashMap<Integer, Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(HashMap<Integer, Persona> personas) {
        this.personas = personas;
    }
    
    //Metodos

    // para agregar un curso al instituto
    public void agregarCurso(Curso c){
        cursos.add(c);
        System.out.println(c.getNombre() + " fue agregado a la lista");
    }


    // para registrar personas en el hashmap por dni

    public void registrarPersona(Persona p){
        personas.put(p.getDni(),p);
        System.out.println("Agregado!!!!");
    }

    // busca el curso que se pide y devuelve el primero.

    public Curso buscarCurso(String nombre){

       Curso encontrado = cursos.stream()
                    .filter(c -> c.getNombre().equals(nombre))
                    .findFirst()
                    .orElse(null);

                return encontrado;
    }

    // Muestra los cursos abiertos
    public void mostrarCursosAbiertos(){
        System.out.println("Cursos abiertos:");
        cursos.stream()
                .filter(c -> c.getEstado() == enums.EstadoCurso.ABIERTO)
                .forEach(c -> {c.monstrarInfo();
                                System.out.println("-------------------");
                });
    }

}   
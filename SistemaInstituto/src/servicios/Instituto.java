package servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;
import java.util.HashSet;

import dominio.Persona;
import dominio.Curso;
import dominio.Alumno;
import dominio.interfaces.IRepositorio;
import excepciones.InscripcionException;

public class Instituto {

    private ArrayList<Curso> cursos;
    private HashMap<Integer, Persona> personas;
    private HashSet<Persona> alumnosInscriptos;
    private IRepositorio repositorio;
    private IRepositorio repositorioPersonas;

    public Instituto(){
        this.cursos = new ArrayList<>();
        this.personas = new HashMap<>();
        this.alumnosInscriptos = new HashSet<>();
        this.repositorio = new Repositorio("cursos.dat");
        this.repositorioPersonas = new Repositorio("personas.dat");
    }
 //Getters y Setters
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
        c.setId(cursos.size()+1);
        cursos.add(c);
        System.out.println(c.getNombre() + " fue agregado a la lista");
    }

    // busca el curso que se pide y devuelve el primero.
    public Curso buscarCurso(String nombre){

       Curso encontrado = cursos.stream()
                    .filter(c -> c.getNombre().equals(nombre))
                    .findFirst()
                    .orElse(null);

                return encontrado;
    }
    //comentario prubaaaaaaaaaaaaaaaaaaaaaa
    // Muestra los cursos abiertos
    //Santi de aca tenes que agarrar la Lista de cursos abiertos para mostrarla con el menu.
    public List<Curso> mostrarCursosAbiertos(){
        System.out.println("Cursos abiertos:");
        return  cursos.stream()
                .filter(c -> c.getEstado() == enums.EstadoCurso.ABIERTO)
                .collect(Collectors.toList());
    }
    
    //Mostrar los cursosOrdenados por nombre
    public void mostrarCursosOrdenados(){
        System.out.println("Cursos ordenados por nombre:");
        Collections.sort(cursos);
        cursos.forEach(Curso::monstrarInfo);
    }

    //Mostrar cursos Ordenanos por Cupo

    public void ordenarPorCupo(){
        Comparator<Curso> porCupo = (c1,c2) -> c1.getCupoMaximo().compareTo(c2.getCupoMaximo());
        Collections.sort(cursos,porCupo);
        cursos.forEach(Curso::monstrarInfo);
    }


    
    // para registrar personas en el hashmap por dni
    public void registrarPersona(Persona p){
        personas.put(p.getDni(),p);
        System.out.println("Agregado!!!!");
    }

    //Busca alumnos por el Dni
    //Santi esta es el metodo que tenes que usar para que el menu pueda buscar a los alumnos por su dni y mostrar su info, si te da null es poruq no hay ninguno.
    public Alumno buscarAlumno( int dni){

        Persona p = personas.get(dni);
        if ( p instanceof Alumno){
            return (Alumno) p;
        }
        return null;
    }

    //Santi aca le tenes que decir al menu que si devuelve 0 es porque no hay inscriptos en ese curso, si devuelve un numero mayor a 0 es porque hay inscriptos y te muestra el numero de inscriptos que hay en ese curso.

    public long contarInscriptos(String nombre){
        Curso encontrado = buscarCurso(nombre);
        if (encontrado == null) return 0;
        return  personas.values().stream()
                                .filter(p -> p instanceof Alumno)
                                .map(a -> (Alumno) a)
                                .filter(a -> a.getCursosInscriptos().contains(encontrado))
                                .count();
    }

    public void InscribirAlumnoACurso(int dni, String nombreCurso) throws InscripcionException{
        Alumno alumno = buscarAlumno(dni);
        Curso curso = buscarCurso(nombreCurso);
        if (alumno == null || curso == null) {
            System.out.println("Alumno o curso no encontrado");
            return;
        }
        alumno.inscribirCurso(curso);
        alumnosInscriptos.add(alumno);

    }

    public  void guardarDatos(){
        repositorio.guardar(cursos);
        repositorioPersonas.guardar(personas);
    }

    @SuppressWarnings("unchecked")
    public void cargarDatos(){
        Object objCursos = repositorio.consultar();
        if (objCursos != null) cursos = (ArrayList<Curso>) objCursos;

        Object objPersonas = repositorioPersonas.consultar();
        if (objPersonas != null) personas = (HashMap<Integer, Persona>) objPersonas;

    }

}   
package dominio;

import dominio.interfaces.IInscribible;
import enums.EstadoCurso;
import java.io.Serializable;

public abstract class Curso implements IInscribible, Serializable, Comparable<Curso> {

    // Atributos comunes a todos los tipos de cursos
    private Integer id;
    private String nombre;
    private Integer cupoMaximo;
    private Integer inscriptos;
    private EstadoCurso estado;

    // Constructor utilizado por las clases hijas (Materia, Taller y Seminario)
    public Curso(Integer id, String nombre, Integer cupoMaximo, Integer inscriptos, EstadoCurso estado){
        this.id = id;
        this.nombre = nombre;
        this.cupoMaximo = cupoMaximo;
        this.inscriptos = inscriptos;
        this.estado = estado;
    }

    // GETTERS Y SETTERS: Encapsulan los atributos y permiten acceder a ellos de forma controlada.
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(Integer cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public Integer getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(Integer inscriptos) {
        this.inscriptos = inscriptos;
    }

    public EstadoCurso getEstado() {
        return estado;
    }

    public void setEstado(EstadoCurso estado) {
        this.estado = estado;
    }

    // Muestra la información básica del curso (método heredado por las clases hijas).
    public void monstrarInfo(){
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Cupo Máximo: " + cupoMaximo);
        System.out.println("Inscriptos: " + inscriptos);
        System.out.println("Estado: " + estado);
    }

    // Cada tipo de curso debe indicar su modalidad (Presencial, Virtual, Mixta, etc).
    public abstract String getModalidad();

    // Gestiona la inscripción de un alumno al curso.
    @Override
    public void inscribir(){
        // Primero verifica que el curso esté abierto.
        if (getEstado() != EstadoCurso.ABIERTO) {
            System.out.println("No se puede inscribir");
            return;
        }
        // Luego controla que existan cupos disponibles.
        if (getInscriptos() >= this.getCupoMaximo()) {
            System.out.println("No hay cupos disponibles");
            setEstado(EstadoCurso.CERRADO);
            return;
        }
        // Si ambas condiciones se cumplen, incrementa la cantidad de inscriptos.
        setInscriptos(getInscriptos() + 1);
        System.out.println("Inscripción realizada correctamente.");
    }

    // Dar de baja un alumno del curso.
    @Override
    public void darDeBaja() {

        if (getInscriptos() > 0) {

            setInscriptos(getInscriptos() - 1);
            // Si el curso estaba cerrado por falta de cupo, al liberarse un lugar vuelve a quedar abierto.
            if(getEstado() == EstadoCurso.CERRADO){
                setEstado(EstadoCurso.ABIERTO);
            }

            System.out.println("Baja realizada correctamente.");

        } else {
            System.out.println("No hay inscriptos para dar de baja.");
        }
    }

    // Dos cursos se consideran iguales cuando poseen el mismo ID.
    @Override
    public boolean equals(Object obj) {
        // Esto evita duplicados y facilita las búsquedas.
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Curso other = (Curso) obj;

        return this.id.equals(other.id);
    }

    // Permite ordenar los cursos alfabéticamente por nombre.
    @Override
    public int compareTo(Curso c) {
        return this.nombre.compareTo(c.getNombre());
    }
}
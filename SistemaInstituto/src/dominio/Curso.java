package dominio;
import dominio.interfaces.IInscribible;
import enums.EstadoCurso;
import java.io.Serializable;


public abstract class Curso implements IInscribible , Serializable, Comparable<Curso> 
{
    private Integer id;
    private String nombre;
    private Integer cupoMaximo;
    private Integer inscriptos;
    private EstadoCurso estado;

    public Curso (Integer id, String nombre, Integer cupoMaximo, Integer inscriptos, EstadoCurso estado){
        this.id = id;
        this.nombre = nombre;
        this.cupoMaximo = cupoMaximo;
        this.inscriptos = inscriptos;
        this.estado = estado;
    }

    


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




    public  void monstrarInfo(){
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Cupo Máximo: " + cupoMaximo);
        System.out.println("Inscriptos: " + inscriptos);
        System.out.println("Estado: " + estado);
    }

    public abstract String getModalidad();

     public void inscribir(){
        if (getEstado() != EstadoCurso.ABIERTO) {
            System.out.println("No se puede inscribir");
            return;
        }
        if (getInscriptos() >= this.getCupoMaximo()) {
            System.out.println("No hay cupos disponibles");
            setEstado(EstadoCurso.CERRADO);
            return;
        }

        setInscriptos(getInscriptos() + 1);
        System.out.println("Inscripción realizada correctamente.");
        

    }

    
    public void darDeBaja(){
        if (getInscriptos() > 0) {
            setInscriptos(getInscriptos() - 1);
            System.out.println("Baja realizada correctamente.");
        } else {
            System.out.println("No hay inscriptos para dar de baja.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Curso other = (Curso) obj;
        return this.id.equals(other.id);
}

    @Override
    public int compareTo(Curso c) {
        return this.nombre.compareToIgnoreCase(c.getNombre());
    }
    
}

package dominio;
import dominio.interfaces.IInscribible;
import enums.EstadoCurso;
import java.io.Serializable;


public abstract class Curso implements IInscribible , Serializable 
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

    public void inscribir(){};
    public void darDeBaja(){};


}

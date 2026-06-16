package dominio;
import enums.EstadoCurso;

// La clase Materia hereda atributos y métodos de Curso.
public class Materia extends Curso {

    private Integer horasSemanales;
    private String correlativa;

    // Inicializa los atributos heredados llamando al constructor de Curso.
    public Materia(Integer id,
                   String nombre,
                   Integer cupoMaximo,
                   Integer inscriptos,
                   EstadoCurso estado,
                   Integer horasSemanales,
                   String correlativa) {

        super(id, nombre, cupoMaximo, inscriptos, estado);

        //Inicializar atributos propios
        this.horasSemanales = horasSemanales;
        this.correlativa = correlativa;
    }

    

    public Integer getHorasSemanales() {
        return horasSemanales;
    }



    public void setHorasSemanales(Integer horasSemanales) {
        this.horasSemanales = horasSemanales;
    }



    public String getCorrelativa() {
        return correlativa;
    }



    public void setCorrelativa(String correlativa) {
        this.correlativa = correlativa;
    }

    //Métodos 
    public void inscribir(){
        if (getEstado() != EstadoCurso.ABIERTO) {
            System.out.println("No se puede inscribir");
            return;
        }
        if (getInscriptos() >= this.getCupoMaximo()) {
            System.out.println("No hay cupos disponibles");
            return;
        }

        setInscriptos(getInscriptos() + 1);
        System.out.println("Inscripción realizada correctamente.");
    }

    @Override
    public void darDeBaja(){
        if (getInscriptos() > 0) {
            setInscriptos(getInscriptos() - 1);
            System.out.println("Baja realizada correctamente.");
        } else {
            System.out.println("No hay inscriptos para dar de baja.");
        }
    }


    // Implementación obligatoria del método abstracto definido en Curso.
    @Override
    public String getModalidad() {
        return "Materia";
    }
}


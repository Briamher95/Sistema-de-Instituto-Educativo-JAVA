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

    // Implementación obligatoria del método abstracto definido en Curso.
    @Override
    public String getModalidad() {
        return "Materia";
    }

    @Override
    public void monstrarInfo() {
        super.monstrarInfo();
        System.out.println("Horas Semanales: " + horasSemanales);
        System.out.println("Correlativa: " + (correlativa != null ? correlativa : "Ninguna"));
    }
}


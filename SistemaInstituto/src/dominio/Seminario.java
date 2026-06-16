package dominio;

import enums.EstadoCurso;

// La clase Seminario hereda de Curso
public class Seminario extends Curso {

    // Atributos propios de Seminario
    private Integer duracionDias;
    private Boolean esVirtual;

    // Constructor
    public Seminario(Integer id,
                     String nombre,
                     Integer cupoMaximo,
                     Integer inscriptos,
                     EstadoCurso estado,
                     Integer duracionDias,
                     Boolean esVirtual) {

        // Inicializa los atributos heredados de Curso
        super(id, nombre, cupoMaximo, inscriptos, estado);

        // Inicializa los atributos propios de Seminario
        this.duracionDias = duracionDias;
        this.esVirtual = esVirtual;
    }

    // Getter de duracionDias
    public Integer getDuracionDias() {
        return duracionDias;
    }

    // Setter de duracionDias
    public void setDuracionDias(Integer duracionDias) {
        this.duracionDias = duracionDias;
    }

    // Getter de esVirtual
    public Boolean getEsVirtual() {
        return esVirtual;
    }

    // Setter de esVirtual
    public void setEsVirtual(Boolean esVirtual) {
        this.esVirtual = esVirtual;
    }

    // Implementación obligatoria del método abstracto de Curso
    @Override
    public String getModalidad() {
        return esVirtual ? "Virtual" : "Presencial";
    }

    // Muestra información adicional del seminario
    @Override
    public void monstrarInfo() {

        // Muestra primero la información general del curso
        super.monstrarInfo();

        // Muestra la información específica del seminario
        System.out.println("Duración (días): " + duracionDias);
        System.out.println("Modalidad: " + getModalidad());
    }
}

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

    public void inscribir() {
        if (getEstado() != EstadoCurso.ABIERTO) {
            System.out.println("No se puede inscribir");
            return;
        }
        if (getInscriptos() >= this.getCupoMaximo()) {
            System.out.println("No hay cupos disponibles");
            return;
        }
        setInscriptos(getInscriptos() + 1);
        System.out.println("Inscripción exitosa");
    }

    @Override
    public void darDeBaja() {
        if (getEstado() != EstadoCurso.ABIERTO) {
            System.out.println("No se puede dar de baja");
            return;
        }
        if (getInscriptos() <= 0) {
            System.out.println("No hay inscriptos para dar de baja");
            return;
        }
        setInscriptos(getInscriptos() - 1);
        System.out.println("Baja realizada correctamente.");
    }

    // Implementación obligatoria del método abstracto de Curso
    @Override
    public String getModalidad() {
        return esVirtual ? "Virtual" : "Presencial";
    }

}

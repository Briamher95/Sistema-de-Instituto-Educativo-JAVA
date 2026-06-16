package dominio;

import enums.EstadoCurso;

//La clase Taller hereda de Curso.
public class Taller extends Curso {

    private String materialesReq;
    private boolean esPractico;

    //Constructor
    public Taller(Integer id,
                  String nombre,
                  Integer cupoMaximo,
                  Integer inscriptos,
                  EstadoCurso estado,
                  String materialesReq,
                  boolean esPractico) {

        //Inicializa los atributos heredados de Curso
        super(id, nombre, cupoMaximo, inscriptos, estado);

        //Inicializa los atributos propios de Taller
        this.materialesReq = materialesReq;
        this.esPractico = esPractico;
    }

    //Getter de materialesReq
    public String getMaterialesReq() {
        return materialesReq;
    }

    //Setter de materialesReq  
    public void setMaterialesReq(String materialesReq) {
        this.materialesReq = materialesReq;
    }

    //Getter de esPractico
    public boolean isEsPractico() {
        return esPractico;
    }

    //Setter de esPractico
    public void setEsPractico(boolean esPractico) {
        this.esPractico = esPractico;
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
        System.out.println("Baja exitosa");
    }

    @Override
    public String getModalidad() {
        return esPractico ? "Práctico" : "Teórico";
    }



}



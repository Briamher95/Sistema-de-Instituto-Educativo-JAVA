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

    //Getters y Setters
    public String getMaterialesReq() {
        return materialesReq;
    }

    public void setMaterialesReq(String materialesReq) {
        this.materialesReq = materialesReq;
    }

    public boolean isEsPractico() {
        return esPractico;
    }


    public void setEsPractico(boolean esPractico) {
        this.esPractico = esPractico;
    }



    @Override
    public String getModalidad() {
        return esPractico ? "Práctico" : "Teórico";
    }

    @Override
    public void monstrarInfo() {
        super.monstrarInfo();
        System.out.println("Materiales Requeridos: " + materialesReq);
        System.out.println("Es Práctico: " + (esPractico ? "Sí" : "No"));
    }
}



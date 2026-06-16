package dominio.main;

import dominio.Alumno;
import dominio.Docente;
import dominio.Materia;
import enums.EstadoCurso;

public class Main {
    public static void main(String[] args) throws Exception {

        Materia ingles = new Materia(1, "Ingles", 20, 4, EstadoCurso.ABIERTO, 2, "Ninguna");
        
        ingles.monstrarInfo();
        ingles.inscribir();
        ingles.darDeBaja();

        Alumno alumno = new Alumno(27456909, "Jaime", "Fernandez", 122);
        Docente docente = new Docente(18767880, "Pablo", "Olguin", "Traductorado Ingles", "Ingles 1");

        alumno.inscribirCurso(ingles);
        alumno.mostrarInfo();
        docente.registrarCurso(ingles);
        docente.mostrarInfo();

        
    }
}
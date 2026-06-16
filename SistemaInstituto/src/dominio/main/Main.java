package dominio.main;

import dominio.Alumno;
import dominio.Docente;
import dominio.InscripcionException;
import dominio.Materia;
import enums.EstadoCurso;

public class Main {
    public static void main(String[] args) throws Exception {

        Materia ingles = new Materia(1, "Ingles", 20, 4, EstadoCurso.ABIERTO, 2, "Ninguna");
        Materia matematica = new Materia(2, "Matematica", 15, 15, EstadoCurso.CERRADO, 4, "Ninguna");
        Materia lengua = new Materia(12, "Lengua", 20, 17, EstadoCurso.ABIERTO, 3, null);
        
        ingles.monstrarInfo();
        ingles.inscribir();
        ingles.darDeBaja();

        matematica.monstrarInfo();
        lengua.monstrarInfo();

        Alumno alumno = new Alumno(27456909, "Jaime", "Fernandez", 122);
        Docente docente = new Docente(18767880, "Pablo", "Olguin", "Traductorado Ingles", "Ingles 1");

        //Prueba del InscripcionException
        try{
        alumno.inscribirCurso(ingles);
        alumno.inscribirCurso(lengua);
        alumno.inscribirCurso(matematica);
        } catch(InscripcionException e) {
            System.out.println("ERROR"+e.getMessage());
        }finally{
            alumno.mostrarInfo();
            docente.registrarCurso(ingles);
            docente.mostrarInfo();
            System.out.println();
            alumno.mostrarCursos();
        }


        
    }
}
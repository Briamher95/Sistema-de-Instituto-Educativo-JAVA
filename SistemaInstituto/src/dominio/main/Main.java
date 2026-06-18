package dominio.main;

import dominio.Alumno;
import dominio.Docente;
import dominio.Materia;
import dominio.Seminario;
import dominio.interfaces.InscripcionException;
import enums.EstadoCurso;
import servicios.Instituto;
import dominio.Taller;

public class Main {
    public static void main(String[] args) throws Exception {

        Materia ingles = new Materia(1, "Ingles", 20, 4, EstadoCurso.ABIERTO, 2, "Ninguna");
        Materia matematica = new Materia(2, "Matematica", 15, 15, EstadoCurso.CERRADO, 4, "Ninguna");

        Materia lengua = new Materia(12, "Lengua", 20, 17, EstadoCurso.ABIERTO, 3, null);
        Taller tallerProgramacion = new Taller(3, "Taller de Programacion", 10, 5, EstadoCurso.CERRADO, "Laptop", true);
        Seminario seminarioLiderazgo = new Seminario(3, "Liderazgo", 15, 0, EstadoCurso.ABIERTO, 5, false);

        //Probamos como funciona
        Instituto instituto = new Instituto();


        
        //Prueba de los metodos de la clase Materia
        ingles.monstrarInfo();
        ingles.inscribir();
        ingles.darDeBaja();
        matematica.monstrarInfo();
        lengua.monstrarInfo();

        //Prueba de los metodos de la clase Alumno y Docente
        Alumno alumno = new Alumno(27456909, "Jaime", "Fernandez", 122);
        Docente docente = new Docente(18767880, "Pablo", "Olguin", "Traductorado Ingles", "Ingles 1");

        System.out.println("-------------------ALUMNO TryCatch y Metodos-------------------------");
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



        System.out.println("-------------------INSTITUTO-------------------------");

        instituto.getCursos().add(ingles);
        instituto.getCursos().add(tallerProgramacion);
        instituto.getCursos().add(seminarioLiderazgo);

        System.out.println("-------------CURSOS ABIERTOS----------:");
        instituto.mostrarCursosAbiertos().forEach(c -> c.monstrarInfo());

        System.out.println("-------------------CURSOS ORDENADOS-------------------------");
        instituto.mostrarCursosOrdenados();
    
    }
}
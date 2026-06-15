package dominio;
import java.io.Serializable;

public abstract class Persona implements Serializable, Comparable<Persona> {
    private int dni;
    private String nombre;
    private String apellido;
    
    public abstract void mostrarInfo();

    //***CONSTRUCTOR***
    public Persona(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //***METODOS***

    //**GETTERS**
    public int getDni(){
        return dni;
    }

    public String getNombre(){
        return nombre;
    }

    //**SETTERS**

    public String getApellido(){
        return apellido;
    }


    public void setDni(int dni){
        this.dni = dni;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;

    
    }

    //***HASHCODE & EQUALS***
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + dni;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (dni != other.dni)
            return false;
        return dni == other.dni;
    }

    //***CompareTo***
    @Override
    public int compareTo(Persona p){
        return this.getApellido().compareTo(p.getApellido());
    }
}

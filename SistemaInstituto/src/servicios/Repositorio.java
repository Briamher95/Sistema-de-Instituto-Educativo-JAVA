package servicios;

import dominio.interfaces.IRepositorio;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Repositorio implements IRepositorio {
    private File archivo;

    public Repositorio (String nombreArchivo){
        this.archivo = new File (nombreArchivo);
    }


 
    //Convierte el objeto a bytes y lo guarda en el archivo
    @Override
    public void guardar(Object obj) {
        // Oss es la herramienta que escribe objetos en bytes
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo)))
        {
            oos.writeObject(obj);
        } catch (IOException e){
            System.out.println("Error al guardar el objeto: " + e.getMessage());
        }
        
    }
    //Reconstruye el objeto a partir de los bytes guardados en el archivo
    @Override
    public Object consultar() {
        if (!archivo.exists()) return  null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer: " + e.getMessage());
            return null;
        }
    }

<<<<<<< HEAD
} 
=======
}
>>>>>>> main

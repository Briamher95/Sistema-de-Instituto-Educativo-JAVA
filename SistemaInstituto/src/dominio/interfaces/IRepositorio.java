package dominio.interfaces;
import java.util.List;

public interface IRepositorio {

    void guardar(Object obj);
    List<?> consultar();
}


package dominio.interfaces;

public interface IRepositorio {

    void guardar(Object obj);
    Object consultar();
}



package Intefaces;

import Modelo.PQR;
import java.util.List;

public interface CRUD {

    public List listar();

    public List listarPqrId(int id);

    public PQR list(int id);

    public boolean add(PQR per);

    public boolean edit(PQR per);

    public boolean eliminar(int id);

}

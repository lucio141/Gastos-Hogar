package ar.com.cartico.casa.gastos.repositories.interfaz;

import ar.com.cartico.casa.gastos.entities.persona;
import java.util.List;

public interface I_PersonaRepository {
    void save (persona persona);
    void remove (persona persona);
    void update (persona persona);
    persona getById (int id);
    List<persona> getByNombre (String nombre);
    List<persona> getAll();
    int totalImplicanciaG();
    int totalImplicanciaGF();
}

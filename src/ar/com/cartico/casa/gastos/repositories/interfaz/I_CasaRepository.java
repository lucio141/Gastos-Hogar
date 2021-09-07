package ar.com.cartico.casa.gastos.repositories.interfaz;

import ar.com.cartico.casa.gastos.entities.casa;

public interface I_CasaRepository {
    void modificar(String nombre);
    casa getByNombre();
}

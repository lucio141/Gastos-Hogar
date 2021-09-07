package ar.com.cartico.casa.gastos.repositories.interfaz;

import ar.com.cartico.casa.gastos.entities.gasto;
import ar.com.cartico.casa.gastos.entities.persona;
import ar.com.cartico.casa.gastos.enums.Meses;
import java.util.List;

public interface I_GastoRepository {
    void save (gasto gasto);
    void remove (gasto gasto);
    void update (gasto gasto);
    gasto getById (int id);
    List<gasto> getAll();
    List<gasto> getByMonto (int monto);
    List<gasto> getByPersona (int idPersona);
    List<gasto> getByPersona (persona persona);
    List<gasto> getByAño (int año);
    List<gasto> getByMes (Meses mes);
    List<gasto> getByDetalle(String detalle);
    List<gasto> getByPersonaMesesAño (int IdPersona, int año, Meses mes);
    List<gasto> getByPersonaMesesAño (persona persona, int año, Meses mes);
    List<gasto> getByMesesAño (int año, Meses mes);
    List<gasto> getByPersonaAño(int idPersona, int año);
    List<gasto> getByPersonaAño(persona persona, int año);
    List<gasto> getByDetalleMesesAño(String detalle,Meses mes, int año);
    int getTotal();
    int getTotalPersona (int idPersona);
    int getTotalPersona (persona persona);
    int getTotalByAño (int año);
    int getTotalByMes (Meses mes);
    int getTotalByDetalle(String detalle);
    int getTotalByPersonaMesesAño (int IdPersona, int año, Meses mes);
    int getTotalByPersonaMesesAño (persona persona, int año, Meses mes);
    int getTotalByMesesAño (int año, Meses mes);
    int getTotalByPersonaAño(int idPersona, int año);
    int getTotalByPersonaAño(persona persona, int año);
    int getTotalByDetalleAño(String detalle, int año);
    int getTotalByDetalleMesesAño(String detalle,Meses mes, int año);
    List<String> getDetalles();
    List<String> getAños();
    List<gasto> getDeuda();
}

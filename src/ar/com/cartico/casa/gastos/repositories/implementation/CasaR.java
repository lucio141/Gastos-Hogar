package ar.com.cartico.casa.gastos.repositories.implementation;

import ar.com.cartico.casa.gastos.entities.casa;
import ar.com.cartico.casa.gastos.repositories.interfaz.I_CasaRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CasaR implements I_CasaRepository {
    private Connection conn;
    
    public CasaR (Connection conn){this.conn=conn;}
    
    @Override
    public void modificar(String nombre) {
        try (PreparedStatement ps = conn.prepareStatement("update casa set nombre=? where id=1")){
            ps.setString(1, nombre);
            ps.execute();
        } catch (Exception e) {System.out.println(e);}
    }

    @Override
    public casa getByNombre() {
        List<casa> lista = new ArrayList();
        String sql= "select * from casa";
        try (ResultSet rs = conn.createStatement().executeQuery(sql)){
            while(rs.next()){
                lista.add(new casa(
                        rs.getInt("id"),
                        rs.getString("nombre")
                ));
            }
        } catch (Exception e) {System.out.println(e); }
        return (lista.isEmpty())?null:lista.get(0);
    }
    
}

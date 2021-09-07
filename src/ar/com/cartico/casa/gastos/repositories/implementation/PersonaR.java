package ar.com.cartico.casa.gastos.repositories.implementation;

import ar.com.cartico.casa.gastos.entities.persona;
import ar.com.cartico.casa.gastos.repositories.interfaz.I_PersonaRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaR implements I_PersonaRepository {
    private Connection conn;
    public PersonaR (Connection conn){this.conn = conn;}
    
    @Override
    public void save(persona persona) {
        if(persona==null)return;
        try (PreparedStatement ps = conn.prepareStatement(
                "insert into persona (nombre, implicanciag, implicanciagf) values (?,?,?)", 
                PreparedStatement.RETURN_GENERATED_KEYS
        )){
            ps.setString(1,persona.getNombre());
            ps.setInt(2, persona.getImplicanciaG());
            ps.setInt(3, persona.getImplicanciaGF());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) persona.setId(rs.getInt(1));
        } catch (Exception e) {System.out.println(e);}
    }

    @Override
    public void remove(persona persona) {
        if(persona==null)return;
        try (PreparedStatement ps = conn.prepareStatement("delete from persona where id=?")) {
            ps.setInt(1, persona.getId());
            ps.execute();
        } catch (Exception e) {System.out.println(e);}
    }

    @Override
    public void update(persona persona) {
        if(persona==null) return;
        try (PreparedStatement ps = conn.prepareStatement(
                    "update persona set nombre=?, implicanciag=?, implicanciagf=? where id=?"
        )){
            ps.setString(1, persona.getNombre());
            ps.setInt(2, persona.getImplicanciaG());
            ps.setInt(3, persona.getImplicanciaGF());
            ps.setInt(4, persona.getId());
            ps.execute();
        } catch (Exception e) {System.out.println(e);  }
    }
    
     @Override
    public List<persona> getAll() {
       return getByFiltro("1=1");
    }
    
    @Override
    public persona getById(int id) {
        List<persona> lista = getByFiltro("id="+id);
        return(lista.isEmpty())?null:lista.get(0);
    }
    
    @Override
    public List<persona> getByNombre(String nombre) {
        List<persona> lista = getByFiltro("nombre ='"+nombre+"'");
        return lista;
    }
    
    private List<persona> getByFiltro(String filtro){
        List<persona> lista = new ArrayList();
        String sql= "select * from persona where " + filtro;
        try (ResultSet rs = conn.createStatement().executeQuery(sql)){
            while (rs.next()){
                lista.add(new persona(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("implicanciag"),
                        rs.getInt("implicanciagf")
                ));
            }
            
        } catch (Exception e) {System.out.println(e);}
        return lista;
    }

    @Override
    public int totalImplicanciaG() {
        String sql = "select sum(implicanciag) as total from persona";
        int total = 0;
        try (ResultSet rs = conn.createStatement().executeQuery(sql)){
            while(rs.next()){
                total += rs.getInt("total");
            }
        } catch (Exception e) {System.out.println(e); }
        return total;
    }

    @Override
    public int totalImplicanciaGF() {
            String sql = "select sum(implicanciagf) as total from persona";
        int total = 0;
        try (ResultSet rs = conn.createStatement().executeQuery(sql)){
            while(rs.next()){
                total = rs.getInt("total");
            }
        } catch (Exception e) {System.out.println(e); }
        return total;
    }
    
    
    
   
}

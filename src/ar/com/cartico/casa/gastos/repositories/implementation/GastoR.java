package ar.com.cartico.casa.gastos.repositories.implementation;

import ar.com.cartico.casa.gastos.entities.gasto;
import ar.com.cartico.casa.gastos.entities.persona;
import ar.com.cartico.casa.gastos.enums.Meses;
import ar.com.cartico.casa.gastos.repositories.interfaz.I_GastoRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GastoR implements I_GastoRepository {
    private Connection conn;
    public GastoR (Connection conn){ this.conn = conn;}
    
    @Override
    public void save(gasto gasto) {
        if(gasto==null)return;
        try (PreparedStatement ps = conn.prepareStatement(
              "insert into gasto (año, mes, detalle, idPersona, monto)"
                  + " values (?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS
        )){
            ps.setInt(1, gasto.getAño());
            ps.setString(2,gasto.getMes().toString());
            ps.setString(3, gasto.getDetalle());
            ps.setInt(4, gasto.getIdPersona());
            ps.setInt(5, gasto.getMonto());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) gasto.setId(rs.getInt(1));
                            
        } catch (Exception e) {System.out.println(e);
        }
    }

    @Override
    public void remove(gasto gasto) {
        if(gasto==null)return;
        try (PreparedStatement ps = conn.prepareStatement("delete from gasto where id=?")){
            ps.setInt(1, gasto.getId());
            ps.execute();
        } catch (Exception e) {System.out.println(e);
        }
    }

    @Override
    public void update(gasto gasto) {
        if(gasto==null)return;
        try (PreparedStatement ps = conn.prepareStatement(
                "update gasto set año=?, mes=?, detalle=?, idpersona=?, monto=? where id=?"
        )){ 
            ps.setInt(1, gasto.getAño());
            ps.setString(2, gasto.getMes().toString());
            ps.setString(3, gasto.getDetalle());
            ps.setInt(4, gasto.getIdPersona());
            ps.setInt(5, gasto.getMonto());
            ps.setInt(6, gasto.getId());
            ps.execute();
        } catch (Exception e) {System.out.println(e);}
    }

    @Override
    public gasto getById(int id) {
        List<gasto> lista = getByFiltro("id="+id);
        return(lista.isEmpty())?null:lista.get(0);
    }
    
    @Override
    public List<gasto> getAll() {
        return getByFiltro("1+1");
    }
    
    @Override
    public List<gasto> getByMonto(int monto) {
        return getByFiltro("monto="+monto);
    }

    @Override
    public List<gasto> getByPersona(int idPersona) {
        return getByFiltro("idpersona="+idPersona);
    }

    @Override
    public List<gasto> getByPersona(persona persona) {
        return getByFiltro("idpersona="+persona.getId());
    }

    @Override
    public List<gasto> getByAño(int año) {
        return getByFiltro("año="+año);
    }

    @Override
    public List<gasto> getByMes(Meses mes) {
        return getByFiltro("mes='"+mes.toString()+"'");
    }

    @Override
    public List<gasto> getByDetalle(String detalle) {
        return getByFiltro("detalle='"+detalle+"'");
    }

    @Override
    public List<gasto> getByPersonaMesesAño(int IdPersona, int año, Meses mes) {
        return getByFiltro("idpersona="+IdPersona+" and año="+año+" and mes='"+mes.toString()+"'");
    }

    @Override
    public List<gasto> getByPersonaMesesAño(persona persona, int año, Meses mes) {
        return getByFiltro("idpersona="+persona.getId()+" and año="+año+" and mes='"+mes.toString()+"'");
    }

    @Override
    public List<gasto> getByMesesAño(int año, Meses mes) {
        return getByFiltro("mes='"+mes.toString() + "' and año="+año);
    }

    @Override
    public List<gasto> getByPersonaAño(int idPersona, int año) {
        return getByFiltro("idpersona="+idPersona+" and año="+año);
    }

    @Override
    public List<gasto> getByPersonaAño(persona persona, int año) {
        return getByFiltro("idpersona="+persona.getId()+" and año="+año);
    }

    @Override
    public List<gasto> getByDetalleMesesAño(String detalle, Meses mes, int año) {
        return getByFiltro("detalle='"+detalle+"' and mes='"+mes.toString()+"' and año="+año);
    }

    @Override
    public int getTotal() {
        return getTotalByFiltro("1=1");
    }
    
    @Override
    public int getTotalPersona(int idPersona) {
        return getTotalByFiltro("idpersona="+idPersona);
    }

    @Override
    public int getTotalPersona(persona persona) {
        return getTotalByFiltro("idpersona="+persona.getId());
    }

    @Override
    public int getTotalByAño(int año) {
        return getTotalByFiltro("año="+año);
    }

    @Override
    public int getTotalByMes(Meses mes) {
        return getTotalByFiltro("mes='"+mes.toString()+"'");
    }

    @Override
    public int getTotalByDetalle(String detalle) {
        return getTotalByFiltro("detalle='"+detalle+"'");
    }

    @Override
    public int getTotalByPersonaMesesAño(int IdPersona, int año, Meses mes) {
        return getTotalByFiltro("idpersona="+IdPersona + " and año=" + año + " and mes='"+mes.toString()+"'");
    }

    @Override
    public int getTotalByPersonaMesesAño(persona persona, int año, Meses mes) {
        return getTotalByFiltro("idpersona="+persona.getId()+" and año="+año+" and mes='"+mes.toString()+"'");
    }

    @Override
    public int getTotalByMesesAño(int año, Meses mes) {
        return getTotalByFiltro("año="+año+" and mes='"+mes.toString()+"'");
    }

    @Override
    public int getTotalByPersonaAño(int idPersona, int año) {
        return getTotalByFiltro("idpersona="+idPersona+" and año="+año);
    }

    @Override
    public int getTotalByPersonaAño(persona persona, int año) {
        return getTotalByFiltro("idpersona="+persona.getId()+" and año="+año);
    }

    @Override
    public int getTotalByDetalleMesesAño(String detalle, Meses mes, int año) {
        return getTotalByFiltro("detalle='"+detalle+"' and mes='"+mes.toString()+"' and año="+año);
    }
    /*
    GetByFiltro sirve a modo de simplificador de las busquedas de gastos
    realizando una busqueda por query en la base de datos por medio de un filtro
    otorgado por el metodo que lo llame. Almacenando el resultado en una lista.
    */
    private List<gasto> getByFiltro(String filtro){
        List<gasto> lista = new ArrayList();
        String query = "Select * from gasto where " + filtro;
        try (ResultSet rs = conn.createStatement().executeQuery(query)){
            while(rs.next()){
                lista.add(
                        new gasto(
                            rs.getInt("id"),
                            rs.getInt("año"),
                            Meses.valueOf(rs.getString("mes").toUpperCase()),
                            rs.getInt("idpersona"),
                            rs.getString("detalle"),
                            rs.getInt("monto")
                        ));
            }
            
        } catch (Exception e) {System.out.println(e);  }
        
        return lista;
    }
    /*
    Get total by filtro sirve para simplificar el codigo de los otros getTotal
    realiza una busqueda por query en la cual suma los datos obtenidos al monto
    total a buscar.
    */
    private int getTotalByFiltro (String filtro){
        int total = 0;
        String query = "select monto from gasto where " + filtro;
        try (ResultSet rs = conn.createStatement().executeQuery(query)){
            while(rs.next()){
                total += rs.getInt("monto");
            }
        } catch (Exception e) {System.out.println(e);}
        return total;
    }
        
     @Override
    public List<String> getDetalles() {
        List<String> lista = new ArrayList();
        String sql="Select detalle from gasto group by detalle";
        try (ResultSet rs = conn.createStatement().executeQuery(sql)){
            while(rs.next()){
                lista.add(rs.getString("detalle"));
            }
        } catch (Exception e) {System.out.println(e);  }
        lista.add("Otro");
        return lista;
    }
    
     @Override
    public List<String> getAños() {
         List<String> lista = new ArrayList();
        String sql="Select año from gasto group by año";
        try (ResultSet rs = conn.createStatement().executeQuery(sql)){
            while(rs.next()){
                lista.add(rs.getString("año"));
            }
        } catch (Exception e) {System.out.println(e);  }
        return lista;
    }

    @Override
    public int getTotalByDetalleAño(String detalle, int año) {
        return getTotalByFiltro("detalle='"+detalle+"' and año="+año);
    }
    
     @Override
    public List<gasto> getDeuda() {
        PersonaR pr = new PersonaR(conn);
        int cantidadPersonas = pr.totalImplicanciaG();
        int total = 0;
        try {
             total = getTotal()/cantidadPersonas;
         } catch (Exception e) {System.out.println(e);   }
        
        
        List<gasto> lista = new ArrayList();
        String sql = "Select idpersona, sum(monto) as total from gasto group by idpersona";
        try (ResultSet rs = conn.createStatement().executeQuery(sql)){
            while(rs.next()){
                int idPersona = rs.getInt("idpersona");
                int monto = ((total)*pr.getById(idPersona).getImplicanciaG())-rs.getInt("total");
                lista.add(new gasto(
                        idPersona,
                        monto
                ));
            }
        } catch (Exception e) {System.out.println(e);}
        return lista;
    }
}


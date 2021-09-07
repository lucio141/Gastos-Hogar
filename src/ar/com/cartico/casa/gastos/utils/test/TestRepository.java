package ar.com.cartico.casa.gastos.utils.test;

import ar.com.cartico.casa.gastos.connector.Connector;
import ar.com.cartico.casa.gastos.entities.gasto;
import ar.com.cartico.casa.gastos.entities.persona;
import ar.com.cartico.casa.gastos.enums.Meses;
import ar.com.cartico.casa.gastos.repositories.implementation.CasaR;
import ar.com.cartico.casa.gastos.repositories.implementation.GastoFijoR;
import ar.com.cartico.casa.gastos.repositories.implementation.GastoR;
import ar.com.cartico.casa.gastos.repositories.implementation.PersonaR;

public class TestRepository {
    
    public static void main(String[] args) {
    
        PersonaR pr = new PersonaR(Connector.getConnection());    
        //pr.save(p1);
        //pr.save(new persona("Ale"));
        //pr.save(new persona("Nacho"));
        GastoR gr = new GastoR(Connector.getConnection());
        /*gr.save(new gasto(2019, Meses.ENERO, 1, "Carne", 600));
        gr.save(new gasto(2019, Meses.FEBRERO, 1, "Verdura", 800));
        gr.save(new gasto(2018, Meses.FEBRERO, 2, "Carne", 500));
        gr.save(new gasto(2019, Meses.FEBRERO, 2, "Super", 1600));
        gr.save(new gasto(2019, Meses.ENERO, 2, "Chino", 1900));
        gr.save(new gasto(2018, Meses.ENERO, 1, "Cita", 2000));
        gr.save(new gasto(2019, Meses.ENERO, 2, "Carne", 200));
        gr.save(new gasto(2018, Meses.FEBRERO, 1, "Chino", 100));
        */
        /*gr.update(new gasto(3,2018,Meses.FEBRERO,2,"Chino",500));
        gr.remove(gr.getById(8));
        gr.getAll().forEach(System.out::println);
        */
        GastoFijoR gfr = new GastoFijoR(Connector.getConnection());
      
    
        for(gasto g : gr.getDeuda()){
            System.out.println(g.toString());
            
          int p = gr.getTotalByPersonaMesesAño(2, 2019, Meses.MAYO);
            System.out.println(p);
        }
    }
    
    
}

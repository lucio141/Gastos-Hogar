package ar.com.cartico.casa.gastos.utils.test;

import ar.com.cartico.casa.gastos.entities.persona;
import java.util.Calendar;

public class TestEntities {
    public static void main(String[] args) {
       Calendar c = Calendar.getInstance();
       String s= Integer.toString(c.get(c.YEAR));
       System.out.println(s);
        
    }
}        
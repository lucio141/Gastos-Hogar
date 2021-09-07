package ar.com.cartico.casa.gastos.utils.test;

import ar.com.cartico.casa.gastos.utils.files.text.FileText;
import java.util.ArrayList;
import java.util.List;

public class TestFiles {
    public static void main(String[] args) {
        FileText colores = new FileText("colores.txt");
        colores.print();
        int i=0%2;
        System.out.println(i);
    }
}

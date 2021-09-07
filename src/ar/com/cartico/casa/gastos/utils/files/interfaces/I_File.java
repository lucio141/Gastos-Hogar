package ar.com.cartico.casa.gastos.utils.files.interfaces;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface I_File {
    void print();
    String getText();
    void setText (String text);
    void appendText (String text);
    void clear();
    void addLine(String line);
    void setLines(Collection<String> lineas);
    void addLines(Collection<String> lineas);
    List<String> getLines();
    Set<String> getLinkedHashSetLines();
    Set<String> getTreeSetLines();
    void remove (String line);
    
    
}

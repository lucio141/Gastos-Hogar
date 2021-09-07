package ar.com.cartico.casa.gastos.utils.files.text;

import ar.com.cartico.casa.gastos.utils.files.interfaces.I_File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileText implements I_File {
    private File file;
    public FileText (File file){this.file = file;}
    public FileText (String file){this.file = new File(file);}
    
    @Override
    public void print() {
        int car;
        try(FileReader in = new FileReader(file)) {
            while((car=in.read())!=-1){System.out.print((char)car);}
        } catch (FileNotFoundException e) {System.out.println("No se encuentra el archivo " + file);
        } catch (IOException e){System.out.println("problemas al leer el archivo " + file);}
    }

    @Override
    public String getText() {
        int car;
        StringBuilder sb = new StringBuilder();  
        try(FileReader in = new FileReader(file)){while((car=in.read())!=-1){sb.append((char)car);}
        } catch (FileNotFoundException e)   {System.out.println("No se encuentra el archivo " + file);
        } catch (IOException e)             {System.out.println("Problemas al leer el archivo " + file);}
        return sb.toString();
    }

    @Override
    public void setText(String text) {
        try(FileWriter out= new FileWriter(file)) {out.write(text);    
        } catch (FileNotFoundException e)   {System.out.println("No se encuentra el archivo " + file);
        } catch (IOException e) {System.out.println("Problema al escribir el archuvo " + file);
        }}

    @Override
    public void appendText(String text) {
        try (FileWriter out= new FileWriter(file, true)) {out.write(text); //El consturctor tiene un booleano que me dice si deseo apendizar    
        } catch (FileNotFoundException e) {System.out.println("No se encuentra el archivo " + file);
        } catch (IOException e){System.out.println("Problema al escribir el archivo " + file);}
    }

    @Override
    public void clear() {this.setText("");}

    @Override
    public void addLine(String line) {
        //appendText(linea+"\n");
        try (BufferedWriter out=new BufferedWriter(new FileWriter(file,true))) {
            out.write(line);
            out.newLine();
        } catch (IOException e) {System.out.println("problema al leer el archivo " + file);}
    }

    @Override
    public void setLines(Collection<String> lineas) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            for(String s: lineas){out.write(s + "\n");}
        } catch (IOException e) {System.out.println("Problema al leer el archivo " + file);}
    }

    @Override
    public void addLines(Collection<String> lineas) {
        try (BufferedWriter out= new BufferedWriter(new FileWriter(file,true))) {
            for(String s: lineas){out.write(s+"\n");}
        } catch (IOException e) {System.out.println("Problema al leer el archivo " + file);}
    }

    @Override
    public List<String> getLines() {
    List<String> lista= new ArrayList();
        try(BufferedReader in = new BufferedReader( new FileReader(file))) {
            in.lines().forEach(lista::add);
        } catch (IOException e) {System.out.println("problema al leer el archivo " + file);}
        return lista;
    }

    @Override
    public Set<String> getLinkedHashSetLines() {
        Set<String> lista = new LinkedHashSet();
        try (BufferedReader in = new BufferedReader(new FileReader(file))){
            in.lines().forEach(lista::add);
        } catch(FileNotFoundException e){System.out.println("no se pudo encontrar el archivo "+ file);
        } catch(IOException e) {System.out.println("Problema al leer el archivo " + file);}
        return lista;
    } 

    @Override
    public Set<String> getTreeSetLines() {
        Set<String> lista = new TreeSet();
        try (BufferedReader in = new BufferedReader(new FileReader(file))){
            in.lines().forEach(lista::add);
        } catch (FileNotFoundException e) {System.out.println("No se puedo encontrar el archivo " + file);
        } catch (IOException e){System.out.println("Problema al leer el archivo " + file);}
        return lista;
    }

    @Override
    public void remove(String line) {
        List<String> lista = getLines();
        lista.remove(line);
        setLines(lista);
    }
}

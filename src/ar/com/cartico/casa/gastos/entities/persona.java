package ar.com.cartico.casa.gastos.entities;

import java.util.Objects;

public class persona {
   private int id;
   private String nombre;
   private int implicanciaG;
   private int implicanciaGF;
   
        
    public persona(String nombre){
        this.nombre = nombre;
    }

    public persona(int id, String nombre) {
        this.nombre = nombre;
        this.id = id;
    }


    public persona(int id, String nombre, int implicanciaG, int implicanciaGF) {
        this.nombre = nombre;
        this.implicanciaG = implicanciaG;
        this.implicanciaGF = implicanciaGF;
        this.id =id;
    }

    public persona(String nombre, int implicanciaG, int implicanciaGF) {
        this.nombre = nombre;
        this.implicanciaG = implicanciaG;
        this.implicanciaGF = implicanciaGF;
    }
    
    

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id+ "." + nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final persona other = (persona) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    public int getImplicanciaG() {
        return implicanciaG;
    }

    public void setImplicanciaG(int implicanciaG) {
        this.implicanciaG = implicanciaG;
    }

    public int getImplicanciaGF() {
        return implicanciaGF;
    }

    public void setImplicanciaGF(int implicanciaGF) {
        this.implicanciaGF = implicanciaGF;
    }
    
}

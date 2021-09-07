package ar.com.cartico.casa.gastos.entities;
public class casa {
    private int id;
    private String nombre;

    public casa(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public casa(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "casa{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
}

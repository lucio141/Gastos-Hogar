package ar.com.cartico.casa.gastos.entities;

import ar.com.cartico.casa.gastos.enums.Meses;
import java.util.Objects;

public class gasto {
    private int id;
    private int año;
    private Meses mes;
    private int idPersona;
    private String detalle;
    private int monto;

    public gasto(int año, Meses mes, int idPersona, String detalle, int monto) {
        this.año = año;
        this.mes = mes;
        this.idPersona = idPersona;
        this.detalle = detalle;
        this.monto = monto;
    }

    public gasto(int id, int año, Meses mes, int idPersona, String detalle, int monto) {
        this.id = id;
        this.año = año;
        this.mes = mes;
        this.idPersona = idPersona;
        this.detalle = detalle;
        this.monto = monto;
    }

    public gasto(int idPersona, int monto) {
        this.idPersona = idPersona;
        this.monto = monto;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Meses getMes() {
        return mes;
    }

    public void setMes(Meses mes) {
        this.mes = mes;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public String toString() {
        return "Fecha" + año + "/" + mes + ", " + detalle + ", $" + monto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
        hash = 41 * hash + this.año;
        hash = 41 * hash + Objects.hashCode(this.mes);
        hash = 41 * hash + this.idPersona;
        hash = 41 * hash + Objects.hashCode(this.detalle);
        hash = 41 * hash + this.monto;
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
        final gasto other = (gasto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.año != other.año) {
            return false;
        }
        if (this.idPersona != other.idPersona) {
            return false;
        }
        if (this.monto != other.monto) {
            return false;
        }
        if (!Objects.equals(this.detalle, other.detalle)) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        return true;
    }

    
    
    
    
}


package model;

public class Cooperativa {
    private String ruc;
    private String nombre;
    private float politica;
    private String numTarjeta;

    public Cooperativa(){}
    
    public Cooperativa(String ruc, String nombre, float politica, String numTarjeta) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.politica = politica;
        this.numTarjeta = numTarjeta;
    }

    
    
    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPolitica() {
        return politica;
    }

    public void setPolitica(float politica) {
        this.politica = politica;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    @Override
    public String toString() {
        return "Cooperativa{" + "ruc=" + ruc + ", nombre=" + nombre + ", politica=" + politica + 
                ", numTarjeta=" + numTarjeta + '}';
    }
    
    
}

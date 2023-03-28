
package model;

public class Conductor {
    private String cedula;
    private String nombre;
    private String telefono;
    private String rucEmpresa;
    
    public Conductor(){}
    
    public Conductor(String cedula, String nombre, String telefono, String rucEmpresa) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.rucEmpresa = rucEmpresa;
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRucEmpresa() {
        return rucEmpresa;
    }

    public void setRucEmpresa(String rucEmpresa) {
        this.rucEmpresa = rucEmpresa;
    }

    @Override
    public String toString() {
        return "Conductor{" + "cedula=" + cedula + ", nombre=" + nombre + ", telefono=" + telefono + 
                ", rucEmpresa=" + rucEmpresa + '}';
    }
    
    
}

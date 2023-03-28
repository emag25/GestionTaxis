
package model;

public class Factura {
    private int idFactura;
    private float valorPersona;
    private float valorPagar;
    private int idReserva;
    private String idPasajero;
    
    public Factura(){}
    
    public Factura(int idFactura, float valorPersona, float valorPagar, int idReserva, String idPasajero) {
        this.idFactura = idFactura;
        this.valorPersona = valorPersona;
        this.valorPagar = valorPagar;
        this.idReserva = idReserva;
        this.idPasajero = idPasajero;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public float getValorPersona() {
        return valorPersona;
    }

    public void setValorPersona(float valorPersona) {
        this.valorPersona = valorPersona;
    }

    public float getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(float valorPagar) {
        this.valorPagar = valorPagar;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(String idPasajero) {
        this.idPasajero = idPasajero;
    }

    @Override
    public String toString() {
        return "Factura{" + "idFactura=" + idFactura + ", valorPersona=" + valorPersona + ", valorPagar=" + 
                valorPagar + ", idReserva=" + idReserva + ", idPasajero=" + idPasajero + '}';
    }
    
    
    
}

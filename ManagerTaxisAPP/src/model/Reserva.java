
package model;

import java.sql.Timestamp;



public class Reserva {
    private int idReserva;
    private int acompaniante;
    private String origen;
    private String destino;
    private Timestamp fechaHora;
    private int totalPasajero;
    private float tarifaViaje;
    private int calificacion;
    private String comentario;
    private String cedulaPasajero;
    private String ruc;
    private String cedulaConductor;
    private String placa;

    public Reserva(){};
    public Reserva(int idReserva, int acompaniante, String origen, String destino, Timestamp fechaHora, 
            int totalPasajero, float tarifaViaje, int calificacion, String comentario, String cedulaPasajero, 
            String ruc, String cedulaConductor, String placa) {
        this.idReserva = idReserva;
        this.acompaniante = acompaniante;
        this.origen = origen;
        this.destino = destino;
        this.fechaHora = fechaHora;
        this.totalPasajero = totalPasajero;
        this.tarifaViaje = tarifaViaje;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.cedulaPasajero = cedulaPasajero;
        this.ruc = ruc;
        this.cedulaConductor = cedulaConductor;
        this.placa = placa;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getAcompaniante() {
        return acompaniante;
    }

    public void setAcompaniante(int acompaniante) {
        this.acompaniante = acompaniante;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getTotalPasajero() {
        return totalPasajero;
    }

    public void setTotalPasajero(int totalPasajero) {
        this.totalPasajero = totalPasajero;
    }

    public float getTarifaViaje() {
        return tarifaViaje;
    }

    public void setTarifaViaje(float tarifaViaje) {
        this.tarifaViaje = tarifaViaje;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getCedulaPasajero() {
        return cedulaPasajero;
    }

    public void setCedulaPasajero(String cedulaPasajero) {
        this.cedulaPasajero = cedulaPasajero;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCedulaConductor() {
        return cedulaConductor;
    }

    public void setCedulaConductor(String cedulaConductor) {
        this.cedulaConductor = cedulaConductor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", acompaniante=" + acompaniante + ", origen=" + 
                origen + ", destino=" + destino + ", fechaHora=" + fechaHora + ", totalPasajero=" + 
                totalPasajero + ", tarifaViaje=" + tarifaViaje + ", calificacion=" + calificacion + ", comentario=" + 
                comentario + ", cedulaPasajero=" + cedulaPasajero + ", ruc=" + ruc + ", cedulaConductor=" + 
                cedulaConductor + ", placa=" + placa + '}';
    }
    
    
    
}

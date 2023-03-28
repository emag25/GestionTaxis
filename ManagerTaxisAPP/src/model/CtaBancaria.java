
package model;

//import java.util.Date;
import java.sql.Date;
/**
 *
 * @author Marquez Jean
 */
public class CtaBancaria {
    private String numTarjeta;
    private Date  fechVencimiento;
    private String cedTitular;
    private String cvv;
    
    public  CtaBancaria(){}

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public Date getFechVencimiento() {
        return fechVencimiento;
    }

    public void setFechVencimiento(Date fechVencimiento) {
        this.fechVencimiento = fechVencimiento;
    }

    public String getCedTitular() {
        return cedTitular;
    }

    public void setCedTitular(String cedTitular) {
        this.cedTitular = cedTitular;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "CtaBancaria{" + "numTarjeta=" + numTarjeta + ", fechVencimiento=" + fechVencimiento + ", cedTitular=" + cedTitular + ", cvv=" + cvv + '}';
    }
    
    
    
}

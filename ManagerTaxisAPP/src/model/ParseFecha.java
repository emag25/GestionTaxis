
package model;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JTextField;

public class ParseFecha {
    private boolean banderaT= true;
    public ParseFecha(){}
    
     public java.sql.Date  convertir(String mes, String anio){
        java.util.Date date = null;
        java.sql.Date Sqldate = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
        try {
            date = formato.parse(anio+mes+"28");
            Sqldate = new java.sql.Date(date.getTime());
        } 
        catch (ParseException ex) 
        {
            System.out.println("Error convertir fecha" +ex);
        }
        return Sqldate;
    }
     
     
     public boolean verificarFecha(String mes, String anio){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaIngresada = LocalDate.parse("28/"+ mes+"/"+ anio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (fechaIngresada.isAfter(fechaActual)){
            return true;
        }else{
            return false;
        } 
     }
     
     public Timestamp convertir(JDateChooser calendar,int cmbHora, int cmbMin){
       
        LocalDate fecha =  calendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        fecha.atTime(cmbHora, cmbMin);
        Date date = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Timestamp tss=new Timestamp(date.getTime());
        
        if(fecha.isAfter(LocalDate.now())){
            banderaT = true;
        }else{
            banderaT = false;
        }
        return tss;
     }
     
     public Timestamp ahora(){
        LocalDate ahora = LocalDate.now();
        Date date = Date.from(ahora.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Timestamp tss=new Timestamp(date.getTime());
        return tss;
     }

    public boolean fechaPermitida() {
        return banderaT;
    }

    public void revertirFechaHora(JTextField txtFecha, JTextField txtHora, Timestamp timestamp) {
        Date date = new Date(timestamp.getTime());
        LocalDateTime time = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        txtFecha.setText(time.getDayOfMonth()+"/"+time.getMonth()+"/"+time.getYear());
        txtHora.setText(time.getHour()+":"+time.getMinute()); 
    }
     
}

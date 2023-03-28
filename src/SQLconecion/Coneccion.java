/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLconecion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Coneccion {
    
    public static  Connection getConnection(){
        try{
            System.out.println("conectando...");
            Class.forName("oracle.jdbc.OracleDriver");
               
            String myDB="jdbc:oracle:thin:@192.168.56.1:1521:XE";
            Connection cnx = DriverManager.getConnection(myDB,"ADMIN_GESTION_TAXI","ADMIN_GESTION_TAXI");
            System.out.println("coneccion exitosa. ");
            return cnx;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("error: " +ex);
        }catch(ClassNotFoundException ex) {
            Logger.getLogger(Coneccion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error: "+ ex);
        }
        return null;
    }   
}

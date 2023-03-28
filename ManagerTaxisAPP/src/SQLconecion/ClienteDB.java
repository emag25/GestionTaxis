
package SQLconecion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cliente;
import model.CtaBancaria;

public class ClienteDB {
    
    public ClienteDB(){}
    public void insertCliente(Cliente c) {
        try{
            Connection cnx = Coneccion.getConnection();
            //permite hacer transacciones eliminar insertar
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO  "
                                + "PASAJERO( CEDULAPASAJERO, NOMBREPASAJERO, DIRECCION, TELEFONO,  CONTRASENA,"
                                + " CORREO, NUMEROTARJETA) " + "VALUES( ?, ?, ?, ?, ?, ?, ? )");
            pst.setString(1, c.getCedula());
            pst.setString(2, c.getNombre());
            pst.setString(3, c.getDireccion());
            pst.setString(4, c.getTelefono());
            pst.setString(5, c.getContrasenia());
            pst.setString(6, c.getCorreo());
            pst.setString(7, c.getNumCta());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro exitoso.");
        }catch(SQLException ex){
                System.out.println("ClienteBD error insert: "+ ex.getMessage());
        }
    }
    
    public void insertCtaBancaria(CtaBancaria c){
        try{
            Connection cnx = Coneccion.getConnection();
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO  "
                                + "CUENTABANCARIA( NUMEROTARJETA, FECHAVENCIMIENTO,CEDULATITULAR, CVV) "
                                + "VALUES( ?, ?, ?, ? )");
            pst.setString(1, c.getNumTarjeta());
            pst.setDate(2,   c.getFechVencimiento());
            pst.setString(3, c.getCedTitular());
            pst.setString(4, c.getCvv());
            pst.executeUpdate();
        }catch(SQLException ex){
                System.out.println("CtaBancaria error insert: "+ ex.getMessage());
        }
    }
    ////////////////   Inicio de sesion   ////////////////   
    public String[] verificarUsuario(String cedula){
        String nombre= null, contrasenia= null;
        try{
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("SELECT "+ "NOMBREPASAJERO, CONTRASENA " + "FROM  PASAJERO"+
                    " WHERE cedulapasajero = '" + cedula+"'");
            while(rs.next()){
                nombre = rs.getString("NOMBREPASAJERO");
                contrasenia = rs.getString("CONTRASENA");
                
            }
        }catch(SQLException ex){
            System.out.println("ConductorDB error: " +ex.getMessage());
        }
        String data[] ={cedula,nombre,contrasenia};
        return data;
    }
    
    public boolean repCedula(String cedula){
        String contrasenia= null;
        try{
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("SELECT "+ " CONTRASENA " + "FROM  PASAJERO"+
                    " WHERE cedulapasajero = '" + cedula+"'"); 
            while(rs.next()){
                contrasenia = rs.getString("CONTRASENA"); 
            }
        }catch(SQLException ex){
            System.out.println("ConductorDB error: " +ex.getMessage());
        }
        if(contrasenia != null){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean repCtaBanc(String numCta){
        String cvv = null;
        try{
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("SELECT "+ " CVV" + " FROM  CUENTABANCARIA "+
                    " WHERE NUMEROTARJETA = '" + numCta+"'");
            while(rs.next()){
                cvv = rs.getString("CONTRASENA"); 
            }
        }catch(SQLException ex){
            //System.out.println("ConductorDB error: " +ex.getMessage());
        }
        if(cvv != null){
            return true;
        }else{
            return false;
        }
    }
    
    public void modificarUsuario(Cliente c){
        PreparedStatement pst =null;
        String sql = "UPDATE PASAJERO SET  NOMBREPASAJERO = ?, DIRECCION = ?, TELEFONO= ?,"
                + " CORREO = ? "+ "WHERE CEDULAPASAJERO = ? ";
        try{
            Connection cnx = Coneccion.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setString(1,c.getNombre() );
            pst.setString(2, c.getDireccion());
            pst.setString(3, c.getTelefono());
            pst.setString(4, c.getCorreo());
            pst.setString(5, c.getCedula());
            pst.execute();
            //cnx.commit();
            pst.close();
            
        }catch(SQLException ex){
            System.out.println(" No se pudo modificar Cliente correctamente, error: " +ex.getMessage());
        }
    }
    
    public void modificarContrasenia(String contrasena, String id){
        PreparedStatement pst =null;
        String sql = "UPDATE PASAJERO SET  CONTRASENA = ? "+ "WHERE CEDULAPASAJERO = ? ";
        try{
            Connection cnx = Coneccion.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setString(1,contrasena);
            pst.setString(2,id );
            pst.execute();
            pst.close(); 
        }catch(SQLException ex){
            System.out.println(" No se pudo modificar la contraseña correctamente, error: " +ex.getMessage());
        }
    }
    
    public void  modificarCtaBancaria(String id, CtaBancaria c ){
        String viejaCta="";
        insertCtaBancaria(c);
        PreparedStatement pst =null;
        
        try{
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("SELECT  NUMEROTARJETA " + " FROM  PASAJERO "+
                    " WHERE CEDULAPASAJERO = '" + id+"'");
            while(rs.next()){
                viejaCta = rs.getString("NUMEROTARJETA"); 
            }
        }catch(SQLException ex){
            //System.out.println("mod Cuenta error: " +ex.getMessage());
        }
        
        String sql = "UPDATE PASAJERO SET  NUMEROTARJETA = ? "+ "WHERE CEDULAPASAJERO = ? ";
        try{
            Connection cnx = Coneccion.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setString(1,c.getNumTarjeta());
            pst.setString(2, id);
            pst.execute();
            pst.close();
            
        }catch(SQLException ex){
            System.out.println(" No se pudo modificar CtaBancaria correctamente, error: " +ex.getMessage());
        }
        sql = "DELETE FROM CUENTABANCARIA WHERE  NUMEROTARJETA = ?";
        try{
            Connection cnx = Coneccion.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setString(1,viejaCta ); 
            pst.execute();
            pst.close();
        }catch(SQLException ex){
            System.out.println(" No se pudo eliminar Cliente correctamente, error: " +ex.getMessage());
        }

    }
    
    public void eliminarUsuario(String id){
        PreparedStatement pst =null;
        eliminarUserFacturas(id);
        eliminarUserReserva(id);
        String viejaCta = "";
        try{
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
        //obtener el numero de cuenta antes de eliminar el usuario
            ResultSet rs = st.executeQuery("SELECT  NUMEROTARJETA " + " FROM  PASAJERO "+
                    " WHERE CEDULAPASAJERO = '" + id+"'");
            while(rs.next()){
                viejaCta = rs.getString("NUMEROTARJETA"); 
            }
        }catch(SQLException ex){
            System.out.println("Obtener numeCta Usuario para eliminar usuario error: " +ex.getMessage());
        }
        // Eliminar usuario 
        String sql = "DELETE FROM PASAJERO WHERE  CEDULAPASAJERO = ?";
         try{
            Connection cnx = Coneccion.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setString(1,id ); 
            pst.execute();
            pst.close();
        }catch(SQLException ex){
            System.out.println(" No se pudo eliminar el Cliente correctamente, error: " +ex.getMessage());
        }
         eliminarUserReserva(viejaCta);
    }
    public void eliminarUserFacturas(String id){
        PreparedStatement pst =null;
        String sql = "DELETE FROM FACTURA WHERE  CEDULAPASAJERO = ?";
         try{
            Connection cnx = Coneccion.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setString(1,id ); 
            pst.execute();
            pst.close();
        }catch(SQLException ex){
            System.out.println(" No se pudo ELIMINAR las factura  Cliente correctamente, error: " +ex.getMessage());
        }
    }
    
    public void eliminarUserReserva(String id){
        PreparedStatement pst =null;
        String sql = "DELETE FROM RESERVA WHERE  CEDULAPASAJERO = ?";
         try{
            Connection cnx = Coneccion.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setString(1,id ); 
            pst.execute();
            pst.close();
        }catch(SQLException ex){
            System.out.println(" No se pudo ELIMINAR las reservas  Cliente correctamente, error: " +ex.getMessage());
        }
    }
    
    public void eliminarUserCta(String numCta){
        PreparedStatement pst =null;
        String sql = "DELETE FROM CUENTABANCARIA WHERE  NUMEROTARJETA = ?";
         try{
            Connection cnx = Coneccion.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setString(1,numCta ); 
            pst.execute();
            pst.close();
        }catch(SQLException ex){
            System.out.println(" No se pudo ELIMINAR las CtaBanc  Cliente correctamente, error: " +ex.getMessage());
        }
    }
    
    public Cliente listarUsuario(String id){
        Cliente c = new Cliente();
        try{
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT "+ " NOMBREPASAJERO, DIRECCION, TELEFONO,  CONTRASENA,"
                                + " CORREO, NUMEROTARJETA "+ "FROM PASAJERO"
                                +" WHERE CEDULAPASAJERO = '" + id+"'");
            c.setCedula(id);
            while(rs.next()){
                c.setNombre(rs.getString("NOMBREPASAJERO"));
                c.setDireccion(rs.getString("DIRECCION")); 
                c.setTelefono(rs.getString("TELEFONO"));
                c.setContrasenia(rs.getString("CONTRASENA"));
                c.setCorreo(rs.getString("CORREO"));
                c.setNumCta(rs.getString("NUMEROTARJETA"));
                rs.close();
            }
        }catch(SQLException ex){
            System.out.println("ConductorDB error: " +ex.getMessage());
        }
        return c;
        
    }

    public void eliminarUserFacturaUnitario(int idReserva) {
        PreparedStatement pst =null;
        String sql = "DELETE FROM FACTURA WHERE  IDRESERVA = ?";
         try{
            Connection cnx = Coneccion.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, idReserva ); 
            pst.execute();
            pst.close();
        }catch(SQLException ex){
            System.out.println(" No se pudo ELIMINAR la factura (u)  Cliente correctamente, error: " +ex.getMessage());
        }
    }

    public void eliminarUserReservaUnitario(int idReserva) {
        PreparedStatement pst =null;
        String sql = "DELETE FROM RESERVA WHERE  IDRESERVA = ?";
         try{
            Connection cnx = Coneccion.getConnection();
            pst = cnx.prepareStatement(sql);
            pst.setInt(1,idReserva); 
            pst.execute();
            pst.close();
        }catch(SQLException ex){
            System.out.println(" No se pudo ELIMINAR la reserva (u)  Cliente correctamente, error: " +ex.getMessage());
        }
    }
    
    public ArrayList<Cliente> getList(){
        ArrayList<Cliente> listCliente = new ArrayList<Cliente>();
        try{
             //llamamos conexcion
            Connection cnx = Coneccion.getConnection();
            //PREPARA EL ESPACION
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("SELECT "+ "CEDULAPASAJERO, NOMBREPASAJERO, DIRECCION, TELEFONO, "
                    + " CONTRASENA, CORREO, NUMEROTARJETA " + " FROM  PASAJERO");
            //   jdbc:oracle:thin:@localhost:1521:XE 
            while(rs.next()){
            Cliente c = new Cliente();
            c.setCedula(rs.getString("CEDULAPASAJERO"));
            c.setNombre(rs.getString("NOMBREPASAJERO"));
            c.setDireccion(rs.getString("DIRECCION"));
            c.setTelefono(rs.getString("TELEFONO")); 
            c.setContrasenia(rs.getString("CONTRASENA")); 
            c.setCorreo(rs.getString("CORREO"));
            c.setNumCta(rs.getString("NUMEROTARJETA"));
            listCliente.add(c);
            }
        }catch(SQLException ex){
            System.out.println("det ListClient : error " +ex.getMessage());
        }//fin del CATCH
        return listCliente;        
    } 
}

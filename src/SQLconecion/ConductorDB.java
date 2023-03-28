package SQLconecion;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Conductor;

public class ConductorDB {
     
    public List<Conductor> getList(){
        List<Conductor> conductor = new ArrayList<Conductor>();
        try{
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT "+ "CEDULACONDUCTOR, NOMBRECONDUCTOR, TELEFONO, RUCEMPRESA " 
                    + "FROM  CONDUCTOR");
            while(rs.next()){
            Conductor c = new Conductor();
            c.setCedula(rs.getString("CEDULACONDUCTOR"));
            c.setNombre(rs.getString("NOMBRECONDUCTOR"));
            c.setTelefono(rs.getString("TELEFONO"));
            c.setRucEmpresa(rs.getString("RUCEMPRESA"));       
            conductor.add(c);
            }
        }catch(SQLException ex){
            System.out.println("ConductorDB error: " +ex.getMessage());
        }
        return conductor;
                
    }
    
    public void insert(Conductor c) {
        try{
            Connection cnx = Coneccion.getConnection();
            //permite hacer transacciones eliminar insertar
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO  "
                                + "CONDUCTOR ( CEDULACONDUCTOR, NOMBRECONDUCTOR, TELEFONO, RUCEMPRESA) "
                                + "VALUES( ?, ?, ?, ? )");
            pst.setString(1, c.getCedula());
            pst.setString(2, c.getNombre());
            pst.setString(3, c.getTelefono());
            pst.setString(4, c.getRucEmpresa());
            pst.executeUpdate();
        }catch(SQLException ex){
                System.out.println("conductorBD error insert: "+ ex.getMessage());
        }
    }
    
    public Conductor listarConductor(String id){
        Conductor c = new Conductor();
        try{
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT "+ " NOMBRECONDUCTOR, TELEFONO, RUCEMPRESA " 
                    + " FROM  CONDUCTOR WHERE CEDULACONDUCTOR = '"+id+"'");
            c.setCedula(id);
            while(rs.next()){
                c.setNombre(rs.getString("NOMBRECONDUCTOR"));
                c.setTelefono(rs.getString("TELEFONO"));
                c.setRucEmpresa(rs.getString("RUCEMPRESA"));       
            }
        }catch(SQLException ex){
            System.out.println("ConductorDB error: " +ex.getMessage());
        }
        return c;
                
    }
   
}


package SQLconecion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Cooperativa;
import model.Vehiculo;


public class VehiculoDB {
    
    public VehiculoDB(){}
    
    public ArrayList<Vehiculo> getList(){
        ArrayList<Vehiculo> listVehiculo = new ArrayList<Vehiculo>();
        try{
             //llamamos conexcion
            Connection cnx = Coneccion.getConnection();
            //PREPARA EL ESPACION
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("SELECT "+ "PLACA, MODELO, MARCA, COLOR, RUCEMPRESA " + " FROM  VEHICULO");
            //   jdbc:oracle:thin:@localhost:1521:XE 
            while(rs.next()){
            Vehiculo v = new Vehiculo();
            v.setPlaca(rs.getString("PLACA"));
            v.setModelo(rs.getString("MODELO"));
            v.setMarca(rs.getString("MARCA"));
            v.setColor(rs.getString("COLOR")); 
            v.setRucEmpresa(rs.getString("RUCEMPRESA")); 
            listVehiculo.add(v);
            }
        }catch(SQLException ex){
            System.out.println("CooperativaDB error: " +ex.getMessage());
        }//fin del CATCH
        return listVehiculo;        
    }   
    public Vehiculo listarVehiculo(String placa){
        Vehiculo v = new Vehiculo();
        try{
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT "+ "MODELO, MARCA, COLOR, RUCEMPRESA " 
                    + " FROM  VEHICULO WHERE PLACA = '"+placa+"'");
            v.setPlaca(placa);
            while(rs.next()){
            v.setModelo(rs.getString("MODELO"));
            v.setMarca(rs.getString("MARCA"));
            v.setColor(rs.getString("COLOR")); 
            v.setRucEmpresa(rs.getString("RUCEMPRESA")); 
            }
        }catch(SQLException ex){
            System.out.println("CooperativaDB error: " +ex.getMessage());
        }//fin del CATCH
        return v;       
    } 
}

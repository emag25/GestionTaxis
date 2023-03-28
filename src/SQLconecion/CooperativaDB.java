package SQLconecion;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Cooperativa;

public class CooperativaDB {
     
    public ArrayList<Cooperativa> getList(){
        ArrayList<Cooperativa> Cooperativa = new ArrayList<Cooperativa>();
        try{
             //llamamos conexcion
            Connection cnx = Coneccion.getConnection();
            //PREPARA EL ESPACION
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("SELECT "+ "RUC, NOMBRECOOPERATIVA, POLITICA, NUMEROTARJETA" + " FROM  COOPERATIVA");
            //   jdbc:oracle:thin:@localhost:1521:XE 
            while(rs.next()){
            Cooperativa c = new Cooperativa();
            c.setRuc(rs.getString("RUC"));
            c.setNombre(rs.getString("NOMBRECOOPERATIVA"));
            c.setPolitica(rs.getFloat("POLITICA"));
            c.setNumTarjeta(rs.getString("NUMEROTARJETA")); 
            Cooperativa.add(c);
            }
        }catch(SQLException ex){
            System.out.println("CooperativaDB error: " +ex.getMessage());
        }//fin del CATCH
        return Cooperativa;
                
            }
    
    
    public void insert(Cooperativa c) {
        try{
            Connection cnx = Coneccion.getConnection();
            //permite hacer transacciones eliminar insertar
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO  "
                                + "COOPERATIVA ( RUC, NOMBRECOOPERATIVA, POLITICA, NUMEROTARJETA) "
                                + "VALUES( ?, ?, ?, ? )");
            pst.setString(1, c.getRuc());
            pst.setString(2, c.getNombre());
            pst.setFloat(3, c.getPolitica());
            pst.setString(4, c.getNumTarjeta());
            pst.executeUpdate();
            }catch(SQLException ex){
                System.out.println("CooperativaBD error insert: "+ ex.getMessage());
            }
        }
    
    public Cooperativa listarCooperativa(String ruc){
        Cooperativa c = new Cooperativa();
        try{
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT "+ " NOMBRECOOPERATIVA, POLITICA, NUMEROTARJETA" 
                    + " FROM  COOPERATIVA WHERE RUC = '"+ ruc+ "'");
            c.setRuc(ruc);
            while(rs.next()){
            c.setNombre(rs.getString("NOMBRECOOPERATIVA"));
            c.setPolitica(rs.getFloat("POLITICA"));
            c.setNumTarjeta(rs.getString("NUMEROTARJETA")); 
            }
        }catch(SQLException ex){
            System.out.println("listar CooperativaDB error: " +ex.getMessage());
        }//fin del CATCH
        return c;
                
            }
    }
   


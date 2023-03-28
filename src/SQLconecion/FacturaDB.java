
package SQLconecion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Factura;


public class FacturaDB {
    
    public FacturaDB(){}
    
    public void insertFactura(Factura f) {
        f.setIdFactura(obtenerIdFactura()); 
        try{
            Connection cnx = Coneccion.getConnection();
            //permite hacer transacciones eliminar insertar
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO  "
                    + " FACTURA( IDFACTURA, VALORPORPERSONA, VALORAPAGAR, IDRESERVA, CEDULAPASAJERO) "
                    + " VALUES( ?, ?, ?, ?, ? ) ");
            pst.setInt(1, f.getIdFactura());
            pst.setFloat(2, f.getValorPagar());
            pst.setFloat(3, f.getValorPagar()*f.getValorPersona() );
            pst.setInt(4,f.getIdReserva());
            pst.setString( 5, f.getIdPasajero());
            pst.executeUpdate();
        }catch(SQLException ex){
                System.out.println("insert Factura error: "+ ex.getMessage());
        }
    }
    
    public Factura consultarFact(int idFactura){
        Factura f = new Factura();
        try{
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT  VALORPORPERSONA, VALORAPAGAR, IDRESERVA, CEDULAPASAJERO " 
                    + " FROM  FACTURA "+" WHERE IDFACTURA = '" + idFactura+"'");
            f.setIdFactura(idFactura);
            while(rs.next()){
                f.setValorPersona(rs.getFloat("VALORPORPERSONA"));
                f.setValorPagar(rs.getFloat("VALORAPAGAR"));
                f.setIdReserva(rs.getInt("IDRESERVA"));
                f.setIdPasajero(rs.getString("CEDULAPASAJERO"));     
            }
        }catch(SQLException ex){
            System.out.println("consulta una Factura  error: " +ex.getMessage());
        }
        return f;
    }
    
    public int obtenerIdFactura() {
        int idFactura = 0;
        try{
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("select MAX(IDFACTURA) FROM FACTURA");
            while(rs.next()){
                idFactura = rs.getInt("MAX(IDFACTURA)")+1; 
            }
        }catch(SQLException ex){
            System.out.println("FACTURA (ID) error: " +ex.getMessage());
        }
        return idFactura; 
    }
    public ArrayList<Factura> getList(){
        ArrayList<Factura> listReserva= new ArrayList<Factura>();
        try{
             //llamamos conexcion
            Connection cnx = Coneccion.getConnection();
            //PREPARA EL ESPACION
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("SELECT "+ " IDFACTURA, VALORPORPERSONA, VALORAPAGAR, IDRESERVA, "
                    + "CEDULAPASAJERO " + " FROM  FACTURA");
            //   jdbc:oracle:thin:@localhost:1521:XE 
            while(rs.next()){
            Factura f = new Factura();
            f.setIdFactura(rs.getInt("IDFACTURA") );
            f.setValorPersona(rs.getFloat("VALORPORPERSONA"));
            f.setValorPagar(rs.getFloat("VALORAPAGAR"));
            f.setIdReserva(rs.getInt("IDRESERVA"));
            f.setIdPasajero(rs.getString("CEDULAPASAJERO"));
            listReserva.add(f);
            }
        }catch(SQLException ex){
            System.out.println("listFactura error: " +ex.getMessage());
        }//fin del CATCH
        return listReserva;        
    } 
}

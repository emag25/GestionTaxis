
package SQLconecion;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import model.Reserva;
import model.Vehiculo;

public class ReservaDB {
    
    public ReservaDB(){}
    
    public void insert(Reserva r) {
        try{
            Connection cnx = Coneccion.getConnection();
            //permite hacer transacciones eliminar insertar
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO  "
                    + "RESERVA( IDRESERVA, ACOMPANANTES, ORIGEN, DESTINO, FECHAHORA,"
                    + "TOTALPASAJEROS, TARIFAVIAJE, CALIFICACION, COMENTARIO, CEDULAPASAJERO, "
                    + "RUC,CEDULACONDUCTOR, PLACA ) "
                    + "VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
            pst.setInt(1, r.getIdReserva());
            pst.setInt(2, r.getAcompaniante());
            pst.setString(3, r.getOrigen() );
            pst.setString(4,r.getDestino());
            pst.setTimestamp( 5, r.getFechaHora());
            pst.setInt(6, r.getTotalPasajero());
            pst.setFloat(7, r.getTarifaViaje()) ;
            pst.setInt(8, r.getCalificacion());
            pst.setString(9,r.getComentario());
            pst.setString(10, r.getCedulaPasajero() );
            pst.setString(11, r.getRuc() );
            pst.setString(12, r.getCedulaConductor());
            pst.setString(13, r.getPlaca());
            pst.executeUpdate();
        }catch(SQLException ex){
                System.out.println("conductorBD error insert: "+ ex.getMessage());
        }
    }
    
    public  JComboBox llenarCond(JComboBox cmbCoop){
        try{
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("SELECT "+ "NOMBRECONDUCTOR " 
                    + " FROM  CONDUCTOR");
            while(rs.next()){
                cmbCoop.addItem( rs.getString("NOMBRECONDUCTOR")); 
            }
        }catch(SQLException ex){
            System.out.println("ConductorDB (cmb) error: " +ex.getMessage());
        }
        return cmbCoop;
    }
    
    public  String obtenerCond(String nombre){
        String cedula = null;
        try{
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("SELECT  CEDULACONDUCTOR FROM  CONDUCTOR " +
                                "WHERE NOMBRECONDUCTOR = '"+ nombre+"'");
            while(rs.next()){
                cedula =  rs.getString("CEDULACONDUCTOR"); 
            }
        }catch(SQLException ex){
            System.out.println("ConductorDB (cedula) error: " +ex.getMessage());
        }
        return cedula;
    }
    
    public String obtenerRucCond(String nombre) {
        String ruc = null;
        try{
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("SELECT  RUCEMPRESA FROM  CONDUCTOR " +
                                "WHERE NOMBRECONDUCTOR = '"+ nombre+"'");
            while(rs.next()){
                ruc =  rs.getString("RUCEMPRESA"); 
            }
        }catch(SQLException ex){
            System.out.println("ConductorDB(ruc) error: " +ex.getMessage());
        }
        return ruc;
    }

    public String obtenerPlaca() {
        String placa = null;
        int numero;
        List<String> listPlaca = new ArrayList<String>();
        try{
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("SELECT "+ " placa " + "FROM  VEHICULO");
            while(rs.next()){
                listPlaca.add(rs.getString("placa")); 
            }
        }catch(SQLException ex){
            System.out.println("ConductorDB (placa) error: " +ex.getMessage());
        }
        numero = (int)((Math.random()*listPlaca.size()-1)+1); 
        placa = listPlaca.get(numero);
        return placa;
    }

    public int obtenerIdRserva() {
        int idReserva = 0;
        try{
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("select MAX(IDRESERVA) FROM reserva");
            while(rs.next()){
                idReserva = rs.getInt("MAX(IDRESERVA)")+1; 
            }
        }catch(SQLException ex){
            System.out.println("Reserva (ID) error: " +ex.getMessage());
        }
        return idReserva; 
    }
    
    public List<Reserva> getListReserva(String cedula){
        List<Reserva> listR = new ArrayList<Reserva>();
        try{
             //llamamos conexcion
            Connection cnx = Coneccion.getConnection();
            //PREPARA EL ESPACION
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("SELECT "+ "IDRESERVA, FECHAHORA, ORIGEN, DESTINO " + "FROM  RESERVA "
                                        +" WHERE CEDULAPASAJERO= '"+cedula+"'");
            //   jdbc:oracle:thin:@localhost:1521:XE 
            while(rs.next()){
            Reserva r = new Reserva();
            r.setIdReserva(rs.getInt("IDRESERVA"));
            r.setFechaHora(rs.getTimestamp("FECHAHORA"));
            r.setOrigen(rs.getString("ORIGEN"));
            r.setDestino(rs.getString("DESTINO"));       
            listR.add(r);
            }
        }catch(SQLException ex){
            System.out.println("ReservaDB (consulta) error: " +ex.getMessage());
        }//fin del CATCH
        return listR;        
    }
    
    public Reserva llenarConsulta(int idReserva){
        Reserva r = new Reserva();
        try{ // 
             //llamamos conexcion
            Connection cnx = Coneccion.getConnection();
            //PREPARA EL ESPACION
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("SELECT "+ "  FECHAHORA, ORIGEN, DESTINO, RUC, "
                    + "TOTALPASAJEROS, TARIFAVIAJE, CEDULACONDUCTOR, PLACA FROM  RESERVA "
                    +" WHERE IDRESERVA = '"+idReserva+"'");
            //   jdbc:oracle:thin:@localhost:1521:XE 
            r.setIdReserva(idReserva);
            while(rs.next()){
            r.setFechaHora(rs.getTimestamp("FECHAHORA"));
            r.setOrigen(rs.getString("ORIGEN"));
            r.setDestino(rs.getString("DESTINO"));  
            r.setRuc(rs.getString("RUC"));
            r.setTotalPasajero(rs.getInt("TOTALPASAJEROS"));
            r.setTarifaViaje(rs.getFloat("TARIFAVIAJE")); 
            r.setCedulaConductor(rs.getString("CEDULACONDUCTOR"));
            r.setPlaca(rs.getString("PLACA")); 
            }
        }catch(SQLException ex){
            System.out.println("ReservaDB(llenar FRMRESERVA FINAL CLIENTE) error: " +ex.getMessage());
        }//fin del CATCH
//////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{ // 
             //llamamos conexcion
            Connection cnx = Coneccion.getConnection();
            //PREPARA EL ESPACION
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("SELECT "+ "  NOMBRECOOPERATIVA "+" FROM  COOPERATIVA "
                    +" WHERE RUC = '"+r.getRuc()+"'");
            //   jdbc:oracle:thin:@localhost:1521:XE 
            while(rs.next()){
            r.setRuc(rs.getString("NOMBRECOOPERATIVA"));
            }
        }catch(SQLException ex){
            System.out.println("ReservaDB(llenar FRMRESERVA FINAL COOPERATIVA) error: " +ex.getMessage());
        }//fin del CATCH
//////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{ // 
             //llamamos conexcion
            Connection cnx = Coneccion.getConnection();
            //PREPARA EL ESPACION
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("SELECT "+ "  NOMBRECONDUCTOR "+" FROM  CONDUCTOR "
                    +" WHERE CEDULACONDUCTOR = '"+r.getCedulaConductor()+"'");
            //   jdbc:oracle:thin:@localhost:1521:XE 
            while(rs.next()){
            r.setCedulaConductor(rs.getString("NOMBRECONDUCTOR"));
            }
        }catch(SQLException ex){
            System.out.println("ReservaDB(llenar FRMRESERVA FINAL Conductor) error: " +ex.getMessage());
        }//fin del CATCH
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
//       
        return r; 
    }
    
    public Vehiculo obtenerVehiculo(String placa){
        Vehiculo v= new Vehiculo();
         try{ //llamamos conexcion
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT "+ " MARCA, MODELO, COLOR "+" FROM  VEHICULO "
                    +" WHERE PLACA = '"+placa+"'");
            v.setPlaca(placa);
            while(rs.next()){
            v.setMarca(rs.getString("MARCA"));
            v.setModelo(rs.getString("MODELO")); 
            v.setColor(rs.getString("COLOR"));
            }
        }catch(SQLException ex){
            System.out.println("ReservaDB(llenar FRMRESERVA FINAL Vehiculo) error: " +ex.getMessage());
        }//fin del CATCH
        return v;
    }
    
    public int cantidadReserva(String cedula){
        int  cantidad= 0;
         try{ //llamamos conexcion
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT "+" COUNT(*) "+ " FROM RESERVA WHERE CEDULAPASAJERO = '"+cedula+"'");
            while(rs.next()){
            cantidad = (rs.getInt("COUNT(*)"));
            }
        }catch(SQLException ex){
            System.out.println("Conteo Reserva error: " +ex.getMessage());
        }//fin del CATCH
        return cantidad;
        
    }
    
    public ArrayList<Reserva> getList(){
        ArrayList<Reserva> listReserva= new ArrayList<Reserva>();
        try{
             //llamamos conexcion
            Connection cnx = Coneccion.getConnection();
            //PREPARA EL ESPACION
            Statement  st = cnx.createStatement();
            //BOTA EN TABLA O RESULTADOS
            ResultSet rs = st.executeQuery("SELECT "+ " IDRESERVA, ACOMPANANTES, ORIGEN, DESTINO, "
                    + "FECHAHORA, TOTALPASAJEROS, TARIFAVIAJE, CALIFICACION, COMENTARIO, "
                    + "CEDULAPASAJERO, RUC, CEDULACONDUCTOR, PLACA  " + " FROM  RESERVA");
            //   jdbc:oracle:thin:@localhost:1521:XE 
            while(rs.next()){
            Reserva r = new Reserva();
            r.setIdReserva(rs.getInt("IDRESERVA"));
            r.setAcompaniante(rs.getInt("ACOMPANANTES"));
            r.setOrigen(rs.getString("ORIGEN"));
            r.setDestino(rs.getString("DESTINO"));
            r.setFechaHora(rs.getTimestamp("FECHAHORA"));;
            r.setTotalPasajero(rs.getInt("TOTALPASAJEROS"));
            r.setTarifaViaje(rs.getFloat("TARIFAVIAJE"));
            r.setCalificacion(rs.getInt("CALIFICACION"));;
            r.setComentario(rs.getString("COMENTARIO")); 
            r.setCedulaPasajero(rs.getString("CEDULAPASAJERO"));
            r.setRuc(rs.getString("RUC"));
            r.setCedulaConductor(rs.getString("CEDULACONDUCTOR"));
            r.setPlaca(rs.getString("PLACA"));
            listReserva.add(r);
            }
        }catch(SQLException ex){
            System.out.println("listReserva error: " +ex.getMessage());
        }//fin del CATCH
        return listReserva;        
    } 
    
    public Reserva listarReserva(int idReserva){
        Reserva r = new Reserva();
        try{
            Connection cnx = Coneccion.getConnection();
            Statement  st = cnx.createStatement();
//            ResultSet rs = st.executeQuery("SELECT " + " ACOMPANANTES, ORIGEN, DESTINO, "
//                    + "FECHAHORA, TOTALPASAJEROS, TARIFAVIAJE, CALIFICACION, COMENTARIO, "
//                    + "CEDULAPASAJERO, RUC, CEDULACONDUCTOR, PLACA  " + " FROM  RESERVA "
//                    +" WHERE IDRESERVA = '"+idReserva+"'");
            ResultSet rs = st.executeQuery("SELECT  ACOMPANANTES, ORIGEN, DESTINO, FECHAHORA, TOTALPASAJEROS,"
                    + " TARIFAVIAJE, CALIFICACION, COMENTARIO, CEDULAPASAJERO, RUC, CEDULACONDUCTOR, PLACA   "
                    + "FROM  RESERVA "+ " WHERE IDRESERVA = '"+idReserva+"'");
            r.setIdReserva(idReserva);
            while(rs.next()){
            r.setAcompaniante(rs.getInt("ACOMPANANTES"));
            r.setOrigen(rs.getString("ORIGEN"));
            r.setDestino(rs.getString("DESTINO"));
            r.setFechaHora(rs.getTimestamp("FECHAHORA"));
            r.setTotalPasajero(rs.getInt("TOTALPASAJEROS"));
            r.setTarifaViaje(rs.getFloat("TARIFAVIAJE"));
            r.setCalificacion(rs.getInt("CALIFICACION"));
            r.setComentario(rs.getString("COMENTARIO")); 
            r.setCedulaPasajero(rs.getString("CEDULAPASAJERO"));
            r.setRuc(rs.getString("RUC"));
            r.setCedulaConductor(rs.getString("CEDULACONDUCTOR"));
            r.setPlaca(rs.getString("PLACA"));
            }
        }catch(SQLException ex){
            System.out.println("obtener una Reserva error: " +ex.getMessage());
        }//fin del CATCH
        return r;        
    } 
}

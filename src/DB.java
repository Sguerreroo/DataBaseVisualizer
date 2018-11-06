import java.sql.*;
import java.util.logging.*;

public class DB {
    
    String username;
    String password;
    Connection con;
    public boolean login(String username,   String password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://mozart.dis.ulpgc.es/DIU_2018_19?useSSL=true",
                username,
                password);
            
            
        }catch(SQLException e){
            return false;
        }catch(Exception e){
            return false;
        }
        this.username = username;
        this.password = password;
        return true;
    }
    
    public boolean logout(){
        try{
            con.close();
            this.password=null;
            this.username=null;
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    
    
    public static void getInformation(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://SERVIDOR/BASE_DE_DATOS?useSSL=true",
                "USUARIO",
                "CLAVE");
            DatabaseMetaData md = con.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = md.getTables(null, null, "%", types);
            while (rs.next()) {
                String nombreTabla = rs.getString("TABLE_NAME");
                System.out.println("Tabla: " + nombreTabla);
                ResultSet rs2 = md.getColumns(null, null, nombreTabla, null);
                while (rs2.next()) {
                    String nombreCampo = rs2.getString("COLUMN_NAME");
                    System.out.println("   Campo: " + nombreCampo);
                }
            }           
            con.close();        
        }catch(Exception e){
            
        }
    }
}

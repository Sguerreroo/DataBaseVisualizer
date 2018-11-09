import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class DB {
    
    private String username;
    private String password;
    private Connection con;
    public boolean login(String username, String password) {
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
    
    
    
    public List getInformation(){
        List<Table> tables = new ArrayList<>();
        try{
            DatabaseMetaData md = con.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = md.getTables(null, null, "%", types);
            while (rs.next()) {
                String nombreTabla = rs.getString("TABLE_NAME");
                Table tabla =  new Table(nombreTabla);
                ResultSet rs2 = md.getColumns(null, null, nombreTabla, null);
                while (rs2.next()) {
                    String nombreCampo = rs2.getString("COLUMN_NAME");
                    tabla.addField(nombreTabla, nombreCampo);
                }
                tables.add(tabla);
            }           
            con.close();        
        }catch(Exception e){
            
        }
        return tables;
    }
}

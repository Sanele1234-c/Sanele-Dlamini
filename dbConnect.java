import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbConnect {
    public Connection conn = null;
    void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/schooldb2?" +"user=root&password=";
            conn = DriverManager.getConnection(connectionUrl);
            System.out.println("Connection Successfull");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(dbConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Class Not Found Exception: "+ ex.toString());
        }
        catch (SQLException ex) {
            Logger.getLogger(dbConnect.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.out.println("sql exeption"+ex.toString());//concatenation
        }
    }
    Statement createStatement(){

        try {
            return conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(dbConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    CallableStatement prepareCall(String sql){

        try {
            return conn.prepareCall(sql);
        } catch (SQLException ex) {
            Logger.getLogger(dbConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    PreparedStatement preparedStatement(String sql, int[] cols) {
        try {
            return conn.prepareStatement(sql, cols);
        } catch (SQLException ex) {
            Logger.getLogger(dbConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

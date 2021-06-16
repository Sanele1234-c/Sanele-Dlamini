/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldenfarm;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sjoth
 */
public class DbConnect {
     public Connection conn = null;
    void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/development?" +"user=root&password=";
            conn = DriverManager.getConnection(connectionUrl);
            System.out.println("Connection Successfull");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Class Not Found Exception: "+ ex.toString());
        }
        catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.out.println("sql exeption"+ex.toString());//concatenation
        }
    }
    Statement createStatement(){

        try {
            return conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    CallableStatement prepareCall(String sql){

        try {
            return conn.prepareCall(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    PreparedStatement preparedStatement(String sql, int[] cols) {
        try {
            return conn.prepareStatement(sql, cols);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

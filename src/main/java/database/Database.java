package database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mac
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mac
 */
public class Database {
    static final String url = "jdbc:sqlserver://localhost:1433;trustServerCertificate=true;databaseName=TutorialDB";
    static final String user = "sa";
    static final String password = "Password.1";
    private static Connection conn = null;
    
    private Database(){

    }
    
    
    public static Connection getInstance(){
        if (conn == null){
            try { 
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
//                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }

   


    
    public void close(){
        try{
            if (conn != null){
                conn.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
}

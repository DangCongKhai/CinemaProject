/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.Database;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static util.Util.hashPassword;

/**
 *
 * @author mac
 */
public class SignUpController {
    private static SignUpController sign_up_controller;
    
    private static Connection conn = Database.getInstance();
    private SignUpController(){
  
    }
    
    public synchronized static SignUpController getInstance(){
        if (sign_up_controller == null){
            sign_up_controller = new SignUpController();
        }
        return sign_up_controller;
    }
    private boolean isEmailExist(String email){
        
        String query = "SELECT Email FROM Account WHERE Email = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);
            pstm.setString(1, email);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                return true;
            }
        } catch (SQLException ex) {
//            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        return false;
    }
    
    public boolean signUpAccount(String email, String password) throws SQLException{
        if (isEmailExist(email)){
            return false;
        }
        int account_id = -1;
        String hashed_password = hashPassword(password);
        String insert_account_query = "INSERT INTO Account(Email, Password, Role) " 
                        + "VALUES (?, ? ,'Customer');";
        // Get connection
        PreparedStatement ps1 = null;
        ps1 = conn.prepareStatement(insert_account_query, Statement.RETURN_GENERATED_KEYS);
        ps1.setString(1, email);
        ps1.setString(2, hashed_password);
        ps1.executeUpdate();
        ResultSet account_id_generated = ps1.getGeneratedKeys();
        if (account_id_generated.next()){

            account_id = account_id_generated.getInt(1);
            System.out.println("Generated account ID: "+account_id);
            String insert_user = "INSERT INTO [User](AccountID, Name) \n"
                                + "VALUES (?, ?);";
            PreparedStatement ps2 = null;
            ps2 = conn.prepareStatement(insert_user, Statement.RETURN_GENERATED_KEYS);
            ps2.setInt(1, account_id);
            ps2.setString(2, "Customer"); 
            ps2.executeUpdate();
            return true;
        }
        
        return false;  
        
    }
    
    public int getAccountID(String email, String password, String name){
        int account_id = -1;
        String query = "SELECT AccountID FROM Account WHERE Email = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);
            pstm.setString(1, email);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                return rs.getInt("AccountID");
            }
        } catch (SQLException ex) {
            System.out.println("Error while getting Account ID on top 1");
            System.out.println(ex.getMessage());
//            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            String hashed_password = hashPassword(password);
            String insert_account_query = "INSERT INTO Account(Email, Password, Role) " 
                            + "VALUES (?, ? ,'Customer');";
            // Get connection
            PreparedStatement ps1 = null;
            ps1 = conn.prepareStatement(insert_account_query, Statement.RETURN_GENERATED_KEYS);
            ps1.setString(1, email);
            ps1.setString(2, hashed_password);
            ps1.executeUpdate();
            
            ResultSet account_id_generated = ps1.getGeneratedKeys();
            if (account_id_generated.next()){
     
                account_id = account_id_generated.getInt(1);
                System.out.println("Generated account ID: "+account_id);
                String insert_user = "INSERT INTO [User](AccountID, Name) \n"
                                    + "VALUES (?, ?);";
                PreparedStatement ps2 = null;
                ps2 = conn.prepareStatement(insert_user, Statement.RETURN_GENERATED_KEYS);
                ps2.setInt(1, account_id);
                ps2.setString(2, name); 
                ps2.executeUpdate();
            }
        } catch (SQLException ex) {
//            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error while getting Account ID");
            System.out.println(ex.getMessage());
        }
       
        return account_id;
    }
    
}

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
        } catch (SQLException ex) {
//            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
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
        String hashed_password = hashPassword(password);
        String query = "INSERT INTO Account(Email, Password, Role)" 
                        + "VALUES (?, ? ,'Customer');"
                + "INSERT INTO [User](AccountID, Name, Balance)"
                + "VALUES ((SELECT AccountID FROM Account WHERE Email = ?), 'Customer', 0);";
        
        // Get connection
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);
        } catch (SQLException ex) {
//            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pstm.setString(1, email);
        pstm.setString(2, hashed_password);
        pstm.setString(3, email);
        
        int row = pstm.executeUpdate();
        return true;
        
        
    }
    
}

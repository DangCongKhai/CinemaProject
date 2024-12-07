/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.User;
import static util.Util.verifyPassword;
/**
 *
 * @author mac
 */
public final class LoginController {
    private final int InvalidPassWord = 1;
    private final int EmailNotExist = 2;
    private final int SuccessLogin = 0;
    private static LoginController login_controller;
    private static Connection conn = Database.getInstance();
    private LoginController(){
        
    }
    public boolean isEmailExist(String email){
        
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
    
    public static LoginController getInstance(){
        LoginController result = login_controller;
        if (result != null){
            return result;
        }
        synchronized(LoginController.class){
            if (login_controller == null){
                login_controller = new LoginController();
            }
            return login_controller;
        }
    }
    
    public int login(String email, String password) throws SQLException{
//        PreparedStatement prepared_statement = db.getPrepared_statement()
    int account_id = -1;
    String query = "SELECT AccountID, Password, Role from Account WHERE email = ?";
    PreparedStatement prepared_statement = conn.prepareStatement(query);
    prepared_statement.setString(1, email);
    ResultSet rs = prepared_statement.executeQuery();
    if (rs.next()){
        String role = rs.getString("Role");
        if (role.equals("Admin")){
   
            if (rs.getString("password").equals(password)){
                account_id = rs.getInt("AccountID");
            }
        }else{
//            String prefix = "{bcrypt}";
//            String hash_pw = rs.getString("password").substring(prefix.len)
            if (verifyPassword(password, rs.getString("password"))){
            account_id = rs.getInt("AccountID");
        }
        }
        
    }
    return account_id;
    }
    
    public User getUserInfo(int account_id){
        String query = "SELECT [User].*, Role from [User]\n" +
                        "JOIN Account ON [User].[AccountID] = Account.AccountID\n" +
                        "WHERE Account.AccountID = ?";
        
        User user = null;
        String role = null;
        try {       
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, account_id);
            ResultSet result = statement.executeQuery();
            if (result.next()){
                role = result.getString("Role");
                if (role.equals("Customer")){
                    user = new Customer(result.getString("Birthday"), result.getLong("Balance"), result.getInt("UserID"),result.getString("Name"), result.getString("Gender"),role);
                }else{
                    user = new User(result.getInt("UserID"),result.getString("Name"), result.getString("Gender"),role);
                }
                
            }
        } catch (SQLException ex) {
                System.out.println("Exception occured here");
//            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    
    
   
    
}

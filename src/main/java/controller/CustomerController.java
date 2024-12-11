/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.Database;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Movie;

/**
 *
 * @author mac
 */
public class CustomerController {
    private static CustomerController customer_controller;
    private static Connection conn = Database.getInstance();
    
    private CustomerController(){
//        conn = 
//        if (conn == null){
//            System.out.println("Connection is null");
//        }
    }
    
    public synchronized static CustomerController getInstance(){
        if (customer_controller == null){
            customer_controller = new CustomerController();
        }
        return customer_controller;
    }
    
    public ArrayList<Movie> getMovies(){
        if (conn == null){
            return new ArrayList<Movie>();
        }
        String query = "SELECT * FROM Movie";
        ResultSet res = null;
        ArrayList<Movie> movies_list = new ArrayList();
        try {
            Statement statement = conn.createStatement();
            res = statement.executeQuery(query);
            while (res.next()){
                int movieId = res.getInt("MovieID"); String title = res.getString("Title"); String genre = res.getString("Genre"); String actor = res.getString("Actor");
                int duration = res.getInt("Duration"); String description = res.getString("Description"); byte[] image = res.getBytes("Image");
                movies_list.add(new Movie(movieId, title, genre,duration,actor, description, image));
                
            }
        }catch (SQLException ex) {
//            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
//            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        return movies_list;
    }
    
    public ArrayList<Movie> searchByTitles(String search_title){
       
        String query = "SELECT * FROM Movie WHERE Title like ?";
        ResultSet res = null;
        ArrayList<Movie> movies_list = new ArrayList();
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, "%" + search_title+"%");
            res = statement.executeQuery();
            while (res.next()){
                int movieId = res.getInt("MovieID"); String title = res.getString("Title"); String genre = res.getString("Genre"); String actor = res.getString("Actor");
                int duration = res.getInt("Duration"); String description = res.getString("Description"); byte[] image = res.getBytes("Image");
                
                movies_list.add(new Movie(movieId, title, genre,duration,actor, description, image));
                
            }
        }catch (SQLException ex) {
//            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
//            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
      
        return movies_list;
    }
    
    
  
    
}


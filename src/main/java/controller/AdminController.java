/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.raven.datechooser.SelectedDate;
import database.Database;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import java.util.Date;
//import java.sql.Date;
import model.Movie;
import model.Schedule;
import model.Screen;
import static util.Util.hourMinuteToTime;
/**
 * 
 *
 * @author mac
 */
public class AdminController {
    private static AdminController admin_controller;
    private static Connection conn = Database.getInstance();
    
    private AdminController(){
    
    }
    
    public synchronized static AdminController getInstance(){
        if (admin_controller == null){
            admin_controller = new AdminController();
        }
        return admin_controller;
    }
    
    public boolean addMovie(Movie new_movie){
        

        String query = "INSERT INTO Movie(MovieID, Title, Genre, Duration, Actor, Description, Image)"
                + "VALUES ( ?, ?,?,?,?, ?, ?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, new_movie.getMovieID());
            pstm.setString(2, new_movie.getTitle());
            pstm.setString(3, new_movie.getGenre());
            pstm.setInt(4, new_movie.getDuration());
            pstm.setString(5, new_movie.getActor());
            pstm.setString(6, new_movie.getDescription());
            pstm.setBytes(7, new_movie.getImage());
            
            int row = pstm.executeUpdate();
            if (row > 0){
                return true;
            }
        } catch (Exception ex) {
//            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Movie> getExistingMovie(){
        String query = "SELECT MovieID, Title, Genre, Duration, Actor, Description, Image from Movie";
        ResultSet available_movies = null;
        ArrayList<Movie> movies_list = new ArrayList<>();
        try{
            PreparedStatement pstm = conn.prepareStatement(query);
            available_movies = pstm.executeQuery();
            while (available_movies.next()){
                int movieID = available_movies.getInt("MovieID");
                String title = available_movies.getString("Title"); String genre = available_movies.getString("Genre");
                int duration = available_movies.getInt("Duration"); String description = available_movies.getString("Description"); String actor = available_movies.getString("Actor");
                byte[] image = available_movies.getBytes("Image");
                movies_list.add(new Movie(movieID,title, genre, duration, actor, description,image));
            }
            
            
        }catch(Exception e){
            
        }
        return movies_list;
    }
    public byte[] getImage(String title){
        String query = "SELECT Image FROM Movie WHERE Title = ?";
        ResultSet result = null;
        try{
            PreparedStatement pstm = conn.prepareStatement(query);
            result = pstm.executeQuery();
        }catch(Exception e){
            
        }
        try {
            if (result.next()){
                return result.getBytes("Image");
            }
        } catch (SQLException ex) {
//            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean upDateMovieInfo(Movie new_movie,Movie old_movie ){
        String query = "UPDATE Movie "
                + "SET Title = ?, Genre = ?, Duration = ?, Actor = ?, Description = ?, Image = ? WHERE MovieID = ?";
        int result = -1;
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, new_movie.getTitle());
            pstm.setString(2, new_movie.getGenre());
            pstm.setInt(3, new_movie.getDuration());
            pstm.setString(4, new_movie.getActor());
            pstm.setString(5, new_movie.getDescription());
            pstm.setBytes(6, new_movie.getImage());
            pstm.setInt(7, old_movie.getMovieID());
            result =  pstm.executeUpdate();
        } catch (SQLException ex) {
//            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == 1){
            return true;
        }
        return false;     
    }
    
    public boolean deleteMovie(Movie movie){
        int result = -1;
        try {
            String query = "DELETE FROM Movie WHERE MovieID = ?";
            
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, movie.getMovieID());
            result = pstm.executeUpdate();
        } catch (SQLException ex) {
//            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == 1){
            return true;
        }
        return false;
    }
    
    public ArrayList<Screen> getScreen(){
        String query = "SELECT ScreenNumber FROM Screen ";
        PreparedStatement pstm = null;
        ArrayList<Screen> screens_list = new ArrayList<>();
        try {
            pstm = conn.prepareStatement(query);
            ResultSet res = pstm.executeQuery();
            while (res.next()){
                
            }
        } catch (SQLException ex) {
//            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return screens_list;
        
    }
    public ResultSet getAvailableSchedule(){
        ArrayList<Schedule> schedules_list = new ArrayList<>();
        Statement statement = null;
        String query = "select s.*, m.Title from Schedule as s\n" +
                        "JOIN Movie as m ON s.MovieID = m.MovieID"; 
        
        ResultSet result = null;
        try {
            statement = conn.createStatement();
            result = statement.executeQuery(query);
           
        } catch (SQLException ex) {
//            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean insertSchedule(Schedule schedule){
        // Get information that can be overlapped
        // Get screen
        int screen_number = schedule.getscreen_number();
        
        // Get start time and end time
        LocalTime startTime = LocalTime.parse(schedule.getStart_time());
        LocalTime endTime = LocalTime.parse(schedule.getEnd_time());
    
        int start_time = startTime.getHour() * 60 + startTime.getMinute();
        int end_time = endTime.getHour() * 60 + endTime.getMinute();
        
        // Get show date
        SelectedDate show_date = schedule.getShow_date();
        LocalDate releaseDate = LocalDate.of(show_date.getYear(), show_date.getMonth(), show_date.getDay());
        java.sql.Date sql_date = java.sql.Date.valueOf(releaseDate);
    
        String check_overlapped_schedule_query = "SELECT * FROM Schedule WHERE "
                + " ((StartTime > ? AND StartTime - 30 < ?) OR (StartTime <= ? AND EndTime + 30 > ?)) AND ScreenID = (SELECT ScreenID from Screen WHERE ScreenNumber = ?) AND ShowDate = ?";
        ResultSet overlapped_result = null;
        try {
            PreparedStatement pstm = conn.prepareStatement(check_overlapped_schedule_query);
            pstm.setInt(1, start_time); pstm.setInt(2, end_time); 
            pstm.setInt(3, start_time); pstm.setInt(4, start_time);
            pstm.setInt(5, screen_number); pstm.setDate(6, sql_date);
          
            overlapped_result = pstm.executeQuery();
            
            if (!overlapped_result.next()){
                        
                String query = "INSERT INTO Schedule (ScheduleID, ShowDate, StartTime, EndTime, Price, MovieID, ScreenID)\n" +
                                "VALUES (?, ?, ?, ?, ?, (SELECT MovieID FROM Movie where Title = ?), (SELECT ScreenID FROM Screen where ScreenNumber = ?))";
                int res;
                try{
                   PreparedStatement insert_pstm = conn.prepareStatement(query);
                   insert_pstm.setInt(1, schedule.getScheduleID());
                    insert_pstm.setDate(2, sql_date);
                    insert_pstm.setInt(3, start_time);
                    insert_pstm.setInt(4, end_time);
                    insert_pstm.setLong(5, schedule.getPrice());
                    insert_pstm.setString(6, schedule.getTitle());
                    insert_pstm.setInt(7, screen_number);
                    res = insert_pstm.executeUpdate();
                  
                    if (res == 1){
                        return true;
                    }
                }catch (SQLException e){
                    System.out.println(e.getMessage());
                }   
                
                
            }
        } catch (SQLException ex) {
            System.out.println("Exception :"+ ex.getMessage());
//            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return false;
    }
    public Schedule getScheduleFromResultSet(ResultSet result){
        try {
            int scheduleID = result.getInt("ScheduleID");
            String title = result.getString("Title");
            java.util.Date util_date = result.getDate("ShowDate");
       
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String d = df.format(util_date);
            int DAY = Integer.valueOf(d.split("-")[0]);
            int MONTH = Integer.valueOf(d.split("-")[1]);
            int YEAR = Integer.valueOf(d.split("-")[2]);
            SelectedDate selected_date = new SelectedDate(DAY, MONTH, YEAR);
            String start_time = hourMinuteToTime(result.getInt("StartTime"));
            String end_time = hourMinuteToTime(result.getInt("EndTime"));
            long price = result.getLong("Price");
            int screen_number = result.getInt("ScreenID");
            return new Schedule(scheduleID, title, selected_date, start_time, end_time, price, screen_number);
        } catch (SQLException ex) {
//            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean deleteSchedule(Schedule schedule){
        String query = "DELETE FROM Schedule where ScheduleID = ?";
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, schedule.getScheduleID());
            int result = pstm.executeUpdate();
            if (result == 1){
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    
 
}

/*
To-do list:
- Add screen and seat data to the table;
- Learn Transact-SQL code to batch update the seat
- 
*/
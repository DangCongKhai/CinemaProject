/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import datechooser.SelectedDate;
import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FoodDrink;
import model.Movie;
import model.OrderFoodDrink;
import model.Schedule;
import model.SeatSchedule;
import model.Ticket;
import static util.Util.hourMinuteToTime;

/**
 *
 * @author mac
 */
public class GuestController {
    private static GuestController guest_controller;
    private static Connection conn = Database.getInstance();
    private GuestController(){
        
    }
    
    public synchronized static GuestController getInstance(){
        if (guest_controller == null){
            guest_controller = new GuestController();
        }
        return guest_controller;
    }
    private ArrayList<Schedule> getScheduleFromResultSet(ResultSet result){
        ArrayList<Schedule> schedules_list = new ArrayList();
        try {
            while (result.next()){
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
                schedules_list.add(new Schedule(scheduleID, title, selected_date, start_time, end_time, price, screen_number));
                
            }
        } catch (SQLException ex) {
            
//            Logger.getLogger(GuestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return schedules_list;

    }
    
    public ArrayList<SelectedDate> getScheduleForMovie(Movie movie){
        
        String query = "select distinct(s.ShowDate) from Schedule as s " + "JOIN Movie as m ON s.MovieID = m.MovieID WHERE m.Title = ?";
                      
        ArrayList<SelectedDate> showdates_list = new ArrayList();
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(query);
            pstm.setString(1, movie.getTitle());
            ResultSet result = pstm.executeQuery();
            while (result.next()){
                java.util.Date util_date = result.getDate("ShowDate");
                
       
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                String d = df.format(util_date);
                int DAY = Integer.valueOf(d.split("-")[0]);
                int MONTH = Integer.valueOf(d.split("-")[1]);
                int YEAR = Integer.valueOf(d.split("-")[2]);
                SelectedDate selected_date = new SelectedDate(DAY, MONTH, YEAR);
                showdates_list.add(selected_date);
            }
            
        } catch (SQLException ex) {
//            Logger.getLogger(GuestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return showdates_list;  
    }
    
    public ArrayList<Schedule> getShowTimeForMovieAndDate(Movie movie, SelectedDate show_date){
        ArrayList<Schedule> schedules_list = new ArrayList();
 
         LocalDate releaseDate = LocalDate.of(show_date.getYear(), show_date.getMonth(), show_date.getDay());
        java.sql.Date sql_date = java.sql.Date.valueOf(releaseDate);
        
        String query = "SELECT s.*, m.Title from Schedule AS s JOIN Movie as m ON s.MovieID = m.MovieID WHERE s.MovieID = ? AND ShowDate = ?";
        
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, movie.getMovieID());
            pstm.setDate(2, sql_date);
            ResultSet result = pstm.executeQuery();
            schedules_list = getScheduleFromResultSet(result);
        } catch (SQLException ex) {
            System.out.println("Error while getting show time for movie "+movie.getTitle());
//            Logger.getLogger(GuestController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return schedules_list;
    }
    
    public ArrayList<SeatSchedule> getSeatForSchedule(Schedule schedule){
        ArrayList<SeatSchedule> seat_schedule_list = new ArrayList();
        String query = "SELECT ss.SeatScheduleID, s.ScheduleID, ss.SeatID, ss.Status, SeatNumber from Schedule as s "
                + "JOIN SeatSchedule as ss ON s.ScheduleID = ss.ScheduleID "
                + "JOIN Seat ON ss.SeatID = Seat.SeatID "
                + "where s.ScheduleID = ?";
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, schedule.getScheduleID());
            ResultSet result = pstm.executeQuery();
            while (result.next()){
                int seatScheduleID = result.getInt("SeatScheduleID");
                int scheduleID = result.getInt("scheduleID"); int seatID = result.getInt("SeatID"); 
                String seatNumber = result.getString("SeatNumber"); String status = result.getString("Status");
                seat_schedule_list.add(new SeatSchedule(seatScheduleID, seatID, scheduleID, seatNumber, status ));
            }
        } catch (SQLException ex) {
            System.out.println("Exception while getting seat schedule from Seat");
//            Logger.getLogger(GuestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seat_schedule_list;
    }
    
    
    
    public FoodDrink getFoodDrinkByName(String name){
        String query = "SELECT * FROM FoodDrink WHERE Name = ?";
        FoodDrink food_drink = null;
        if (name.equals("Popcorn")){
            food_drink = new FoodDrink(1, "Popcorn", "Food", 50000, "Food");
        }else{
            food_drink = new FoodDrink(2, "Drink", "Drink", 40000, "Drink");
        }
        // Here is for future enhancement
//        PreparedStatement pstm;
//        try {
//            pstm = conn.prepareStatement(query);
//            pstm.setString(1, name);
//            
//            ResultSet result = pstm.executeQuery();
//            while (result.next()){
//                int food_drink_ID = result.getInt("FoodDrinkID");
//                String type = result.getString("Type");
//                long price = result.getLong("Price");
//                String description = result.getString("Description");
//                food_drink = new FoodDrink(food_drink_ID,name, type, price, description);
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error while getting food drink");
//            System.out.println(ex.getMessage());
////            Logger.getLogger(GuestController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        return food_drink;

    }
    
    public void setSeatAsReserved(SeatSchedule seat_schedule,Timestamp expiration_time){
        
        String query = "UPDATE SeatSchedule\n" +
                        "SET Status = ?, Expiration = ?\n" +
                        "WHERE SeatScheduleID = ?";
        PreparedStatement pstm;
        
        try {
            conn.setAutoCommit(false);
            pstm = conn.prepareStatement(query);
            pstm.setString(1, "reserved");
            pstm.setTimestamp(2, expiration_time);
            pstm.executeUpdate();
            
            conn.commit();
        } catch (SQLException ex) {
            System.out.println("Error while setting seat booked");
            System.out.println(ex.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex1) {
//                Logger.getLogger(GuestController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
//                Logger.getLogger(GuestController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
             
    }
    
    
    
   
    

    
    
   
    
 
}

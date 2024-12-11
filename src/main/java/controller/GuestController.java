/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.raven.datechooser.SelectedDate;
import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Movie;
import model.Schedule;
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
    
    public ArrayList<Schedule> getScheduleForMovie(Movie movie){
        
        String query = "select s.*, m.Title from Schedule as s " + "JOIN Movie as m ON s.MovieID = m.MovieID WHERE m.Title = ?";
                      
        ArrayList<Schedule> schedules_list = new ArrayList();
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(query);
            pstm.setString(1, movie.getTitle());
            ResultSet result = pstm.executeQuery();
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
               
            };
        } catch (SQLException ex) {
//            Logger.getLogger(GuestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return schedules_list;  
    }
    
    public ArrayList<Schedule> getShowTimeForMovieAndDate(Movie movie, SelectedDate selected_date){
        ArrayList<Schedule> schedules_list = new ArrayList();
        return schedules_list;
    }
}

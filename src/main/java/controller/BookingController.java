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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.OrderFoodDrink;
import model.SeatSchedule;
import model.Ticket;

/**
 *
 * @author mac
 */
public class BookingController {
    private static BookingController booking_controller;
    private static Connection conn = Database.getInstance();
    
    
    private BookingController(){
        
    }
    
    public synchronized static BookingController getInstance(){
        if (booking_controller == null){
            booking_controller = new BookingController();
        }
        return booking_controller;
    }
    
    public int insertTicketToDatabaseForCustomer(Ticket ticket){
        String query = "INSERT INTO Ticket(BookingDate, BookingStatus, TotalPrice, CustomerID, BookingType)\n"
                + "VALUES (?, ?, ?, ?, ?) ";
        int ticketID = 0;
        try {
            PreparedStatement pstm = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setTimestamp(1, ticket.getBooking_date());
            pstm.setString(2, ticket.getBooking_status());
            pstm.setLong(3, ticket.getTotal_price());
            pstm.setInt(4, ticket.getCustomer().getUser_id());
            pstm.setString(5, "Online");
            int result = pstm.executeUpdate();
            if (result == 0){
                System.out.println("No row is affected");
                return -1;
            }else{
                ResultSet generatedKeys = pstm.getGeneratedKeys();
                if (generatedKeys.next()){
                    ticketID = generatedKeys.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error while inserting ticket");
            System.out.println(ex.getMessage());
//            Logger.getLogger(GuestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ticketID;
    }
    
    
    public int insertTicketToDatabaseForStaff(Ticket ticket){
        String query = "INSERT INTO Ticket(BookingDate, BookingStatus, TotalPrice, CustomerID, BookingType)\n"
                + "VALUES (?, ?, ?, ?, ?) ";
        int ticketID = 0;
        try {  
            PreparedStatement pstm = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setTimestamp(1, ticket.getBooking_date());
            pstm.setString(2, ticket.getBooking_status());
            pstm.setLong(3, ticket.getTotal_price());
            pstm.setInt(4, ticket.getCustomer().getUser_id());
            pstm.setString(5, "Online");
            int result = pstm.executeUpdate();
            if (result == 0){
                System.out.println("No row is affected");
                return -1;
            }else{
                ResultSet generatedKeys = pstm.getGeneratedKeys();
                if (generatedKeys.next()){
                    ticketID = generatedKeys.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error while inserting ticket");
            System.out.println(ex.getMessage());
//            Logger.getLogger(GuestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ticketID;
    }
    public void setSeatAsReserved(SeatSchedule seat_schedule,Timestamp expiration_time){
        
        String query = "UPDATE SeatSchedule\n" +
                        "SET Status = ?, Expiration = ?\n" +
                        "WHERE SeatScheduleID = ?";
        PreparedStatement pstm;
        
        try {
            conn.setAutoCommit(false);
            pstm = conn.prepareStatement(query);
            pstm.setString(1, "Reserved");
            pstm.setTimestamp(2, expiration_time);
            pstm.setInt(3, seat_schedule.getSeatScheduleID());
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
    public void setSeatAsAvailable(SeatSchedule seat_schedule){
        String query = "UPDATE SeatSchedule\n" +
                        "SET Status = ?, Expiration = NULL\n" +
                        "WHERE SeatScheduleID = ?";
        PreparedStatement pstm;
        
        try {
            
            pstm = conn.prepareStatement(query);
            pstm.setString(1, "Available");
            pstm.setInt(2, seat_schedule.getSeatScheduleID());
            pstm.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println("Error while setting seat booked");
            System.out.println(ex.getMessage());
            
        }      
    }
    
    
    public boolean insertDataToTicketSeat(int ticketID, ArrayList<SeatSchedule> seat_schedules_list){
        String query = "INSERT INTO TicketSeat(TicketID, SeatScheduleID)\n"
                + "VALUES (?, ?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            for (SeatSchedule seat_schedule : seat_schedules_list){
                pstm.setInt(1, ticketID);
                pstm.setInt(2, seat_schedule.getSeatScheduleID());
                pstm.addBatch();
            }
            int [] inserted = pstm.executeBatch();
            if (inserted.length > 0){
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("Error occur while adding ticket seats");
            while (ex != null) {
                System.err.println("Error msg: " + ex.getMessage());
                ex = ex.getNextException();
            }
        }  
        return false;
    }
    
    public void setReservedSeatToBooked(ArrayList<SeatSchedule> seat_schedules_list){
        String query = "UPDATE SeatSchedule\n"
                + "SET Status = 'Booked', Expiration = NULL\n"
                + "WHERE SeatScheduleID IN (";
        for (int i = 0; i < seat_schedules_list.size(); i++){
            if (i < seat_schedules_list.size() - 1){
                query = query + seat_schedules_list.get(i).getSeatScheduleID() + ",";
            }else{
                query = query + seat_schedules_list.get(i).getSeatScheduleID() + ")";
            }
        }
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Error while setting booked seat");
            System.out.println(ex.getMessage());
        }
        
    }
    
    public boolean insertOrderFoodDrink(OrderFoodDrink order, int ticketID){
        String query = "INSERT INTO OrderFoodDrink(TicketID, FoodDrinkID, Quantity, TotalPrice)\n"
                + "VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, ticketID);
            pstm.setInt(2, order.getFood_drink().getFood_drink_ID());
            pstm.setInt(3, order.getQuantity());
            pstm.setLong(4, order.getQuantity() * order.getFood_drink().getPrice());
            
            int result = pstm.executeUpdate();
            if (result > 0){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error while adding food drink order");
            System.out.println(ex.getMessage());
        }  
        return false;
    }
    public boolean isSeatSelected(SeatSchedule seat_schedule){
        String query = "SELECT Status FROM SeatSchedule\n" +
                        "WHERE SeatScheduleID = ?";
        PreparedStatement pstm;
        ResultSet result = null;
        String status = "Available";
        try {
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, seat_schedule.getSeatScheduleID());
            result = pstm.executeQuery();
            if (result.next()){
                status = result.getString("Status");
            }
            
        } catch (SQLException ex) {
            System.out.println("Checking seat selected error");
            System.out.println(ex.getMessage());
        }
        if (status.equals("Reserved")){
            return true;
        }
        return false;
    }
   
}

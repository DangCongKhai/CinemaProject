/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.security.Timestamp;





/**
 *
 * @author mac
 */
public class Ticket {
    private int TicketID;
    private java.sql.Timestamp booking_date;
    private String booking_status;
    private long total_price;
    private Customer customer;
    private User staff;
    private String booking_type;

    public Ticket(int TicketID, java.sql.Timestamp booking_date, String booking_status, long total_price, User staff) {
        this.TicketID = TicketID;
        this.booking_date = booking_date;
        this.booking_status = booking_status;
        this.total_price = total_price;
       
        this.staff = staff;
    }

    public Ticket(int TicketID, java.sql.Timestamp  booking_date,Customer customer, String booking_status, long total_price) {
        this.TicketID = TicketID;
        this.booking_date = booking_date;
        this.booking_status = booking_status;
        this.total_price = total_price;
        this.customer = customer;
    }
    public Ticket(java.sql.Timestamp  booking_date,Customer customer, String booking_status, long total_price) {
      
        this.booking_date = booking_date;
        this.booking_status = booking_status;
        this.total_price = total_price;
        this.customer = customer;
    }
    public Ticket(java.sql.Timestamp  booking_date,User staff, String booking_status, long total_price) {
      
        this.booking_date = booking_date;
        this.booking_status = booking_status;
        this.total_price = total_price;
        this.staff = staff;
    }

    public int getTicketID() {
        return TicketID;
    }

    public java.sql.Timestamp getBooking_date() {
        return booking_date;
    }

    public String getBooking_status() {
        return booking_status;
    }

    public long getTotal_price() {
        return total_price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public User getStaff() {
        return staff;
    }

    public String getBooking_type() {
        return booking_type;
    }
    
    
    
}

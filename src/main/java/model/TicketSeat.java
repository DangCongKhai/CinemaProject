/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mac
 */
public class TicketSeat {
    private int ticket_seat_ID;
    private int ticketID;
    private SeatSchedule seat_schedule;

    public TicketSeat(int ticket_seat_ID, int ticketID, SeatSchedule seat_schedule) {
        this.ticket_seat_ID = ticket_seat_ID;
        this.ticketID = ticketID;
        this.seat_schedule = seat_schedule;
    }
    
    

    public int getTicket_seat_ID() {
        return ticket_seat_ID;
    }

    public int getTicketID() {
        return ticketID;
    }

    public SeatSchedule getSeat_schedule() {
        return seat_schedule;
    }
    
    
}

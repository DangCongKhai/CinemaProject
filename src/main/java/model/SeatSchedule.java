/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mac
 */
public class SeatSchedule {
    private int seatScheduleID;
    private int seatID;
    private int scheduleID;
    private String seat_name;
    private String status;
    public SeatSchedule(int seatScheduleID, int seatID, int scheduleID, String seat_name, String status) {
        this.seatScheduleID = seatScheduleID;
        this.seatID = seatID;
        this.scheduleID = scheduleID;
        this.seat_name = seat_name;
        this.status = status;
    }

    public int getSeatScheduleID() {
        return seatScheduleID;
    }
  
    public int getSeatID() {
        return seatID;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public String getSeat_name() {
        return seat_name;
    }

    public String getStatus() {
        return status;
    }
    
    
}

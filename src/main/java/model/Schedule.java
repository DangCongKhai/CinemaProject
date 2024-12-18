/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//import java.util.SelectedDate;

import datechooser.SelectedDate;


/**
 *
 * @author mac
 */
public class Schedule {
    private int scheduleID;
    private String title;
    private SelectedDate show_date;
    private String start_time;
    private String end_time;
    private long price;
    private int screen_number;

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public int getScreen_number() {
        return screen_number;
    }

    public Schedule(int scheduleID, String title, SelectedDate show_date, String start_time, String end_time, long price, int screen_number) {
        this.scheduleID = scheduleID;
        this.title = title;
        this.show_date = show_date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.price = price;
        this.screen_number = screen_number;
    }
    public Schedule(String title, SelectedDate show_date, String start_time, String end_time, long price, int screen_number) {
        
        this.title = title;
        this.show_date = show_date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.price = price;
        this.screen_number = screen_number;
    }

    @Override
    public String toString() {
        return String.format("Title: %s \n ShowDate: %s \n Show Time: %s-%s \n Price: %d \n Screen: %d", title, show_date.toString(), start_time, end_time, price, screen_number );
    }

    public String getTitle() {
        return title;
    }

    public SelectedDate getShow_date() {
        return show_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public long getPrice() {
        return price;
    }

    public int getscreen_number() {
        return screen_number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShow_date(SelectedDate show_date) {
        this.show_date = show_date;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setscreen_number(int screen_number) {
        this.screen_number = screen_number;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mac
 */
public class Screen {
    private int screenID;
    private int screen_number;
    private int screen_size;

    public Screen(int screenID, int screen_number, int screen_size) {
        this.screenID = screenID;
        this.screen_number = screen_number;
        this.screen_size = screen_size;
    }

    public int getScreenID() {
        return screenID;
    }

    public int getScreen_number() {
        return screen_number;
    }

    public int getScreen_size() {
        return screen_size;
    }

    public void setScreenID(int screenID) {
        this.screenID = screenID;
    }

    public void setScreen_number(int screen_number) {
        this.screen_number = screen_number;
    }

    public void setScreen_size(int screen_size) {
        this.screen_size = screen_size;
    }
    
}

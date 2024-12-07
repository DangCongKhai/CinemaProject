/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mac
 */
public class User {
    private int user_id;
    private String name;
    private String gender;
    private String role;

    public User(int user_id, String name, String gender, String role) {
        this.user_id = user_id;
        this.name = name;
        this.gender = gender;
        this.role = role;
    }
    public int getUser_id() {
        return user_id;
    }

    public String getRole() {
        return role;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
    
}

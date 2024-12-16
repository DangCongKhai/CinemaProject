/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mac
 */
public class Customer extends User{
    private String email;
    private String birth_date;
   

    public Customer(String email, String birth_date,int user_id, String name, String gender, String role) {
        super(user_id, name, gender, role);
        this.email = email;
        this.birth_date = birth_date;
  
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth_date() {
        return birth_date;
    }

  
    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    
    
}

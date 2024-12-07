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
    private String birth_date;
    private long balance;

    public Customer(String birth_date, long balance, int user_id, String name, String gender, String role) {
        super(user_id, name, gender, role);
        this.birth_date = birth_date;
        this.balance = balance;
    }

    

  

    public String getBirth_date() {
        return birth_date;
    }

    public long getBalance() {
        return balance;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
    
    
}

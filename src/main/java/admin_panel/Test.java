/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin_panel;

import java.time.LocalTime;
import model.Customer;
import model.User;

/**
 *
 * @author mac
 */
public class Test {
    public static void main(String[] args) {
       String time = "14:00";
       LocalTime t = LocalTime.parse("14:00");
//       LocalTime t = 
//       LocalTime t1 = LocalTime.
//        User a = new Customer(null, 0, "Khai", "Male");
//        System.out.println(a.getName());
        long a = 10000;
        String price = String.valueOf(a);
        price = price.substring(0, price.length() - 3) + "K";
        System.out.println(price);
        
       
    }
}

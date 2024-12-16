/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin_panel;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Map;
import java.util.Properties;
import model.Customer;
import model.EmailSender;
import model.User;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import static util.Util.getPassword;
import static util.Util.runMyScheduler;

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
//        long a = 10000;
//        String price = String.valueOf(a);
//        price = price.substring(0, price.length() - 3) + "K";
//        System.out.println(price);
       
//        System.out.println(a.charAt(0)[]);
//       Map<String, String> env  = System.getenv(); 
//        for (String name : env.keySet()) { 
//            System.out.format("%s = %s%n", name, env.get(name)); 
//        } 
///Users/mac/Desktop/Code/MovieManagementSystem/src/main/java/model/credentials.properties
//          System.out.println(getPassword());
        EmailSender email_sender = new EmailSender();
        email_sender.sendEmail();
    }
}

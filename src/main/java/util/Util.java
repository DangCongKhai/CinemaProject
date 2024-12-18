/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import database.Database;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.mindrot.jbcrypt.BCrypt;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
/**
 *
 * @author mac
 */
public class Util {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[\\w.+\\-]+@(gmail\\.com|\\w*.edu.vn)$", Pattern.CASE_INSENSITIVE);
    private static final String api_key = getAPIKey();
    private static final String API_URL = "https://api.hunter.io/v2/email-verifier?email=";
    private static Connection conn = Database.getInstance();
    public static int intInput(String text) throws NumberFormatException{
       try{
           return Integer.parseInt(text);
       }catch(NumberFormatException e){
           throw e;
       }
    }
    public static long longInput(String text) throws NumberFormatException{
       try{
           return Long.parseLong(text);
       }catch(NumberFormatException e){
           throw e;
       }
    }
    
    public static String hourMinuteToTime(int length){
        int minute = length%60;
        int hour = (length/60)%24;
        String hour_text = String.valueOf(hour);
        String minute_text = String.valueOf(minute);
        if (hour < 10){
            hour_text = "0" + hour_text;
        }
        if (minute < 10){
            minute_text = "0" + minute_text;
        }
        String time = hour_text + ":" + minute_text;
        return time;
    }
    
    public static String hashPassword(String password) {
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        return hash;
    }
    public static boolean verifyPassword(String password, String stored_hash){
        return BCrypt.checkpw(password, stored_hash);
    }
    public static boolean validEmail(String email){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.matches();
    }
    public static boolean isRealEmail(String email){
        try{
            
            URL url = new URL(API_URL + email + "&api_key=" + api_key );
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == 200){
               Scanner scanner = new Scanner(url.openStream());
                StringBuilder response = new StringBuilder();
                while (scanner.hasNext()) {
                    response.append(scanner.nextLine());
                }
                scanner.close();
                
                // Here, you'd parse the JSON response to check if the email is deliverable.
                // This example assumes you check the JSON response field as per the API's documentation.
                // For example, response might include a "result" field with values like "deliverable"
                return response.toString().contains("\"result\":\"deliverable\"");
                // How to work with JSON file in java
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public static String getPassword(){
        Properties properties = new Properties();
        String password = "";
        try (FileInputStream input = new FileInputStream("src/main/java/model/credentials.properties")) {
            properties.load(input);
            // Retrieve the password/key
            password = properties.getProperty("password");
            
        }   catch (FileNotFoundException ex) {
//            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
//            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return password;
    }
    public static String getAPIKey(){
        Properties properties = new Properties();
        String key = "";
        try (FileInputStream input = new FileInputStream("src/main/java/model/credentials.properties")) {
            properties.load(input);
            // Retrieve the password/key
            key = properties.getProperty("api_key");
            
        }   catch (FileNotFoundException ex) {
//            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
//            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }
    public static class SeatReservationCleanupJob implements Job {
    @Override
    public void execute(JobExecutionContext context) {
        // Check and release expired reservations from the database
        java.sql.Timestamp current_time= new java.sql.Timestamp(System.currentTimeMillis());
        String query = String.format("UPDATE seatSchedule SET Status = 'Available', Expiration = NULL " +
                        "WHERE Status = 'Reserved' AND Expiration < '%s'", current_time.toString());
        PreparedStatement statement;
        try {
            
            statement = conn.prepareStatement(query);
            int rowsUpdated = statement.executeUpdate();
            System.out.println(rowsUpdated + " expired reservations cleaned up.");
        } catch (SQLException ex) {
            System.out.println("Error while cleaning job");
            System.out.println(ex.getMessage());
        }
            
        // Add JDBC logic to check `expiration` in the database
    }

    public void runSchedule(){
        
        try{
        JobDetail job = JobBuilder.newJob(SeatReservationCleanupJob.class)
                .withIdentity("cleanupJob", "group1").build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("cleanupTrigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5) // Check every 60 seconds
                        .repeatForever())
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
        }
        
        catch (SchedulerException e) {
            System.out.println("Error here while cleaning");
            e.printStackTrace(); 
        }
        }
    }
    public static void runMyScheduler(){
        Thread schedulerThread = new Thread(()-> {
            new SeatReservationCleanupJob().runSchedule();
        });
//        schedulerThread.setDaemon(true);
        schedulerThread.start();
        
    }
}



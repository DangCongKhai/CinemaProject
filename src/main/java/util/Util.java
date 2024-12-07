/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author mac
 */
public class Util {
    
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
}

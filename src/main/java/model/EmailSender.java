/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.util.ArrayList;
import java.util.Properties;
import static util.Util.getPassword;


/**
 *
 * @author mac
 */
public class EmailSender {
    private final static String sender_email = "movie_cinema@demomailtrap.com";
    private final static String mail_trap_username = "api";
    private final static String mail_trap_password = getPassword();
    private Properties properties;
    private Session session ;
    private final static String subject = "Booking confirmation";
    public EmailSender(){
        
  
        properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "live.smtp.mailtrap.io");
        properties.put("mail.smtp.port", "587");
//        properties.put("mail.smtp.ssl.trust", "live.smtp.mailtrap.io");
        session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mail_trap_username, mail_trap_password);
            }
        });
    }
    
    public void sendEmail(Customer customer, Movie movie, Schedule schedule, ArrayList<SeatSchedule> seat_schedules_list){
        String content = message_confirmation(movie, schedule,seat_schedules_list,customer);
       
        try {
            // Create a MIME-style Email
            Message message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(sender_email));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("dangcongkhai2k5@gmail.com"));
            message.setSubject(subject);

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(content, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            // Send Email
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public void sendEmail(){
//        String content = message_confirmation(movie, schedule,seat_schedules_list,customer);
        String content = "\"\"\"\n" +
"        <html>\n" +
"        <body>\n" +
"            <h2 style=\"color: #2E86C1;\">Booking Confirmation - Cinema KKTN</h2>\n" +
"            <p>Dear <b>%s</b>,</p>\n" +
"            <p>Thank you for booking with us! Your ticket details are as follows:</p>\n" +
"            <table border=\"1\" style=\"border-collapse: collapse; width:50% ;\">\n" +
"                <tr style=\"background-color: #f2f2f2;\">\n" +
"                    <th>Movie</th>\n" +
"                    <td>%s</td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <th>Date</th>\n" +
"                    <td>%s</td>\n" +
"                </tr>\n" +
"                <tr style=\"background-color: #f2f2f2;\">\n" +
"                    <th>Time</th>\n" +
"                    <td>%s - %s</td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <th>Room</th>\n" +
"                    <td>%d</td>\n" +
"                </tr>                      \n" +
"                <tr>\n" +
"                    <th>Seats</th>\n" +
"                    <td>%s</td>\n" +
"                </tr>\n" +
"               \n" +
"            </table>\n" +
"            <p>Please arrive 15 minutes early. Enjoy your movie!</p>\n" +
"            <p style=\"color: #555;\">Best regards,</p>\n" +
"            <p><b>Cinema KKTN Customer Support</b></p>\n" +
"        </body>\n" +
"        </html>\n" +
"        \"\"\"";
        try {
            // Create a MIME-style Email
            Message message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(sender_email));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("dangcongkhai2k5@gmail.com"));
            message.setSubject(subject);

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(content, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            // Send Email
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public String message_confirmation(Movie movie, Schedule schedule, ArrayList<SeatSchedule> seat_schedules_list, Customer customer) {
    StringBuilder selected_seat_text = new StringBuilder();
    for (SeatSchedule ss : seat_schedules_list) {
        selected_seat_text.append(ss.getSeat_name().trim()).append(", ");
    }
    
    // Remove trailing comma and space if seats exist
    if (selected_seat_text.length() > 0) {
        selected_seat_text.setLength(selected_seat_text.length() - 2);
    }
    

  
    String message = String.format("""
        <html>
        <body>
            <h2 style="color: #2E86C1;">Booking Confirmation - Cinema KKTN</h2>
            <p>Dear <b>%s</b>,</p>
            <p>Thank you for booking with us! Your ticket details are as follows:</p> """, customer.getName()) +
            """ 
            <table border="1" style="border-collapse: collapse; width: 50%;">
            """ + String.format("""
                                                                                       
                <tr style="background-color: #f2f2f2;">
                    <th>Movie</th>
                    <td>%s</td>
                </tr>
                <tr>
                    <th>Date</th>
                    <td>%s</td>
                </tr>
                <tr style="background-color: #f2f2f2;">
                    <th>Time</th>
                    <td>%s - %s</td>
                </tr>
                <tr>
                    <th>Room</th>
                    <td>%d</td>
                </tr>                      
                <tr>
                    <th>Seats</th>
                    <td>%s</td>
                </tr>
               
            </table>
            <p>Please arrive 15 minutes early. Enjoy your movie!</p>
            <p style="color: #555;">Best regards,</p>
            <p><b>Cinema KKTN Customer Support</b></p>
        </body>
        </html>
        """,
        movie.getTitle(), 
        schedule.getShow_date().toString(), 
        schedule.getStart_time(), 
        schedule.getEnd_time(), 
        schedule.getScreen_number(), 
        selected_seat_text.toString()
    );

    return message;
}

}

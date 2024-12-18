package util;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class CustomerHistoryDataFetcher {
    public List<Object[]> searchTicketHistory(String username, String bookingDate, String bookingType, 
                                              String totalPrice, String movieTitle, String bookingStatus) {
        List<Object[]> history = new ArrayList<>();
        Connection conn = Database.getInstance();
        StringBuilder query = new StringBuilder(
            "SELECT t.BookingDate, t.BookingType, t.TotalPrice, m.Title AS MovieTitle, t.BookingStatus " +
            "FROM Ticket t " +
            "JOIN TicketSeat ts ON t.TicketID = ts.TicketID " +
            "JOIN SeatSchedule ss ON ts.ScheduleSeatID = ss.ScheduleSeatID " +
            "JOIN Schedule s ON ss.ScheduleID = s.ScheduleID " +
            "JOIN Movie m ON s.MovieID = m.MovieID " +
            "JOIN Customer c ON t.CustomerID = c.CustomerID " +
            "WHERE c.Name = '" + username + "'"
        );
        
        if (!bookingDate.trim().isEmpty()) {
            query.append(" AND t.BookingDate LIKE '%").append(bookingDate.trim()).append("%'");
        }
        if (!bookingType.trim().isEmpty()) {
            query.append(" AND t.BookingType LIKE '%").append(bookingType.trim()).append("%'");
        }
        if (!totalPrice.trim().isEmpty()) {
            query.append(" AND t.TotalPrice = ").append(totalPrice.trim());
        }
        if (!movieTitle.trim().isEmpty()) {
            query.append(" AND m.Title LIKE '%").append(movieTitle.trim()).append("%'");
        }
        if (!bookingStatus.trim().isEmpty()) {
            query.append(" AND t.BookingStatus LIKE '%").append(bookingStatus.trim()).append("%'");
        }
        
        try (PreparedStatement ps = conn.prepareStatement(query.toString());
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                history.add(new Object[]{
                    rs.getString("BookingDate"),
                    rs.getString("BookingType"),
                    rs.getDouble("TotalPrice"),
                    rs.getString("MovieTitle"),
                    rs.getString("BookingStatus")
                });
            }
        } catch (SQLException ex) {}        
        return history;
    }
    
    public List<Object[]> getAllTicketHistory(String username) {
        List<Object[]> history = new ArrayList<>();
        Connection conn = Database.getInstance();
        String query =  
            "SELECT t.BookingDate, t.BookingType, t.TotalPrice, m.Title AS MovieTitle, t.BookingStatus " +
            "FROM Ticket t " +
            "JOIN TicketSeat ts ON t.TicketID = ts.TicketID " +
            "JOIN SeatSchedule ss ON ts.ScheduleSeatID = ss.ScheduleSeatID " +
            "JOIN Schedule s ON ss.ScheduleID = s.ScheduleID " +
            "JOIN Movie m ON s.MovieID = m.MovieID " +
            "JOIN Customer c ON t.CustomerID = c.CustomerID " +
            "WHERE c.Name = '" + username + "'";
        
        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                history.add(new Object[] {
                    rs.getString("BookingDate"),
                    rs.getString("BookingType"),
                    rs.getDouble("TotalPrice"),
                    rs.getString("MovieTitle"),
                    rs.getString("BookingStatus")
                });
            }
        } catch (SQLException e) {}
        return history;
    }
}

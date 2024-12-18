package util;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminHistoryDataFetcher {

    public List<Object[]> getAllTicketHistory() {
        List<Object[]> history = new ArrayList<>();
        Connection conn = Database.getInstance();
        String query = 
            "SELECT t.TicketID, t.BookingDate, t.BookingStatus, t.TotalPrice, " +
            "m.Title AS MovieName, c.Name AS CustomerName, s.Name AS StaffName, t.BookingType " +
            "FROM [Ticket] t " +
            "LEFT JOIN [TicketSeat] ts ON t.TicketID = ts.TicketID " +
            "LEFT JOIN [SeatSchedule] ss ON ts.SeatScheduleID = ss.SeatScheduleID " +
            "LEFT JOIN [Schedule] sch ON ss.ScheduleID = sch.ScheduleID " +
            "LEFT JOIN [Movie] m ON sch.MovieID = m.MovieID " +
            "LEFT JOIN [User] c ON t.CustomerID = c.UserID " +
            "LEFT JOIN [User] s ON t.StaffID = s.UserID";
        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                history.add(new Object[]{
                    rs.getInt("TicketID"),
                    rs.getString("BookingDate"),
                    rs.getString("BookingStatus"),
                    rs.getDouble("TotalPrice"),
                    rs.getString("MovieName"),
                    rs.getString("CustomerName"),
                    rs.getString("StaffName"),
                    rs.getString("BookingType")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return history;
    }

    public List<Object[]> searchTicketHistory(String ticketID, String bookingDate, String bookingStatus, String totalPrice, 
                                              String movieTitle, String customerName, String staffName, String bookingType) {
        List<Object[]> history = new ArrayList<>();
        Connection conn = Database.getInstance();
        StringBuilder query = new StringBuilder(
            "SELECT t.TicketID, t.BookingDate, t.BookingStatus, t.TotalPrice, " +
            "m.Title AS MovieName, c.Name AS CustomerName, s.Name AS StaffName, t.BookingType " +
            "FROM [Ticket] t " +
            "LEFT JOIN [TicketSeat] ts ON t.TicketID = ts.TicketID " +
            "LEFT JOIN [SeatSchedule] ss ON ts.SeatScheduleID = ss.SeatScheduleID " +
            "LEFT JOIN [Schedule] sch ON ss.ScheduleID = sch.ScheduleID " +
            "LEFT JOIN [Movie] m ON sch.MovieID = m.MovieID " +
            "LEFT JOIN [User] c ON t.CustomerID = c.UserID " +
            "LEFT JOIN [User] s ON t.StaffID = s.UserID WHERE 1=1");

        if (!ticketID.trim().isEmpty()) {
            query.append(" AND t.TicketID = ").append(ticketID.trim());
        }
        if (!bookingDate.trim().isEmpty()) {
            query.append(" AND t.BookingDate LIKE '%").append(bookingDate.trim()).append("%'");
        }
        if (!bookingStatus.trim().isEmpty()) {
            query.append(" AND t.BookingStatus LIKE '%").append(bookingStatus.trim()).append("%'");
        }
        if (!totalPrice.trim().isEmpty()) {
            query.append(" AND t.TotalPrice = ").append(totalPrice.trim());
        }
        if (!movieTitle.trim().isEmpty()) {
            query.append(" AND m.Title LIKE '%").append(movieTitle.trim()).append("%'");
        }
        if (!customerName.trim().isEmpty()) {
            query.append(" AND c.Name LIKE '%").append(customerName.trim()).append("%'");
        }
        if (!staffName.trim().isEmpty()) {
            query.append(" AND s.Name LIKE '%").append(staffName.trim()).append("%'");
        }
        if (!bookingType.trim().isEmpty()) {
            query.append(" AND t.BookingType LIKE '%").append(bookingType.trim()).append("%'");
        }

        try (PreparedStatement ps = conn.prepareStatement(query.toString());
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                history.add(new Object[]{
                    rs.getInt("TicketID"),
                    rs.getString("BookingDate"),
                    rs.getString("BookingStatus"),
                    rs.getDouble("TotalPrice"),
                    rs.getString("MovieName"),
                    rs.getString("CustomerName"),
                    rs.getString("StaffName"),
                    rs.getString("BookingType")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return history;
    }
}

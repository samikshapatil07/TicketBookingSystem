package service;

import java.sql.*;
import java.util.*;
import bean.*;
import bean.Sports;
import util.DBConnUtil;

public class BookingSystemRepositoryImpl implements IBookingSystemRepository {

    @Override
    public Event create_event(String name, String date, String time, int seats, float price, String type, Venue venue) {
        try (Connection conn = DBConnUtil.getConnection()) {
            String insertVenue = "INSERT INTO Venu (venue_name, address) VALUES (?, ?)";
            PreparedStatement psVenue = conn.prepareStatement(insertVenue, Statement.RETURN_GENERATED_KEYS);
            psVenue.setString(1, venue.getVenueName());
            psVenue.setString(2, venue.getAddress());
            psVenue.executeUpdate();

            ResultSet rsVenue = psVenue.getGeneratedKeys();
            int venueId = -1;
            if (rsVenue.next()) {
                venueId = rsVenue.getInt(1);
            }

            String insertEvent = "INSERT INTO Event (event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, event_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement psEvent = conn.prepareStatement(insertEvent);
            psEvent.setString(1, name);
            psEvent.setString(2, date);
            psEvent.setString(3, time);
            psEvent.setInt(4, venueId);
            psEvent.setInt(5, seats);
            psEvent.setInt(6, seats); // available_seats = total_seats
            psEvent.setFloat(7, price);
            psEvent.setString(8, type);
            psEvent.executeUpdate();

            // Return corresponding Event object (Movie, Concert, Sport)
            switch (type.toLowerCase()) {
                case "movie": return new Movie(name, date, time, venue, seats, seats, price, type);
                case "concert": return new Concert(name, date, time, venue, seats, seats, price, type);
                case "sports": return new Sports(name, date, time, venue, seats, seats, price, type);
                default: return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // We will add other methods like getEventDetails(), book_tickets() etc. next
}

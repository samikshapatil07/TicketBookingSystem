package daoImpl;

import dao.EventDAO;
import model.Event;
import util.DBConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EventDAOImpl implements EventDAO {

    @Override
    public void saveEvent(Event event) {
        try (Connection conn = DBConnUtil.getConnection()) {
            String query = "INSERT INTO event (event_name, event_date, event_time, venue_id, total_seats, available_seats, ticket_price, event_type, booking_id) "
                         + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, event.getEventName());
            ps.setDate(2, event.getEventDate());
            ps.setTime(3, event.getEventTime());
            ps.setInt(4, event.getVenueId());
            ps.setInt(5, event.getTotalSeats());
            ps.setInt(6, event.getAvailableSeats());
            ps.setDouble(7, event.getTicketPrice());
            ps.setString(8, event.getEventType());
            ps.setInt(9, event.getBookingId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Event saved successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while saving event: " + e.getMessage());
        }
    }
}

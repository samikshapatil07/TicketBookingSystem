package app;

import dao.EventDAO;
import daoImpl.EventDAOImpl;
import model.Event;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Event Name:");
        String name = sc.nextLine();

        System.out.println("Enter Event Date (yyyy-mm-dd):");
        String dateStr = sc.nextLine();
        Date date = Date.valueOf(dateStr);

        System.out.println("Enter Event Time (hh:mm:ss):");
        String timeStr = sc.nextLine();
        Time time = Time.valueOf(timeStr);

        System.out.println("Enter Venue ID:");
        int venueId = sc.nextInt();

        System.out.println("Enter Total Seats:");
        int totalSeats = sc.nextInt();

        System.out.println("Enter Available Seats:");
        int availableSeats = sc.nextInt();

        System.out.println("Enter Ticket Price:");
        double price = sc.nextDouble();

        sc.nextLine(); 
        System.out.println("Enter Event Type (Movie/Sports/Concert):");
        String type = sc.nextLine();

        System.out.println("Enter Booking ID:");
        int bookingId = sc.nextInt();

        Event event = new Event(name, date, time, venueId, totalSeats, availableSeats, price, type, bookingId);
        EventDAO dao = new EventDAOImpl();
        dao.saveEvent(event);
    }
}

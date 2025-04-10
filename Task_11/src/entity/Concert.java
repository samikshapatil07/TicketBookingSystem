package bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event{
	private String artist;
    private String type;
    
    public Concert() {
		super();
	}

	public Concert(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName,
                   int totalSeats, double ticketPrice, String artist, String type) {
        super(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice, "Concert");
        this.artist = artist;
        this.type = type;
    }

    public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
    public void display_event_details() {
        super.display_event_details();
        System.out.println("Artist: " + artist);
        System.out.println("Type: " + type);
        System.out.println("----------------------------");
    }
}

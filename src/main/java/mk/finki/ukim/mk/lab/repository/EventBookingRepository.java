package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.stereotype.Repository;

@Repository
public class EventBookingRepository {
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        EventBooking eventBooking = new EventBooking(eventName,
                attendeeName,
                attendeeAddress,
                (long) numberOfTickets);
        DataHolder.eventBookings.add(eventBooking);
        return eventBooking;
    }
}

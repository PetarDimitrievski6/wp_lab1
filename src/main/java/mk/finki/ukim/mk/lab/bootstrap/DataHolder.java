package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events = new ArrayList<>();
    public static List<EventBooking> eventBookings = new ArrayList<>();
    @PostConstruct
    public void init(){
        events.add(new Event("New York event", "New York Description", 10));
        events.add(new Event("Tokyo event", "Tokyo Description", 9.5));
        events.add(new Event("Paris event", "Paris Description", 7.7));
        events.add(new Event("London event", "London Description", 8));
        events.add(new Event("Singapore event", "Singapore Description", 9.6));
        events.add(new Event("Dubai event", "Dubai Description", 9.8));
        events.add(new Event("Hong Kong event", "Hong Kong Description", 8.9));
        events.add(new Event("Los Angeles event", "Los Angeles Description", 7.8));
        events.add(new Event("Shanghai event", "Shanghai Description", 8.4));
        events.add(new Event("Barcelona event", "Barcelona Description", 8.7));

    }
}

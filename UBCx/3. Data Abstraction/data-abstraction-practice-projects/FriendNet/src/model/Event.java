package model;

public class Event {

    private final String name;
    private final String date;
    private final String location;
    private final EventType type;

    public Event(String name, String date, String location, EventType type) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.type = type;
    }

    // getters
    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    public String getLocation() {
        return location;
    }
    public EventType getEventType() {
        return type;
    }

}

package model;

import other.CalendarDate;
import other.CalendarTime;

public class Event extends Reminder {

    public Event(CalendarDate date, CalendarTime time, String label) {
        super(date, time, label);
    }

}

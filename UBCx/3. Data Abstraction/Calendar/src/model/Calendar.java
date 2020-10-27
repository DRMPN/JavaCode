package model;

import other.CalendarDate;

import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private CalendarDate currentDate;
    private String calendarEmail;
    private List<CalendarItem> calendarEntries;

    public Calendar(CalendarDate currentDate, String email) {
        this.currentDate = currentDate;
        this.calendarEmail = email;
        this.calendarEntries = new ArrayList<>();
    }

    //Getters:
    public String getCurrentDate() {
        return currentDate.getLongDate();
    }
    public String getCalendarEmail() {
        return calendarEmail;
    }
    public List<CalendarItem> getCalendarEntries() {
        return calendarEntries;
    }

    //Modifies: this
    //Effects: adds or removes entry in calendar
    public void addCalendarEntry(CalendarItem entry) { this.calendarEntries.add(entry); }
    public void removeCalendarEntry(CalendarItem entry) { this.calendarEntries.remove(entry); }

    //Requires: non-empty list, sorted list
    public String getSoonestEntry() {
        CalendarItem first = calendarEntries.get(0);
        return "The soonest entry is: "+first.getLabel()+" -- "+first.getDate().getShortDate();
    }


}

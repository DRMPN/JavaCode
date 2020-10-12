package model;

import other.CalendarDate;
import other.CalendarTime;

public abstract class CalendarItem {

   private final CalendarDate date;
   private final CalendarTime time;
   private final String label;

   private boolean onRepeat;
   private int dayInterval;
   private int hourInterval;
   private int minuteInterval;

    public CalendarItem(CalendarDate date, CalendarTime time, String label) {
        this.date = date;
        this.time = time;
        this.label = label;
    }

    //Getters:
    public CalendarDate getDate() {
        return date;
    }
    public CalendarTime getTime() {
        return time;
    }
    public String getLabel() {
        return label;
    }
    public boolean isOnRepeat() {
        return onRepeat;
    }

    //Modifies: this
    //Requires: d,h,m >= 0
    public void setInterval(int day, int hour, int minute) {
        onRepeat = true;
        this.dayInterval = day;
        this.hourInterval = hour;
        this.minuteInterval = minute;
    }

    //Effects: returns interval in specific format
    public String getInterval() {
        if (isOnRepeat()) return this.getSpecificInterval();
        else return "is not on repeat";
    }

    private String getSpecificInterval() {
        return "is on repeat every: "+dayInterval+" day(s), "+hourInterval+" hour(s), "+minuteInterval+" minute(s)";
    }
}

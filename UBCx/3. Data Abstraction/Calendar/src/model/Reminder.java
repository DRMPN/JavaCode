package model;

import other.CalendarDate;
import other.CalendarTime;

public class Reminder extends CalendarItem {

   private CalendarDate remindOnDate;
   private CalendarTime remindOnTime;
   private String Note;

    public Reminder(CalendarDate date, CalendarTime time, String label) {
        super(date, time, label);
    }

    //Setters:
    public void setRemindOnDate(CalendarDate CD) {
        remindOnDate = CD;
    }
    public void setRemindOnTime(CalendarTime CT) {
        remindOnTime = CT;
    }
    public void addNote(String note) { this.Note = note; }

    //Getters:
    public CalendarDate getRemindOnDate() { return remindOnDate; }
    public CalendarTime getRemindOnTime() { return remindOnTime; }
    public String getNote() { return Note; }
}

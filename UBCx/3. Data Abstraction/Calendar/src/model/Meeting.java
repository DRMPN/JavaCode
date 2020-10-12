package model;

import other.CalendarDate;
import other.CalendarTime;

import java.util.HashSet;

public class Meeting extends Reminder {

    private final HashSet<String> listOfAttendees;

    public Meeting(CalendarDate date, CalendarTime time, String label) {
        super(date, time, label);
        listOfAttendees = new HashSet<>();
    }

    //Getters:
    public HashSet<String> getListOfAttendees() {
        return listOfAttendees;
    }

    public void addAttendee(String email) { listOfAttendees.add(email); }
    public void removeAttendee(String email) { listOfAttendees.remove(email); }

    public void sendInvitations() {
        for (String email : listOfAttendees) {
            System.out.println("Inviting: "+email);
        }
    }

}

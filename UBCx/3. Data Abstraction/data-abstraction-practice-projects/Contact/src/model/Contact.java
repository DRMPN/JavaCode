package model;

import java.util.LinkedList;
import java.util.List;

public class Contact {

    private final String name;
    private int number;
    private ContactType type;
    private final List<String> callLog;

    public Contact(String name) {
        this.name = name;
        this.callLog = new LinkedList<>();
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getNumber() {
        return number;
    }
    public ContactType getType() {
        return type;
    }
    public List<String> getCallLog() {
        return callLog;
    }

    // Setters
    public void setNumber(int number) {
        this.number = number;
    }
    public void setNumber(String number) {
        this.number = Integer.parseInt(number);
    }
    public void setType(ContactType type) {
        this.type = type;
    }

    // MODIFIES: this
    // EFFECTS: adds call date to the log
    public void call(String date) {
        this.callLog.add(date);
    }

    // EFFECTS: prints call history
    public void printCallLog() {
        for (String date : callLog) {
            System.out.println(date);
        }
    }

    // contactType -> string
    public String automateResponse() {
        switch (this.getType()) {
            case WORK: return "I'll get back to you at work.";
            case FRIEND: return "Meet you at the cafe.";
            case FAMILY: return "See you at home.";
        }
        return "Internal error";
    }


}




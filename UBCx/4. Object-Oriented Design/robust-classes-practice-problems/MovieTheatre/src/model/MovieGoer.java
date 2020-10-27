package model;

import model.exceptions.ShowingFullException;
import model.exceptions.UnderAgeException;

public class MovieGoer {

    private String name;
    private int age;
    private Ticket ticket;
    private TicketKiosk tk;

    public MovieGoer(String name, int age,  TicketKiosk tk) {
        this.name = name;
        this.age = age;
        this.tk = tk;
        ticket = null;
    }

    // getters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public Ticket getTicket() {
        return ticket;
    }
    public TicketKiosk getTicketKiosk() {
        return tk;
    }

    // MODIFIES: this, movie
    // EFFECTS:  a new ticket associated with the given movie is created, and
    //           becomes this MovieGoer's ticket
    public void buyTicket(Movie m) throws ShowingFullException, UnderAgeException {
        if (m.isFull()) {throw new ShowingFullException("No more seats!");}
        else if (this.age < m.getAgeRestriction()) {throw new UnderAgeException("Too young to watch!");}
        m.addViewer();
        this.ticket = new Ticket(m);
    }

}

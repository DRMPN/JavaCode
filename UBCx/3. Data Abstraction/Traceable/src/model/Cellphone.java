package model;

import java.util.ArrayList;
import java.util.Collection;

public class Cellphone implements Traceable {

    private final int phoneNumber;
    private final Person associatedPerson;
    private String location;
    private Collection<Call> recentCalls;

    public Cellphone(Person person, int phoneNumber){
        this.associatedPerson = person;
        this.phoneNumber = phoneNumber;

        person.takeCellPhone(this);

        recentCalls = new ArrayList<>();
    }

    //Getters:
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public Collection<Call> getRecentCalls() {
        return recentCalls;
    }

    @Override
    public String getLocation() {
        return "The cell phone is at: "+ location;
    }

    @Override
    public Object getTrace() {
        return associatedPerson;
    }

    @Override
    public void track() {
        System.out.println("Tracking "+associatedPerson.getName()+" by cellphone location.");
    }

}

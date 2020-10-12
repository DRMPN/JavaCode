package model;

public interface Traceable {

    //Effects: returns the location of the cellphone or where fingerprint were collected
    String getLocation();

    //Effects: returns the object of interest
    Object getTrace();

    //Effects: tracks the current object
    void track();

}

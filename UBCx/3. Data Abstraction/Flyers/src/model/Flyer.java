package model;

public interface Flyer {

    //REQUIRES: being on land
    //MODIFIES: this
    //EFFECTS:  moves this into the air
    void takeoff();

    //REQUIRES: being in air
    //MODIFIES: this
    //EFFECTS:  moves this horizontally in the air
    void fly();

    //REQUIRES: being in the air
    //MODIFIES: this
    //EFFECTS:  moves this onto land
    void land();
}

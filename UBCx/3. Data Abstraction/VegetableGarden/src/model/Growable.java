package model;

public interface Growable {

    //Effects: feeds a plant with appropriate fertilizers
    void feed();

    //Effects: waters a plant with right amount of water
    void water();

    //Effects: returns appropriate instruction for a plant care
    String getInstructions();

    //Effects: harvests vegetables from a plant
    void harvest();

}

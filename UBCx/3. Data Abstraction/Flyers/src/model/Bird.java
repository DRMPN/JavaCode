package model;

public class Bird implements Flyer{

    @Override
    public void takeoff() {
        System.out.println("Tap tap tap . . . *jump*");
    }

    @Override
    public void fly() {
        System.out.println("Flap flap flap");
    }

    @Override
    public void land() {
        System.out.println("Tap tap hop");
    }
}

package model;

import java.util.Observable;

public class Auctioneer extends Observable {

    private String name;
    private double currentBid;

    public Auctioneer(String name) {
        this.name = name;
        this.currentBid = 1.0;
    }

    // Getters:
    public String getName() {
        return name;
    }
    public double getCurrentBid() {
        return currentBid;
    }

    // Setters:
    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    public void acceptBid(double newBid) {
        if (newBid > currentBid) {
            this.currentBid = newBid;
            setChanged();
            notifyObservers(newBid);
        }
        else {
            System.out.println("That bid isn't larger than the current bid!");
        }
    }

}

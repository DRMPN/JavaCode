package model;

import java.util.LinkedList;
import java.util.List;

public class Band {

    private final String name;
    private double totalMoney;
    private double currentMoney;
    private final List<String> members;
    private int numShowsPlayed;

    public Band(String name) {
        this.name = name;
        this.totalMoney = 0.0;
        this.currentMoney = 0.0;
        this.members = new LinkedList<>();
        this.numShowsPlayed = 0;
    }

    // getters
    public String getName() {
        return name;
    }
    public double getTotalMoney() {
        return totalMoney;
    }
    public double getCurrentMoney() {
        return currentMoney;
    }
    public List<String> getMembers() {
        return members;
    }
    public int getNumShowsPlayed() {
        return numShowsPlayed;
    }

    // MODIFIES: this
    // EFFECTS: adds a member with the given name to the band
    public void addMember(String name) {
        this.members.add(name);
    }

    // MODIFIES: this
    // EFFECTS: given an amount the band will be played for the show, update
    //          the current money and total money by the amount, and add one to
    //          the number of shows played.
    public void playGig(double amt) {
        this.totalMoney+=amt;
        this.currentMoney+=amt;
        this.numShowsPlayed+=1;
    }

    // MODIFIES: this
    // EFFECTS: pays the given amount to each band member, the total paid
    //          is subtracted from the current money. If there is not enough
    //          money, nothing happens
    public void payMembers(double amt) {
        double amountToPay = this.getMembers().size() * amt;
        if (this.getCurrentMoney() > amountToPay) {
            this.currentMoney-=amountToPay;
        }
    }

    // REQUIRES: numShowsPlayed > 0
    // MODIFIES: nothing
    // EFFECTS: computes the average amount the band is payed per show
    public double averagePerShow() {
        return this.currentMoney / this.numShowsPlayed;
    }


}

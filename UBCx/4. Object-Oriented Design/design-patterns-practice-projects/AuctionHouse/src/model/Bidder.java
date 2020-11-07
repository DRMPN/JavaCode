package model;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ThreadLocalRandom;

public class Bidder implements Observer {

   private String name;
   private double personalBid;
   private double currentBid;
   private double maxBid;

   public Bidder(String name, double maxBid) {
       this.name = name;
       this.personalBid = 0.0;
       this.maxBid = maxBid;
   }

   // Getters:
    public String getName() {
        return name;
    }
    public double getPersonalBid() {
        return personalBid;
    }
    public double getCurrentBid() {
        return currentBid;
    }
    public double getMaxBid() {
        return maxBid;
    }

    @Override
    public void update(Observable observable, Object o) {

        currentBid = (double) o;
        System.out.println();
        System.out.println("Bidder "+name+" has been updated with the most recent high bid.");

        if (currentBid >= maxBid) {
            System.out.println(name+" : I can't bid any higher!");
        }
        else {
            makeBid(currentBid);
        }
    }

    public void makeBid(double currentBid) {
       System.out.println(name + ": I'm bidding!");
       double min = currentBid+1;
       double max = currentBid+10;
       this.personalBid = ThreadLocalRandom.current().nextDouble(min, max);
    }

}

package model;

public class Horse extends Animal {

    private String country;
    private double topSpeed;

    public Horse(String nm, String ct, int age, Zookeeper zk, double wgt, double ts) {
        super(nm, age, zk, wgt);
        country = ct;
        topSpeed = ts;
    }

    // getters
    public String getCountry() { return country; }
    public double getTopSpeed() { return topSpeed; }

}
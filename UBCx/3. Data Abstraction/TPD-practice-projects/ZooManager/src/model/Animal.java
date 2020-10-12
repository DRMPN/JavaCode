package model;

public class Animal {

    protected String name;
    protected int age;
    protected Zookeeper careTaker;
    protected double weight;

    public Animal(String nm, int age, Zookeeper zk, double wgt) {
        name = nm;
        this.age = age;
        careTaker = zk;
        weight = wgt;
    }

    // getters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public Zookeeper getCareTaker() {
        return careTaker;
    }
    public double getWeight() {
        return weight;
    }
}

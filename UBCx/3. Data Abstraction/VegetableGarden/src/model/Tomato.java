package model;

public class Tomato extends Vegetable{

    public Tomato() {
        super("Tomato", VegType.SEED);
    }

    @Override
    public void feed() {
        System.out.println("Fertilizing tomato...");
    }

    @Override
    public void water() {
        System.out.println("Watering tomato...");
    }

    @Override
    public void harvest() {
        System.out.println("Harvesting tomato...");
    }
}

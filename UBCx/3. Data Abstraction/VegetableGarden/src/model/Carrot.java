package model;

public class Carrot extends Vegetable {

    public Carrot() {
        super("Carrot",VegType.ROOT);
    }

    @Override
    public void feed() {
        System.out.println("Fertilizing carrot...");
    }

    @Override
    public void water() {
        System.out.println("Watering carrot...");
    }

    @Override
    public void harvest() {
        System.out.println("Harvesting carrot...");
    }
}

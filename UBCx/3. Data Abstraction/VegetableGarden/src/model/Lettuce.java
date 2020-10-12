package model;

public class Lettuce extends Vegetable{

    public Lettuce() {
        super("Lettuce",VegType.LEAF);
    }

    @Override
    public void feed() {
        System.out.println("Fertilizing lettuce...");
    }

    @Override
    public void water() {
        System.out.println("Watering lettuce...");
    }

    @Override
    public void harvest() {
        System.out.println("Harvesting lettuce...");
    }
}

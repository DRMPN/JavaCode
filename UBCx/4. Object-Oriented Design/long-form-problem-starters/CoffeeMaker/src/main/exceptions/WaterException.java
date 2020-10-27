package main.exceptions;

public class WaterException extends Exception {

    private double placedCupes;

    public WaterException() {
        super("Not enough water supplied to the machine");
    }

}

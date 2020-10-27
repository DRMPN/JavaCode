package main.exceptions;

public class StaleCoffeeException extends Exception {

    private int timeScinceLastBrew;

    public StaleCoffeeException() {
        super("Coffee has been sitting for too long and now is stale");
    }

}

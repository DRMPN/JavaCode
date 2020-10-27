package model;

import main.exceptions.*;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {

    private final String name;
    private final int age;

    private int TimeSinceLastBrew;
    private int CupsRemaining;

    public CoffeeMaker(String name, int age){
        this.name = name;
        this.age = age;
        this.TimeSinceLastBrew = 9999;
        this.CupsRemaining = 0;
    }

    // getters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getTimeSinceLastBrew() {
        return TimeSinceLastBrew;
    }
    public int getCupsRemaining() {
        return CupsRemaining;
    }
    // EFFECTS: return true if there are coffee cups remaining
    public boolean areCupsRemaining() {
        return CupsRemaining >0;
    }

    //REQUIRES: a non-negative integer
    //EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew(int time) {
        TimeSinceLastBrew = time;
    }

    //REQUIRES: beans between 2.40 and 2.60 cups, water > 14.75 cups
    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0
    public void brew(double beans, double water) throws BeansAmountException, WaterException {
        if (beans<2.40) {throw new NotEnoughBeansException(beans);}
        if (beans>2.60) {throw new TooManyBeansException(beans);}
        if (water<=14.75) {throw new WaterException();}
        CupsRemaining = 20;
        TimeSinceLastBrew = 0;
    }

    ///REQUIRES: cups remaining > 0, time since last brew < 60
    //MODIFIES: this
    //EFFECTS: subtracts one cup from cups remaining
    public void pourCoffee() throws NoCupsRemainingException, StaleCoffeeException {
        if (!areCupsRemaining()) {throw new NoCupsRemainingException();}
        if (TimeSinceLastBrew > 60) {throw new StaleCoffeeException();}
        CupsRemaining --;
    }


}

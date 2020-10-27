package model;

import exceptions.AllergyException;
import exceptions.NotHungry;

public class Animal {

    private boolean isHungry = false;
    private boolean isAllergic = true;
    private int eaten = 0;

    // getters
    public boolean isHungry() { return isHungry; }
    public boolean isAllergic() {
        return isAllergic;
    }

    public int eat() throws NotHungry, AllergyException {
        if (!isHungry()) {throw new NotHungry();}
        if (isAllergic()) {throw new AllergyException();}

        isHungry = false;
        System.out.println("Animal is eating!");
        eaten++;
        return eaten;
    }


}
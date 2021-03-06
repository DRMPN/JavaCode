package model;

import exceptions.AllergyException;
import exceptions.BrokeException;
import exceptions.DidntEat;
import exceptions.NotHungry;

import java.util.List;

public class Manager {

    private final List<Animal> animalsToManage;
    private final Keeper keeper;

    public Manager(List<Animal> animals, Keeper keeper) {
        this.animalsToManage = animals;
        this.keeper = keeper;
    }

    public void manage() throws BrokeException {
        try {
            keeper.feed();
        } catch (DidntEat didntEat) {
            System.out.println("Didn't eat. Call the doctor!");
            throw new BrokeException();
        } finally {
            System.out.println("Manager says: Regardless of what happens");
        }
    }


}
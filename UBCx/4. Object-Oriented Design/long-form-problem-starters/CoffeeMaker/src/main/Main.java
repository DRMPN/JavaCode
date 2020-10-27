package main;

import main.exceptions.BeansAmountException;
import main.exceptions.NoCupsRemainingException;
import main.exceptions.StaleCoffeeException;
import main.exceptions.WaterException;
import model.CoffeeMaker;

public class Main {

    public static void main(String[] args){

        CoffeeMaker FirstBarista = new CoffeeMaker("John",21);

        System.out.println("Brewing fresh coffee");
        try {
            FirstBarista.brew(2.50,16);
        } catch (BeansAmountException e) {
            System.out.println("Forgot to pour beans!");
        } catch (WaterException e) {
            System.out.println("Forgot to pour water!");
        }

        System.out.println("Pouring your favorite coffee");
        try {
            FirstBarista.pourCoffee();
        } catch (NoCupsRemainingException e) {
            System.out.println("Oops! There's no cups left");
        } catch (StaleCoffeeException e) {
            System.out.println("Oh no, I have to brew coffee again");
        }


    }


}
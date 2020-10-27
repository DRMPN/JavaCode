package test;

import main.exceptions.BeansAmountException;
import main.exceptions.NoCupsRemainingException;
import main.exceptions.StaleCoffeeException;
import main.exceptions.WaterException;
import model.CoffeeMaker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeMakerTest {

    private CoffeeMaker testBarista;

    @Before
    public void setUp(){
        testBarista = new CoffeeMaker("Alex",13);
    }

    @Test
    public void testInitialize() {
        assertEquals(testBarista.getName(),"Alex");
        assertEquals(testBarista.getAge(),13);
        testBarista.setTimeSinceLastBrew(0);
        assertEquals(testBarista.getTimeSinceLastBrew(),0);
        assertEquals(testBarista.getCupsRemaining(),0);
    }


    // *** brew tests ***

    @Test
    public void testBrew() throws BeansAmountException, WaterException {
        testBarista.brew(2.50,16);
        assertEquals(testBarista.getCupsRemaining(),20);
        assertEquals(testBarista.getTimeSinceLastBrew(),0);
    }

    @Test
    public void testTooManyBeans() {
        try {
            testBarista.brew(0,100);
        } catch (WaterException e) {
            fail("testTooManyBeans doesn't work");
        } catch (BeansAmountException e) {
            System.out.println("testTooManyBeans has passed");
        }
        assertEquals(testBarista.getCupsRemaining(),0);
        assertEquals(testBarista.getTimeSinceLastBrew(),9999);
    }

    @Test
    public void testNotMuchBeans() {
        try {
            testBarista.brew(100,100);
        } catch (WaterException e) {
            fail("testNotMuchBeans doesn't work");
        } catch (BeansAmountException e) {
            System.out.println("testNotMuchBeans has passed");
        }
    }

    @Test
    public void testWaterException() {
        try {
            testBarista.brew(2.50,0);
        } catch (WaterException e) {
            System.out.println("testWaterException has passed");
        } catch (BeansAmountException e) {
            System.out.println("testWaterException doesn't work");
        }
    }

    // *** pourCoffee tests ***
    @Test
    public void testPourCoffee() throws NoCupsRemainingException, StaleCoffeeException, BeansAmountException, WaterException {
        testBarista.brew(2.50,16);
        testBarista.pourCoffee();
        assertEquals(testBarista.getCupsRemaining(),19);
    }

    @Test
    public void testCupsRemaining() {
        try {
            testBarista.pourCoffee();
        } catch (NoCupsRemainingException e) {
            System.out.println("testCupsRemaining has passed");
        } catch (StaleCoffeeException e) {
            fail("testCupsRemaining doesn't work");
        }
    }

    @Test
    public void testStaleCoffee() throws BeansAmountException, WaterException {
        testBarista.brew(2.50,16);
        testBarista.setTimeSinceLastBrew(90);
        try {
            testBarista.pourCoffee();
        } catch (NoCupsRemainingException e) {
            fail("testStaleCoffee doesn't work");
        } catch (StaleCoffeeException e) {
            System.out.println("testStaleCoffee has passed");
        }
    }

}

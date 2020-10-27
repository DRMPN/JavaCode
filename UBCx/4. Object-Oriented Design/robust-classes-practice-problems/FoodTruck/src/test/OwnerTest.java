package test;

import model.Kitchen;
import model.Owner;
import model.exceptions.NoCookException;
import model.exceptions.NoIngredientException;
import model.exceptions.NotEnoughMoneyException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OwnerTest {

    private Kitchen testKitchen;
    private Owner testOwner;

    @Before
    public void setUp() {
        testKitchen = new Kitchen(30, 4, 100, true);
        testOwner = new Owner("Paul Lockwood", testKitchen);
    }

    @Test
    public void testGetters() {
        assertEquals(testOwner.getName(), "Paul Lockwood");
        assertEquals(testOwner.getKitchen(), testKitchen);
    }

    @Test
    public void testOrderMoreTacos() {
        assertEquals(testOwner.getKitchen().getIngredientCount(),30);
        assertEquals(testOwner.getKitchen().getTacoCount(),4);


        try {
            assertTrue(testOwner.orderMoreTacos(10));
        } catch (NoCookException e) {
            fail();
        } catch (NotEnoughMoneyException e) {
            fail();
        }

        assertEquals(testOwner.getKitchen().getTacoCount(),14);
        assertEquals(testOwner.getKitchen().getIngredientCount(),0);

        try {
            assertFalse(testOwner.orderMoreTacos(1));
        } catch (NoCookException e) {
            fail();
        } catch (NotEnoughMoneyException e) {}
    }

    @Test
    public void testaskForMoreIngredients() {
        assertEquals(testOwner.getKitchen().getIngredientCount(), 30);
        assertEquals(testOwner.getKitchen().getBalance(),100);

        try {
            assertTrue(testOwner.askForMoreIngredients(30));
        } catch (NotEnoughMoneyException e) {
            fail();
        }

        assertEquals(testOwner.getKitchen().getBalance(),40);
        assertEquals(testOwner.getKitchen().getIngredientCount(),60);

        try {
            assertFalse(testOwner.askForMoreIngredients(100000));
        } catch (NotEnoughMoneyException e) {}
    }


}
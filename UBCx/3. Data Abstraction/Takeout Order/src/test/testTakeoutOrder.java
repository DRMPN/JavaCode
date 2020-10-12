package test;

import Module.Order;

import org.junit.Before;
import org.junit.Test;

import static Main.Main.*;
import static org.junit.Assert.assertEquals;

public class testTakeoutOrder {

    private Order testOrder1;
    private Order testOrder2;
    private Order testOrder3;

    @Before
    public void SetUp() {
        testOrder1 = new Order();
        testOrder2 = new Order();
        testOrder3 = new Order();

        testOrder1.makeNewOrder(1,"First","No meat", 1);
        testOrder2.makeNewOrder(2,"Second","No cheese", 2);
        testOrder3.makeNewOrder(3,"Third","More pickles", 3);
    }


@Test
public void testGetOrderStatus() {
    assertEquals(testOrder1.getOrderStatus(), "Order is not ready!");
    assertEquals(testOrder2.getOrderStatus(), "Order is not ready!");
    assertEquals(testOrder3.getOrderStatus(), "Order is not ready!");
}

 @Test
 public void testComboPrice() {
     assertEquals(testOrder1.SelectedCombo.getComboPrice(), 2.99,0.01);
     assertEquals(testOrder2.SelectedCombo.getComboPrice(), 4.99,0.01);
     assertEquals(testOrder3.SelectedCombo.getComboPrice(), 6.99,0.01);
 }

 @Test
 public void testComboInformation() {
     assertEquals(testOrder1.SelectedCombo.getComboComposition(), "Coffee and IceCream");
     assertEquals(testOrder2.SelectedCombo.getComboComposition(), "French Fries, Ketchup, Juice");
     assertEquals(testOrder3.SelectedCombo.getComboComposition(), "Big CheeseBurger, Big Cola, 6x Chicken Nuggets, Sauce");
 }

 @Test
 public void testMainCookOrder() {
    addOrderToQueue(testOrder1);
    assertEquals(getOrderQueue().size(),1);
    cookOrder(testOrder1);
    assertEquals(getOrderQueue().size(),0);
  }


    @Test
    public void testTemplate() {
    }

}

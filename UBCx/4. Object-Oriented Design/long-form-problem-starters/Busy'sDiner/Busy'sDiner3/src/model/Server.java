package model;

import java.util.ArrayList;
import java.util.List;

public class Server extends Employee {

    private static final double DISH_PRICE = 10.00;

    private double cash;
    private int currentOrderNumber;
    private List<Order> orders;

    public Server(Dish dish) {
        super(dish, "SERVER - ");
        this.orders = new ArrayList<>();
        this.currentOrderNumber = 100;
    }

    //getter
    public List<Order> getActiveOrders() {
        return orders;
    }
    public double getCash() { return cash; }

    //MODIFIES: this
    //EFFECTS: creates new order with the dish on the menu
    public Order takeOrder() {
        System.out.println(this.getPrefix() + "Taking order...");
        Order o = new Order(this.getDish(), currentOrderNumber++);
        orders.add(o);
        System.out.print("Order taken: ");
        o.print();
        return o;
    }

    //MODIFIES: this
    //EFFECTS: takes payment for the guest and removes order from system
    public void takePayment(Order order) {
        System.out.println(this.getPrefix() + "Taking payment...");
        orders.remove(order);
        cash += DISH_PRICE;
        System.out.println(this.getPrefix() + "\"Thanks for visiting Busy's Diner!\"");
    }

    @Override
    public void doOrderRoutine(Order o) {
        if(o.isReadyToBePaid())
            this.takePayment(o);
    }

}

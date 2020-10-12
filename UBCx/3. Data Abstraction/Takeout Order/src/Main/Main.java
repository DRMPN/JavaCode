package Main;

import Module.Order;
import Module.Combo;

import java.util.ArrayList;

public class Main {

    public static ArrayList<Order> OrderQueue = new ArrayList<>();

    public static Order CustomerOne = new Order();

    public static ArrayList<Combo> listOfAllCombos = SetComboMenu();

    public static void main(String[] args) {
        System.out.println("Hello, what do you want to eat?");
        // print combo numbers with information
        printComboMenu();

        CustomerOne.makeNewOrder(1,"Bruce","No pickles",2);
        System.out.println("You have chosen combo number "+CustomerOne.SelectedCombo.getComboSetNumber()+
                ". Your price is: "+CustomerOne.SelectedCombo.getComboPrice());

        // check combo information and announce the price
        // add order to queue
        addOrderToQueue(CustomerOne);

        // get order status
        System.out.println(CustomerOne.getOrderStatus());

        // cook order
        System.out.println("We are cooking your order!");
        cookOrder(CustomerOne);

        // call customer back
        System.out.println(CustomerOne.getOrderStatus());
        System.out.println(CustomerOne.fullOrderStatusInformation());
    }

    public static void addOrderToQueue(Order order) {
        OrderQueue.add(order);
    }

    public static void cookOrder(Order order) {
        order.getSpecialInstructions();
        order.OrderStatus = true;
        OrderQueue.remove(order);
    }

    public static ArrayList<Combo> SetComboMenu() {
        Combo comboA = Combo.createCombo(1, "Coffee and IceCream", 2.99);
        Combo comboB = Combo.createCombo(2, "French Fries, Ketchup, Juice", 4.99);
        Combo comboC = Combo.createCombo(3, "Big CheeseBurger, Big Cola, 6x Chicken Nuggets, Sauce", 6.99);

        ArrayList<Combo> comboList = new ArrayList<>();
        comboList.add(comboA);
        comboList.add(comboB);
        comboList.add(comboC);
        return comboList;
    }

    public static void printComboMenu() {
        for (Combo combo : listOfAllCombos) {
            System.out.println("Number: "+combo.getComboSetNumber()+
                    " Description: "+combo.getComboComposition()+
                    " Price: "+combo.getComboPrice());
        }
    }

    public static ArrayList<Order> getOrderQueue() {
        return OrderQueue;
    }
}

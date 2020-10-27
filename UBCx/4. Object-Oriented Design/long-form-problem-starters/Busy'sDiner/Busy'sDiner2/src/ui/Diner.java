package ui;

import model.Chef;
import model.Dish;
import model.Server;
import model.Order;

import static model.Dish.generateTurkeyClubSandwich;

public class Diner {

    public static void main(String[] args) {
        Dish dish = generateTurkeyClubSandwich();
        Server server = new Server(dish);
        Chef chef = new Chef();

        for (int i=0; i < 2 ; i++) {
            System.out.println("Table " + (i + 1) + ":\n");

            server.greet();
            server.describeDish(dish);
            Order o = server.takeOrder();

            System.out.println();
            chef.makeDish(o);

            doOrderRoutine(server, o);
            System.out.println();
        }

        System.out.println();
        chef.doDishes();
    }

    private static void doOrderRoutine(Server s, Order o) {
        System.out.println();
        if (o.isReadyToBeServed())
            s.deliverFood(o);
        if(o.isReadyToBePaid())
            s.takePayment(o);
    }

}

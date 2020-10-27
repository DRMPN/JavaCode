package ui;

import model.Chef;
import model.Employee;
import model.Order;

public class Diner {

    public static void main(String[] args) {
        Employee employee = new Employee();
        Chef chef = new Chef();

        for (int i=0; i < 2 ; i++) {
            System.out.println("Table " + (i + 1) + ":\n");

            employee.greet();
            employee.describeDish();
            Order o = employee.takeOrder();

            System.out.println();

            doOrderRoutine(employee,chef, o);
            System.out.println();
        }

        System.out.println();
        chef.doDishes();
    }

    private static void doOrderRoutine(Employee e, Chef c, Order o) {
        if (o.needsToBePrepared())
            c.makeDish(o);
        System.out.println();
        if (o.isReadyToBeServed())
            e.deliverFood(o);
        if(o.isReadyToBePaid())
            e.takePayment(o);
    }

}

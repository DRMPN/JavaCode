package model;

public class Host extends Employee {

    public Host(Dish dish) {
        super(dish,"HOST - ");
    }

    //EFFECTS: prints out a greeting
    public void greet() {
        System.out.println(this.getPrefix()+ "\"Hello and welcome to Busy's, the home of the trendy turkey club sandwich.\"");
    }

    //EFFECTS: prints out a description of the dish on the menu
    public void describeDish() {
        System.out.println(this.getPrefix() + this.getDish().getDescription());
    }

    //MODIFIES: this, order
    //EFFECTS: logs order as served and brings to table
    public void deliverFood(Order order) {
        order.setIsServed();
        System.out.print(this.getPrefix() + "Delivered food: ");
        order.print();
    }

    @Override
    public void doOrderRoutine(Order o) {
        if (o.isReadyToBeServed())
            this.deliverFood(o);
    }

}

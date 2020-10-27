package model;

public abstract class Employee {

    protected Dish dish;
    protected String prefix;

    public Employee(Dish dish, String prefix) {
        this.dish = dish;
        this.prefix = prefix;
    }

    public void doOrderRoutine(Order order) {
        System.out.println("Nothing to do :)");
    }

    // getters
    public Dish getDish() {
        return dish;
    }
    public String getPrefix() {
        return prefix;
    }
}

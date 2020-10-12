package model;

public abstract class Employee {

    public static double BASE_WAGE = 10.00;
    protected String name;
    protected int age;
    protected double hoursWorked;
    protected boolean atWork;

    protected Employee(String name, int age) {
        this.name = name;
        this.age = age;
        hoursWorked = 0;
        atWork = false;
    }

    // getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public boolean isAtWork() { return atWork; }
    public double getHoursWorked() { return hoursWorked; }

    // MODIFIES: this
    // EFFECTS: adds hours to the hoursWorked field
    public void logHoursWorked(double hours) {
        hoursWorked += hours;
    }

    // EFFECTS: sets isRegisterOpen to true, and updates atWork to reflect that this Cashier is
    //          now at work
    public abstract void startWork(double hours);

    // EFFECTS: sets isRegisterOpen to false and updates atWork to reflect that this Cashier is
    //          no longer at work
    public abstract void leaveWork();

    // EFFECTS: returns the total amount of wages this Manager made
    public abstract double computeWage();
}

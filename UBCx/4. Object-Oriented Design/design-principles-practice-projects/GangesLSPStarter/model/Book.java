package model;

public abstract class Book {

    protected String title;
    protected double price;
    protected Box box;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
        this.box = null; // book starts off unpackaged
    }

    // getters
    public String getTitle() {
        return title;
    }
    public double getPrice() {
        return price;
    }
    public Box getBox() {
        return box;
    }

    // setters
    public void setBox(Box box) {
        this.box = box;
    }

    public abstract Box packageBook(Box b);
    public abstract double calculateShipping();
    public abstract String getMinBoxSize();
}

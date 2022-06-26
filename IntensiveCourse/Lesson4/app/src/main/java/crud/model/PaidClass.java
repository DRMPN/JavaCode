package crud.model;

public class PaidClass extends AbstractClass {
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PaidClass [price=" + price + "]";
    }
    
}

package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * model.Customer interface for making requests of various Ganges.com, Inc. services.
 */
public class GangesServiceManager {

    private BookSeller bs;
    private DataStorage ds;

    private int customerIdCounter;
    public static final int FIRST_CUSTOMER_NUMBER = 100;
    private static final int FIRST_ORDER_NUMBER = 1000;

    public GangesServiceManager() {
        bs = new BookSeller(FIRST_ORDER_NUMBER);
        ds = new DataStorage();

        this.customerIdCounter = FIRST_CUSTOMER_NUMBER;
    }

    // EFFECTS: Create a new customer with the given address and name
    public Customer signUpNewCustomer(String address, String name) {
        return new Customer(name, address, customerIdCounter++);
    }

    // EFFECTS: Print all books for sale to the console, along with the index number + 1.
    public void listAvailableBooks() {
        bs.listAvailableBooks();
    }


    // MODIFIES: bookSeller
    // EFFECTS:  Creates an order with given customer and book number
    public BookOrder orderBook(Customer c, int bookNumber) {
        return bs.orderBook(c, bookNumber);
    }

    // MODIFIES: bookSeller
    // EFFECTS: Cancels book order with given order number
    public boolean cancelBookOrder(int orderNumber) {
        return bs.cancelBookOrder(orderNumber);
    }

    // MODIFIES: dataStorage
    // EFFECTS:  Stores given data under customer
    public void putData(Customer c, String data) {
        ds.putData(c,data);
    }

    // MODIFIES: dataStorage
    // EFFECTS:  Returns customer's data
    public String getData(Customer c) {
        return ds.getData(c);
    }

    // MODIFIES: dataStorage
    // EFFECTS:  Deletes customer's data
    public String deleteData(Customer c) {
        return ds.deleteData(c);
    }
}

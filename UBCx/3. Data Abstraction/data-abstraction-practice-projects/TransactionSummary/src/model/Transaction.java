package model;

public class Transaction {

    private final String name;
    private final String date;
    private final int amount;
    private final TransactionType type;

    public Transaction(String name, String date, int amount, TransactionType type) {
       this.name = name;
       this.date = date;
       this.amount = amount;
       this.type = type;
    }

    // getters

    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    public int getAmount() {
        return amount;
    }
    public TransactionType getType() {
        return type;
    }
}

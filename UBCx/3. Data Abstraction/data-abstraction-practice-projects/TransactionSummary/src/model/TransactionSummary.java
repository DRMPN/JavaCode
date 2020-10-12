package model;

import java.util.LinkedList;
import java.util.List;

public class TransactionSummary {

    private final String name;
    private final List<Transaction> transactions;

    public TransactionSummary(String name) {
        this.name = name;
        this.transactions = new LinkedList<>();
    }

    // getters
    public String getName() {
        return name;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public int getNumTransactions() {
        return this.getTransactions().size();
    }

    // REQUIRES: t is not already within transactions
    // MODIFIES: this
    // EFFECTS: adds the given transaction t to the list of transactions
    public void addTransaction(Transaction t) {
        if (!this.getTransactions().contains(t)) {
            this.getTransactions().add(t);
        }
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS: computes the average amount of money spent on a transaction
    public double averageTransactionCost() {
        double amt = 0;
        for (Transaction t : transactions) {
            amt+=t.getAmount();
        }
        return amt/getNumTransactions();
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS:  returns the average cost of all transactions of type specificType in this
    //           TransactionSummary
    public double specificTypeAverage(TransactionType specificType) {
        double amt = 0;
        int n = 0;
        for (Transaction t : transactions) {
            if (t.getType()==specificType) {
                amt+=t.getAmount();
                n+=1;
            }
        }
        return amt/n;
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS: returns the largest transaction (in terms of cost) in this TransactionSummary
    public Transaction largestTransaction() {
        Transaction largest = null;
        for (Transaction t : transactions) {
            if (largest==null) {largest = t;}
            else if (t.getAmount() > largest.getAmount()) {largest = t;}
        }
        return largest;
    }

    // EFFECTS: returns true if the given transaction is contained within the list of transactions
    public boolean contains(Transaction t) {
       return this.transactions.contains(t);
    }

}

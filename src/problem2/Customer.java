package problem2;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Double> transactions;
    // if the value of the double is negative => debit, positive => credit

    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
    }

    public String getName() {
        return name;
    }
    public List<Double> getTransactions() {
        return transactions;
    }
    public void addTransaction(Double transaction) {
        transactions.add(transaction);
    }

    @Override
    public String toString() {
        return "Customer: " + name + ", Transactions: " + transactions;
    }
}

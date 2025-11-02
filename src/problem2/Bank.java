package problem2;
import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(String customerName) {
        if(findCustomer(customerName) ==null) {
            customers.add(new Customer(customerName));
            System.out.println("Customer added: "+ customerName);
        } else {
            System.out.println("Customer already exists.");
        }
    }

    public void addTransaction(String customerName, double amount) {
        Customer customer = findCustomer(customerName);
        if(customer != null) {
            customer.addTransaction(amount);
            System.out.println("Transaction added for "+ customerName+ ": "+ amount);
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void printStatement() {
        System.out.println("\n=== Bank Statement for "+ name + " ===");
        for (Customer c : customers) {
            System.out.println(c.getName() +" transactions:");
            for(double t : c.getTransactions()) {
                System.out.println(" - "+ t);
            }
        }
    }

    private Customer findCustomer(String name) {
        for (Customer c : customers) {
            if(c.getName().equalsIgnoreCase(name)) return c;
        }
        return null;
    }
}

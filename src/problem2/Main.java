package problem2;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("CS Bank");

        bank.addCustomer("Ahmed");
        bank.addCustomer("J3fr");

        bank.addTransaction("Ahmed", 150.0);
        bank.addTransaction("Ahmed", -30.0);
        bank.addTransaction("J3fr", 200.0);

        bank.printStatement();
    }
}

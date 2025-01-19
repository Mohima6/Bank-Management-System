public class Transaction {
    private Account account;

    // Constructor to initialize with an account
    public Transaction(Account account) {
        this.account = account;
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrawn: " + amount);
            System.out.println("New Balance: " + account.getBalance());
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposited: " + amount);
            System.out.println("New Balance: " + account.getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}

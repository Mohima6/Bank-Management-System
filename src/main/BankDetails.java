import java.util.ArrayList;
import java.util.List;

public class BankDetails {
    private String bankName;
    private List<Account> accounts;

    // Constructor to initialize bank details
    public BankDetails(String bankName) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }

    // Method to add an account
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Method to get all accounts
    public List<Account> getAccounts() {
        return accounts;
    }

    // Method to search an account by account number
    public Account searchAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;  // Return null if account not found
    }
}

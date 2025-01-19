import java.util.HashMap;

public class BankManagementSystem {
    private static HashMap<String, Customer> customers = new HashMap<>();

    // Add customer to the database
    public static void addCustomer(String username, String password, double balance) {
        customers.put(username, new Customer(username, password, balance));
    }

    // Retrieve customer
    public static Customer getCustomer(String username) {
        return customers.get(username);
    }

    // Validate login
    public static boolean validateLogin(String username, String password) {
        Customer customer = customers.get(username);
        return customer != null && customer.getPassword().equals(password);
    }
}

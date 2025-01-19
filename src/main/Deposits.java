import javax.swing.*;
import java.awt.event.*;

public class Deposits extends JFrame {
    private JTextField amountField;
    private JButton depositButton, backButton;

    public Deposits(String username) {
        setTitle("Deposit Money");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel amountLabel = new JLabel("Amount to deposit:");
        amountLabel.setBounds(20, 20, 120, 30);
        panel.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(150, 20, 100, 30);
        panel.add(amountField);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(50, 80, 80, 30);
        panel.add(depositButton);

        backButton = new JButton("Back");
        backButton.setBounds(150, 80, 80, 30);
        panel.add(backButton);

        add(panel);

        depositButton.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            Customer customer = BankManagementSystem.getCustomer(username);
            customer.setBalance(customer.getBalance() + amount);

            JOptionPane.showMessageDialog(null, "Deposit successful! New balance: $" + customer.getBalance());
        });

        backButton.addActionListener(e -> {
            dispose();
            new MainMenu(username).setVisible(true);
        });
    }
}

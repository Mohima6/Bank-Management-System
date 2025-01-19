import javax.swing.*;
import java.awt.event.*;

public class Withdraw extends JFrame {
    private JTextField amountField;
    private JButton withdrawButton, backButton;

    public Withdraw(String username) {
        setTitle("Withdraw Money");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel amountLabel = new JLabel("Amount to withdraw:");
        amountLabel.setBounds(20, 20, 120, 30);
        panel.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(150, 20, 100, 30);
        panel.add(amountField);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(50, 80, 80, 30);
        panel.add(withdrawButton);

        backButton = new JButton("Back");
        backButton.setBounds(150, 80, 80, 30);
        panel.add(backButton);

        add(panel);

        withdrawButton.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            Customer customer = BankManagementSystem.getCustomer(username);

            if (customer.getBalance() >= amount) {
                customer.setBalance(customer.getBalance() - amount);
                JOptionPane.showMessageDialog(null, "Withdrawal successful! New balance: $" + customer.getBalance());
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient funds!");
            }
        });

        backButton.addActionListener(e -> {
            dispose();
            new MainMenu(username).setVisible(true);
        });
    }
}

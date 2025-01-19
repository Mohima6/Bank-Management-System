import javax.swing.*;
import java.awt.event.*;

public class Transfer extends JFrame {
    private JTextField recipientField, amountField;
    private JButton transferButton, backButton;

    public Transfer(String username) {
        setTitle("Transfer Money");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel recipientLabel = new JLabel("Recipient username:");
        recipientLabel.setBounds(20, 20, 150, 30);
        panel.add(recipientLabel);

        recipientField = new JTextField();
        recipientField.setBounds(150, 20, 100, 30);
        panel.add(recipientField);

        JLabel amountLabel = new JLabel("Amount to transfer:");
        amountLabel.setBounds(20, 60, 150, 30);
        panel.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(150, 60, 100, 30);
        panel.add(amountField);

        transferButton = new JButton("Transfer");
        transferButton.setBounds(50, 110, 80, 30);
        panel.add(transferButton);

        backButton = new JButton("Back");
        backButton.setBounds(150, 110, 80, 30);
        panel.add(backButton);

        add(panel);

        transferButton.addActionListener(e -> {
            String recipient = recipientField.getText();
            double amount = Double.parseDouble(amountField.getText());
            Customer sender = BankManagementSystem.getCustomer(username);
            Customer receiver = BankManagementSystem.getCustomer(recipient);

            if (receiver != null) {
                if (sender.getBalance() >= amount) {
                    sender.setBalance(sender.getBalance() - amount);
                    receiver.setBalance(receiver.getBalance() + amount);
                    JOptionPane.showMessageDialog(null, "Transfer successful! New balance: $" + sender.getBalance());
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient funds!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Recipient not found!");
            }
        });

        backButton.addActionListener(e -> {
            dispose();
            new MainMenu(username).setVisible(true);
        });
    }
}

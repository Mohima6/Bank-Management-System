import javax.swing.*;
import java.awt.event.*;

public class MainMenu extends JFrame {
    private JButton depositButton, withdrawButton, transferButton, logoutButton;
    private String username;

    public MainMenu(String username) {
        this.username = username;
        setTitle("Main Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(50, 50, 120, 30);
        panel.add(depositButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(200, 50, 120, 30);
        panel.add(withdrawButton);

        transferButton = new JButton("Transfer");
        transferButton.setBounds(50, 100, 120, 30);
        panel.add(transferButton);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(200, 100, 120, 30);
        panel.add(logoutButton);

        add(panel);

        depositButton.addActionListener(e -> {
            new Deposits(username).setVisible(true);
        });

        withdrawButton.addActionListener(e -> {
            new Withdraw(username).setVisible(true);
        });

        transferButton.addActionListener(e -> {
            new Transfer(username).setVisible(true);
        });

        logoutButton.addActionListener(e -> {
            dispose();
            new Login().setVisible(true);
        });
    }
}

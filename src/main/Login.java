import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 20, 100, 30);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(120, 20, 150, 30);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 60, 100, 30);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 60, 150, 30);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 110, 80, 30);
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (BankManagementSystem.validateLogin(username, password)) {
                    dispose();
                    new MainMenu(username).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login credentials!");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Prepopulate some customers for testing
        BankManagementSystem.addCustomer("user1", "pass1", 5000.0);
        BankManagementSystem.addCustomer("user2", "pass2", 3000.0);

        new Login().setVisible(true);
    }
}

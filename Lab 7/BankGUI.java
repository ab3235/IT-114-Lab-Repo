
import java.awt.*;
import javax.swing.*;

public class BankGUI {

    public static void main(String[] args) {

        // Get first name window
        String firstName;
        do {
            firstName = JOptionPane.showInputDialog("Please enter your first name:");
            if (firstName == null || !firstName.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Error: First name must contain only letters.");
                firstName = null;
            }
        } while (firstName == null);

        // Get last name window
        String lastName;
        do {
            lastName = JOptionPane.showInputDialog("Please enter your last name:");
            if (lastName == null || !lastName.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Error: Last name must contain only letters.");
                lastName = null;
            }
        } while (lastName == null);
        String name = firstName + " " + lastName;

        // Init Deposit window
        double initialDeposit = -1;
        while (initialDeposit < 0) {
            String depositStr = JOptionPane.showInputDialog("Enter initial deposit:");
            if (depositStr == null) {
                continue;
            }
            try {
                initialDeposit = Double.parseDouble(depositStr);
                if (initialDeposit < 0) {
                    JOptionPane.showMessageDialog(null, "Deposit must be 0 or more.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: Please enter a valid number");
            }
        }

        // Option choose account type
        String[] options = {"Checking", "Savings"};
        int choice = -1;
        while (choice == -1) {
            choice = JOptionPane.showOptionDialog(null, "Checking or Savings?", "Account Type",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);
            if (choice == JOptionPane.CLOSED_OPTION) {
                choice = -1;

            }
        }
        // Account Type 
        BankAccount account;
        if (choice == 0) {
            account = new CheckingAccount(name, initialDeposit);
        } else {
            account = new SavingsAccount(name, initialDeposit);
        }

        // Main GUI
        JFrame window = new JFrame("Bank Account Manager");
        JLabel welcomeLabel = new JLabel("Welcome,   " + account.getAccountHolder() + "!                           |                            " + account, SwingConstants.CENTER);
        JLabel balanceLabel = new JLabel("Balance: $" + String.format("%.2f", account.getBalance()), SwingConstants.LEFT);
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel centerGrid = new JPanel(new GridLayout(2, 2, 10, 10));
        JTextField amountField = new JTextField(10);
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);
        centerGrid.add(balanceLabel);
        centerGrid.add(amountField);

        //buttons
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        centerGrid.add(depositButton);
        centerGrid.add(withdrawButton);

        //assemble
        mainPanel.add(centerGrid, BorderLayout.CENTER);
        JButton exitButton = new JButton("Exit");
        mainPanel.add(exitButton, BorderLayout.SOUTH);

// listeners
        // Deposit 
        depositButton.addActionListener(e -> {
            try {
                double amt = Double.parseDouble(amountField.getText());
                String msg = account.deposit(amt);
                balanceLabel.setText("Balance: $" + String.format("%.2f", account.getBalance()));
                JOptionPane.showMessageDialog(window, msg);
                amountField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(window, "Error: Please enter a valid number");
            }
        });

        // Withdraw 
        withdrawButton.addActionListener(e -> {
            try {
                double amt = Double.parseDouble(amountField.getText());
                String msg = account.withdraw(amt);
                balanceLabel.setText("Balance: $" + String.format("%.2f", account.getBalance()));
                JOptionPane.showMessageDialog(window, msg);
                amountField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(window, "Error: Please enter a valid number");
            }
        });

        exitButton.addActionListener(e -> System.exit(0));
        window.setContentPane(mainPanel);
        window.setSize(500, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}

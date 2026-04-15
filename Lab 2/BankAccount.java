
public abstract class BankAccount {

    // DO NOT CHANGE ANY VARIABLE, METHOD, OR CLASS NAMES. THE AUTOGRADER DEPENDS ON THEM.
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialDeposit) {
        // TODO: Initialize the instance variables
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
    }

    public void deposit(double amount) {
        // TODO: Implement deposit logic
        if (amount > 0) {
            return "Please enter a valid number";
        }
        balance += amount;
        return String
    }

    /**
     * Abstract method: Child classes must implement this.
     */
    public abstract void withdraw(double amount);

    // --- GETTERS AND SETTERS ---
    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
}

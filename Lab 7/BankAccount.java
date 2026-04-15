
public abstract class BankAccount {

    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialDeposit) {
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
    }

    public String deposit(double amount) {
        if (amount <= 0) {
            return "Please enter a valid number";
        }
        balance += amount;
        return "Deposit successful! New Balance: $" + balance;
    }

    public abstract String withdraw(double amount);

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

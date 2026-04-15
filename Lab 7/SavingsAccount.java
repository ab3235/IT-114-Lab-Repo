
public class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountHolder, double initialDeposit) {
        super(accountHolder, initialDeposit);
    }

    @Override
    public String withdraw(double amount) {
        if (amount <= 0) {
            return "Please enter a valid number";
        }
        if (amount > getBalance()) {
            return "Transaction Denied: Insufficient funds. Balance remains: $" + getBalance();
        }
        setBalance(getBalance() - amount);
        return "Withdrawal successful! New Balance: $" + getBalance();
    }
}

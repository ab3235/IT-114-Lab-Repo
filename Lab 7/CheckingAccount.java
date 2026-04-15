
public class CheckingAccount extends BankAccount {

    private final double OVERDRAFT_FEE = 35.00;

    public CheckingAccount(String accountHolder, double initialDeposit) {
        super(accountHolder, initialDeposit);
    }

    @Override
    public String withdraw(double amount) {
        if (amount <= 0) {
            return "Please enter a valid number";
        }
        if (amount > getBalance()) {
            setBalance(getBalance() - amount - OVERDRAFT_FEE);
            return "Overdraft! $35.00 fee applied. New Balance: $" + getBalance();
        }
        setBalance(getBalance() - amount);
        return "Withdrawal successful! New Balance: $" + getBalance();
    }
}

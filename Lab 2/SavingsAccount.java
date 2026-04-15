
public class SavingsAccount extends BankAccount {
    // DO NOT CHANGE ANY VARIABLE, METHOD, OR CLASS NAMES. THE AUTOGRADER DEPENDS ON THEM.

    public SavingsAccount(String accountHolder, double initialDeposit) {
        super(accountHolder, initialDeposit);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= getBalance()) {
                setBalance(getBalance() - amount);
                System.out.println("Withdrawn: " + amount);
            } else {
                System.out.println("Insufficient funds in Savings account!");
            }
        } else {
            System.out.println("Withdrawal amount must be positive!");
        }
    }
}

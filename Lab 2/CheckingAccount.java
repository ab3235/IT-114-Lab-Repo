
public class CheckingAccount extends BankAccount {
    // DO NOT CHANGE ANY VARIABLE, METHOD, OR CLASS NAMES. THE AUTOGRADER DEPENDS ON THEM.

    public CheckingAccount(String accountHolder, double initialDeposit) {
        super(accountHolder, initialDeposit);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= getBalance()) {
                setBalance(getBalance() - amount);
                System.out.println("Withdrawn: " + amount);
            } else {
                System.out.println("No money in the Checking account!");
            }
        } else {
            System.out.println("Error");
        }
    }
}

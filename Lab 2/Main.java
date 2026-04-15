
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter User name: ");
        String name = scanner.nextLine();

        System.out.print("Create your Initial Deposit: ");
        double initialDeposit = scanner.nextDouble();

        System.out.print("Press 1 For Checking | Press 2 For Savings: ");
        int choice = scanner.nextInt();

        BankAccount account;
        if (choice == 1) {
            account = new CheckingAccount(name, initialDeposit);
        } else {
            account = new SavingsAccount(name, initialDeposit);
        }

        int option = 0;
        while (option != 4) {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print(
                    "Enter Amount to Deposit: ;
                    account.deposit(scanner.nextDouble());
                    System.out.println("Current Balance: " + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter Amount to Withdraw:");
                    account.withdraw(scanner.nextDouble());
                    System.out.println("Current Balance: " + account.getBalance());
                    break;

                case 3:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }

        scanner.close();
    }
}

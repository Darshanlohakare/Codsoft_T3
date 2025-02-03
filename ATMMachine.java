import java.util.Scanner;

// BankAccount class to store and manage account balance
class BankAccount {
    private double balance;

    // Constructor to initialize balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Transaction failed.");
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        }
    }

    // Method to check balance
    public double getBalance() {
        return balance;
    }
}

// ATM class to provide user interface
class ATM {
    private BankAccount account;
    private Scanner scanner;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Display menu and process user choice
    public void start() {
        while (true) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Your current balance is: $" + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

// Main class to run the ATM application
public class ATMMachine {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.00); // Initial balance of $1000

        // Create and start the ATM
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}

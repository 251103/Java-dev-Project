package project;
import java.util.*;
			// Task 3 ATM
public class ATM {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter your branch number: ");
        String branchNumber = scanner.nextLine();
        System.out.print("Set your 4-digit password: ");
        String password = scanner.nextLine();

        BankAccount account = new BankAccount(name, accountNumber, branchNumber, password);

        while (true) {
            System.out.println("Welcome to the ATM, " + name + "!");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Please enter your 4-digit password: ");
                    String enteredPassword = scanner.nextLine();
                    if (!account.validatePassword(enteredPassword)) {
                        System.out.println("Invalid password. Please try again.");
                        continue;
                    }
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String depositName = scanner.nextLine();
                    System.out.print("Enter your account number: ");
                    String depositAccountNumber = scanner.nextLine();
                    if (!account.validateUser(depositName, depositAccountNumber)) {
                        System.out.println("Invalid name or account number. Please try again.");
                        continue;
                    }
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

class BankAccount {
    private String name;
    private String accountNumber;
    private String branchNumber;
    private String password;
    private double balance;

    public BankAccount(String name, String accountNumber, String branchNumber, String password) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.branchNumber = branchNumber;
        this.password = password;
        this.balance = 0.0;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }

    public boolean validatePassword(String enteredPassword) {
        return this.password.equals(enteredPassword);
    }

    public boolean validateUser(String name, String accountNumber) {
        return this.name.equals(name) && this.accountNumber.equals(accountNumber);
    }
}

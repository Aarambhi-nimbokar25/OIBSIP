import java.util.Scanner;

class ATM {
    private double balance;
    private String userId = "user123";
    private String pin = "1234";

    Scanner sc = new Scanner(System.in);

    // Login Method
    public boolean login() {
        System.out.println("===== WELCOME TO ATM MACHINE =====");
        System.out.print("Enter User ID: ");
        String enteredUser = sc.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = sc.nextLine();

        if (enteredUser.equals(userId) && enteredPin.equals(pin)) {
            System.out.println("Login Successful!\n");
            return true;
        } else {
            System.out.println("Invalid User ID or PIN!");
            return false;
        }
    }

    // Display Menu
    public void showMenu() {
        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Transaction history feature coming soon!");
                    break;

                case 2:
                    withdraw();
                    break;

                case 3:
                    deposit();
                    break;

                case 4:
                    transfer();
                    break;

                case 5:
                    checkBalance();
                    break;

                case 6:
                    System.out.println("Thank you for using ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);
    }

    // Withdraw Method
    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Deposit Method
    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        balance += amount;
        System.out.println("Deposit successful!");
    }

    // Transfer Method
    public void transfer() {
        System.out.print("Enter recipient account number: ");
        sc.next();  // dummy input

        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Check Balance
    public void checkBalance() {
        System.out.println("Your current balance is: ₹" + balance);
    }
}

public class ATMInterface {
    public static void main(String[] args) {

        ATM atm = new ATM();

        if (atm.login()) {
            atm.showMenu();
        } else {
            System.out.println("Exiting system...");
        }
    }
}
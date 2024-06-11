package codsoft;
import java.util.Scanner;


    class BankAccount {
        private double balance;

        public BankAccount(double balance) {
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public boolean withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                return true;
            }
            return false;
        }
    }

    class ATM {
        private BankAccount account;

        public ATM(BankAccount account) {
            this.account = account;
        }

        public void displayMenu() {
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
        }

        public void checkBalance() {
            System.out.println("Your balance is: Rs" + account.getBalance());
        }

        public void deposit(double amount) {
            account.deposit(amount);
            System.out.println("Rs" + amount + " deposited successfully.");
        }

        public void withdraw(double amount) {
            if (account.withdraw(amount)) {
                System.out.println("Rs" + amount + " withdrawn successfully.");
            } else {
                System.out.println("Insufficient balance");
            }
        }
    }

    public class ATMInterface {
        public static void main(String[] args) {
            BankAccount account = new BankAccount(1000.0);
            ATM atm = new ATM(account);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                atm.displayMenu();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        if (depositAmount <= 0) {
                            System.out.println("Invalid deposit amount.");
                        } else {
                            atm.deposit(depositAmount);
                        }
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        if (withdrawalAmount <= 0) {
                            System.out.println("Invalid withdrawal amount.");
                        } else {
                            atm.withdraw(withdrawalAmount);
                        }
                        break;
                    case 4:
                        System.out.println("Thank you for using our ATM. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }



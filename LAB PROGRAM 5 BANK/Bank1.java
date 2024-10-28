import java.util.Scanner;

abstract class Account {
    String customerName;
    String accountNumber;
    double balance;

    public Account(String customerName, String accountNumber, double initialBalance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void displayBalance();
}

class SavingsAccount extends Account {
    public SavingsAccount(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, initialBalance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void computeAndDepositInterest() {
        double interest = balance * 0.04; 
        balance += interest;
        System.out.println("Interest deposited: " + interest);
    }

    public void displayBalance() {
        System.out.println("Savings Account Balance: " + balance);
    }
}

class CurrentAccount extends Account {
    private double minimumBalance;

    public CurrentAccount(String customerName, String accountNumber, double initialBalance, double minimumBalance) {
        super(customerName, accountNumber, initialBalance);
        this.minimumBalance = minimumBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        checkMinimumBalance();
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void checkMinimumBalance() {
        if (balance < 1000) {
            balance -= 50; 
            System.out.println("Minimum balance not maintained. Service charge imposed: 50");
        }
    }

    public void displayBalance() {
        System.out.println("Current Account Balance: " + balance);
    }
}

public class Bank1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 for Savings Account and 2 for Current Account 3 to Exit:");
            String input1 = scanner.nextLine();
            if (input1.equals("1")) {
                System.out.print("Enter customer name for Savings Account: ");
                String savingsName = scanner.nextLine();
                System.out.print("Enter account number: ");
                String accountNumber = scanner.nextLine();
                double initialSavingsBalance = 0; 
                SavingsAccount savingsAccount = new SavingsAccount(savingsName, accountNumber, initialSavingsBalance);
                handleSavingsAccount(scanner, savingsAccount);
            } else if (input1.equals("2")) {
                System.out.print("Enter customer name for Current Account: ");
                String currentName = scanner.nextLine();
                System.out.print("Enter account number: ");
                String accountNumber2 = scanner.nextLine();
                double initialCurrentBalance = 0; 
                double minimumBalance = 1000;
                CurrentAccount currentAccount = new CurrentAccount(currentName, accountNumber2, initialCurrentBalance, minimumBalance);
                handleCurrentAccount(scanner, currentAccount);
            } else {
                System.out.println("Exited");
                break;
            }
        }
        scanner.close();
    }

    private static void handleSavingsAccount(Scanner scanner, SavingsAccount account) {
        while (true) {
            System.out.println("Enter 1 for deposit, 2 for withdrawal, 3 for balance, 4 for interest,or any other number to exit:");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                System.out.print("Enter amount to deposit into Savings Account: ");
                account.deposit(scanner.nextDouble());
                scanner.nextLine();
            } else if (input.equals("2")) {
                System.out.print("Enter amount to withdraw from Savings Account: ");
                account.withdraw(scanner.nextDouble());
                scanner.nextLine();
            } else if (input.equals("3")) {
                account.displayBalance();
            } else if (input.equals("4")) {
                account.computeAndDepositInterest();
            }
	 else {
                break; 
            }
        }
    }

    private static void handleCurrentAccount(Scanner scanner, CurrentAccount account) {
        while (true) {
            System.out.println("Enter 1 for deposit, 2 for withdrawal, 3 for balance, or any other number to exit:");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                System.out.print("Enter amount to deposit into Current Account: ");
                account.deposit(scanner.nextDouble());
                scanner.nextLine();
            } else if (input.equals("2")) {
                System.out.print("Enter amount to withdraw from Current Account: ");
                account.withdraw(scanner.nextDouble());
                scanner.nextLine(); 
            } else if (input.equals("3")) {
                account.displayBalance();
            } else {
                break; 
            }}}}

import java.util.*;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getbalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void AtmMenu() {
        System.out.println("Welcome to SBI ATM :) ");
        System.out.println("1.Check Bank Balance");
        System.out.println("2.Deposit");
        System.out.println("3.Withdraw");
        System.out.println("4. Exit");
    }

    public void Transaction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your four digit atm pin to access your account :)");
        int pin = scanner.nextInt();
        int selection;
        double amount;

        while (true) {
            AtmMenu();
            System.out.println("Enter your choice:");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Your balance is: $." + account.getbalance());
                    break;
                case 2:
                    System.out.println("Enter the amount to deposit: $. ");
                    amount = scanner.nextDouble();

                    if (amount > 0) {
                        account.deposit(amount);
                        System.out.println("Your entered amount is successfully added.");
                    } else {
                        System.out.println("Invalid amount transaction sorry visit branch");
                    }
                    break;

                case 3:
                    System.out.println("Enter how much  amount  withdraw ");
                    amount = scanner.nextDouble();

                    if (amount > 0 && account.withdraw(amount)) {
                        System.out.println("Withrawal Successful ");
                    } else {
                        System.out.println("Invalid amount  withrawal plz try again ");
                    }
                    scanner.close();
                    break;

                case 4:
                    System.out.println("Thank you for using SBI ATM, Visit again , Jay Shree Krishna");
                    return;

                default:
                    System.out.println("Thank you for using SBI ATM, Visit again , Jay Shree Krishna");
                    break;

            }
        }

    }
}

public class atm_interface {

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(100.00); // Account opning balance
        ATM atm = new ATM(userAccount);
        atm.Transaction();
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class BankATM {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> transactionHistory = new ArrayList<String>();

    public static void displayBalance(int balance) {
        System.out.println("Current Balance : " + balance);
    }

    public static int amountWithdrawing(int balance, int withdrawAmount) {
        System.out.println("Withdrawal Operation:");
        System.out.println("Withdrawing Amount : " + withdrawAmount);
        if (balance >= withdrawAmount) {
            balance = balance - withdrawAmount;
            System.out.println("Please collect your money and collect the card");
            displayBalance(balance);
            transactionHistory.add("Withdrawal of " + withdrawAmount);
        } else {
            System.out.println("Sorry! Insufficient Funds");
        }
        return balance;
    }

    public static int amountDepositing(int balance, int depositAmount) {
        System.out.println("Deposit Operation:");
        System.out.println("Depositing Amount : " + depositAmount);
        balance = balance + depositAmount;
        System.out.println("Your Money has been successfully deposited");
        displayBalance(balance);
        transactionHistory.add("Deposit of " + depositAmount);
        return balance;
    }

    public static int amountTransfer(int balance, int transferAmount) {
        System.out.println("Transfer Operation:");
        System.out.println("Transfer Amount : " + transferAmount);
        if (balance >= transferAmount) {
            balance = balance - transferAmount;
            System.out.println("Transfer Successful");
            displayBalance(balance);
            transactionHistory.add("Transfer of " + transferAmount);
        } else {
            System.out.println("Sorry! Insufficient Funds");
        }
        return balance;
    }

    public static void main(String args[]) {
        int balance = 0;
        int option = 0;
        boolean quit = false;
        while (!quit) {
            System.out.println("Enter an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Quit");

            option = scanner.nextInt();
            switch (option) {
                case 1:
                    displayBalance(balance);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    int withdrawAmount = scanner.nextInt();
                    balance = amountWithdrawing(balance, withdrawAmount);
                    break;
                case 3:
                    System.out.println("Enter amount to deposit:");
                    int depositAmount = scanner.nextInt();
                    balance = amountDepositing(balance, depositAmount);
                    break;
                case 4:
                    System.out.println("Enter amount to transfer:");
                    int transferAmount = scanner.nextInt();
                    balance = amountTransfer(balance, transferAmount);
                    break;
                case 5:
                    System.out.println("Transaction History:");
                    for (String transaction : transactionHistory) {
                        System.out.println(transaction);
                    }
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option selected!");
                    break;
            }
        }
    }
}

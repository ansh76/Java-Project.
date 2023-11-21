import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {

    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 0;
    int transactions = 0;
    ArrayList<String> transactionHistory = new ArrayList<>();

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Name - ");
        this.name = sc.nextLine();
        System.out.print("\nEnter Your Username - ");
        this.userName = sc.nextLine();
        System.out.print("\nEnter Your Password - ");
        this.password = sc.nextLine();
        System.out.print("\nEnter Your Account Number - ");
        this.accountNo = sc.nextLine();
        System.out.println("\nRegistration completed..kindly login");
    }

    public boolean login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while (!isLogin) {
            System.out.print("\nEnter Your Username - ");
            String Username = sc.nextLine();
            if (Username.equals(userName)) {
                while (!isLogin) {
                    System.out.print("\nEnter Your Password - ");
                    String Password = sc.nextLine();
                    if (Password.equals(password)) {
                        System.out.print("\nLogin successful!!");
                        isLogin = true;
                    } else {
                        System.out.println("\nIncorrect Password");
                    }
                }
            } else {
                System.out.println("\nUsername not found");
            }
        }
        return isLogin;
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the withdrawal amount: ");
        float withdrawAmount = sc.nextFloat();
        if (balance >= withdrawAmount) {
            balance -= withdrawAmount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
            transactionHistory.add("Withdrawal of " + withdrawAmount);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the deposit amount: ");
        float depositAmount = sc.nextFloat();
        balance += depositAmount;
        System.out.println("Deposit successful. New balance: " + balance);
        transactionHistory.add("Deposit of " + depositAmount);
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the transfer amount: ");
        float transferAmount = sc.nextFloat();
        if (balance >= transferAmount) {
            balance -= transferAmount;
            System.out.println("Transfer successful. Remaining balance: " + balance);
            transactionHistory.add("Transfer of " + transferAmount);
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void transHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

public class BankAtm {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n**** WELCOME TO IDBI ATM ****\n");
        System.out.println("1.Register \n2.Exit");
        System.out.print("Enter Your Choice - ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            BankAccount b = new BankAccount();
            b.register();

            while (true) {
                System.out.println("\n1.Login \n2.Exit");
                System.out.print("Enter Your Choice - ");
                int ch = scanner.nextInt();

                if (ch == 1) {
                    if (b.login()) {
                        System.out.println("\n\n**********WELCOME BACK " + b.name + " **********\n");
                        boolean isFinished = false;

                        while (!isFinished) {
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.print("\nEnter Your Choice - ");
                            int c = scanner.nextInt();

                            switch (c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                                default:
                                    System.out.println("Invalid option selected!");
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}

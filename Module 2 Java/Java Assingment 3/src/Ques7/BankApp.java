package Ques7;


import java.util.*;

interface AccountManager{
    void addAccount(BankAccount acc);
    void depositMoney(String accNum, double amount);
    void withdrawMoney(String accNum, double amount);
    void transferMoney(String fromAcc, String toAcc, double amount);
    void displayCurrentBalance();
}

class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;
    BankAccount(String accountHolder, String accountNumber, double balance){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getAccountHolder(){
        return accountHolder;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if (amount > 0) balance += amount;
    }
    public boolean withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            return true;
        }
        return false;
    }
    public boolean transferTo(BankAccount receiver, double amount){
        if(withdraw(amount)){
            receiver.deposit(amount);
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return String.format("AccNo: %-12s Name; %-20s Balance: ₹%.2f",accountNumber, accountHolder, balance);
    }
}

class BankDatabase implements AccountManager {
    List<BankAccount> accounts = new ArrayList<>();

    @Override
    public void addAccount(BankAccount acc){
        accounts.add(acc);
        System.out.println("Account added for: " + acc.getAccountHolder());
    }
    @Override
    public void depositMoney(String accNum, double amount){
        BankAccount acc = findAccount(accNum);
        if (acc != null){
            acc.deposit(amount);
            System.out.println("₹" + amount + " deposited to " + acc.getAccountNumber());
        }else {
            System.out.println("Account Not found");
        }
    }

    public void withdrawMoney(String accNum, double amount){
        BankAccount acc = findAccount(accNum);
        if (acc != null){
            if (acc.withdraw(amount)){
                System.out.println("₹" + amount + " withdrawn from " + acc.getAccountNumber());
            }else{
                System.out.println("Insufficient Balance");
            }
        }else{
            System.out.println("Account not found.");
        }
    }

    @Override
    public void transferMoney(String fromAcc, String toAcc, double amount) {
        BankAccount sender = findAccount(fromAcc);
        BankAccount receiver = findAccount(toAcc);
        if (sender != null && receiver != null) {
            if (sender.transferTo(receiver, amount)) {
                System.out.println("₹" + amount + " transferred from " + sender.getAccountHolder() + " to " + receiver.getAccountHolder());
            } else {
                System.out.println("Transfer failed due to insufficient balance.");
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }
    @Override
    public void displayCurrentBalance() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts in database.");
        } else {
            for (BankAccount acc : accounts) {
                System.out.println(acc);
            }
        }
    }

    private BankAccount findAccount(String accNum) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNum)) return acc;
        }
        return null;
    }

}


public class BankApp {
    public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                BankDatabase bank = new BankDatabase();

                boolean running = true;

                while (running) {
                    System.out.println("\n--- Bank Account Management ---");
                    System.out.println("1.) Add New Account");
                    System.out.println("2.) Deposit Money");
                    System.out.println("3.) Withdraw Money");
                    System.out.println("4.) Transfer Money");
                    System.out.println("5.) Display All Accounts");
                    System.out.println("6.) Exit");
                    System.out.print("Choose: ");
                    int choice = sc.nextInt(); sc.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("Account Holder Name: ");
                            String holder = sc.nextLine();
                            System.out.print("Account Number: ");
                            String accNum = sc.nextLine();
                            System.out.print("Initial Balance: ₹");
                            double balance = sc.nextDouble(); sc.nextLine();
                            bank.addAccount(new BankAccount(holder, accNum, balance));
                            break;
                        case 2:
                            System.out.print("Account Number to Deposit: ");
                            accNum = sc.nextLine();
                            System.out.print("Amount to Deposit: ₹");
                            double depositAmt = sc.nextDouble(); sc.nextLine();
                            bank.depositMoney(accNum, depositAmt);
                            break;
                        case 3:
                            System.out.print("Account Number to Withdraw: ");
                            accNum = sc.nextLine();
                            System.out.print("Amount to Withdraw: ₹");
                            double withdrawAmt = sc.nextDouble(); sc.nextLine();
                            bank.withdrawMoney(accNum, withdrawAmt);
                            break;
                        case 4:
                            System.out.print("Sender Account Number: ");
                            String fromAcc = sc.nextLine();
                            System.out.print("Receiver Account Number: ");
                            String toAcc = sc.nextLine();
                            System.out.print("Amount to Transfer: ₹");
                            double transferAmt = sc.nextDouble(); sc.nextLine();
                            bank.transferMoney(fromAcc, toAcc, transferAmt);
                            break;
                        case 5:
                            bank.displayCurrentBalance();
                            break;
                        case 6:
                            running = false;
                            System.out.println("Exited!");
                            break;
                        default:
                            System.out.println("Invalid Input!");
                    }
                }
                sc.close();
    }
}

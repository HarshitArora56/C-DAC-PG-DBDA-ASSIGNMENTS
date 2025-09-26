package ConstructorChainingQues;

class BankAccount {
    long accountNumber;
    String holderName;
    int balance;

    BankAccount(long accountNumber){
        this.accountNumber = accountNumber;
        System.out.println("Constructor 1: Account Number Initialized...");

    }

    BankAccount(long accountNumber, String holderName){
        this(accountNumber);
        this.holderName = holderName;
        System.out.println("Constructor 2: Holder Name Initialized...");
    }

    BankAccount(long accountNumber, String holderName, int balance){
        this(accountNumber, holderName);
        this.balance = balance;
        System.out.println("Constructor 3: Balance Initialized...");
    }
    void display(){
        System.out.println("Account Details!");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + (holderName != null ? holderName : "N/A"));
        System.out.println("Balance: " + balance);
        System.out.println("-------------------------------");
    }
}

public class Ques5 {
    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount(987654321L);
        ba1.display();

        BankAccount ba2 = new BankAccount(123456789L, "Vedant");
        ba2.display();

        BankAccount ba3 = new BankAccount(654789321L, "Abhinav", 50000);
        ba3.display();

    }
}

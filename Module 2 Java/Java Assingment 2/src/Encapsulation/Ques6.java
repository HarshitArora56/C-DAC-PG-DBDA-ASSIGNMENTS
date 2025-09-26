package Encapsulation;

class BankAccount {
    private long accountNumber;
    private double balance;

    public void setAccountNumber(long accountNumber){
        this.accountNumber = accountNumber;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }

    public long getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }

}

public class Ques6 {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        b1.setAccountNumber(987654321L);
        b1.setBalance(80000);
        System.out.println("Account Number: " + b1.getAccountNumber());
        System.out.println("Balance: " + b1.getBalance());

    }
}

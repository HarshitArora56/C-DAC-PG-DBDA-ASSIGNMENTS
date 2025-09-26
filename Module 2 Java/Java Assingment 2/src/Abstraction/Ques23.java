package Abstraction;

abstract class Payment {
    double amount;
    Payment(double amount){
        this.amount = amount;
    }
    abstract void payAmount();
}
class CreditCardPayment extends Payment{

    CreditCardPayment(double amount){
        super(amount);
    }
    public void payAmount(){
        System.out.println("Payment processing via Credit Card for amount: " + amount);
    }
}
class UPIPayment extends Payment{

    UPIPayment(double amount){
        super(amount);
    }
    public void payAmount(){
        System.out.println("Payment processing via UPI for amount: " + amount);
    }
}
public class Ques23 {
    public static void main(String[] args) {
        Payment cc = new CreditCardPayment(525);
        cc.payAmount();
        Payment upi = new UPIPayment(840);
        upi.payAmount();
    }
}

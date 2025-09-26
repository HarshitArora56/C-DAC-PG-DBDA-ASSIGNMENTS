package Ques8;

import java.util.*;

class PaymentTimeOutException extends Exception {
    public PaymentTimeOutException(String message){
        super(message);
    }
}

class InvalidCardDetailsException extends RuntimeException {
    public InvalidCardDetailsException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) {
        super(message);
    }
}

class PaymentProcessor {
    public void processPayment(String cardNumber, double amount) throws PaymentTimeOutException, InsufficientFundsException {
        if(simulateTimeout()){
            throw new PaymentTimeOutException("Payment gateway timed out.");
        }
        if(!isValidCard(cardNumber)){
            throw new InvalidCardDetailsException("Invalid Card details provided.");
        }
        if(!hasSufficientFunds(cardNumber, amount)){
            throw new PaymentTimeOutException("Insufficient funds in account.");
        }
        System.out.println("Payment processed successfully.");
    }

    private boolean simulateTimeout() {
        return false;
    }
    private boolean isValidCard(String cardNumber){
        return cardNumber.startsWith("4");
    }
    private boolean hasSufficientFunds(String cardNumber, double amount){
        return amount <= 1000.0; //dummy threshold
    }
}
public class EcommApp {
    public static void main(String[] args){
        PaymentProcessor payment = new PaymentProcessor();
        try {
            payment.processPayment("4  234567890123456", 1500.0);

        }catch (PaymentTimeOutException e){
            System.err.println("Timeout: " + e.getMessage());
        }catch (InvalidCardDetailsException e){
            System.err.println("Card Error: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.err.println("Funds Error: " + e.getMessage());
        }finally {
            System.out.println("finally");
        }
    }
}

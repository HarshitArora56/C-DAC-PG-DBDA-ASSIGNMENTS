package ConstructorChainingQues;

class Order {
    int orderId;
    String customerName;
    int totalAmount;
    Order(int orderId){
        this.orderId = orderId;
        System.out.println("Constructor 1: OrderID Initialized...");
    }
    Order(int orderId, String customerName){
        this(orderId);
        this.customerName = customerName;
        System.out.println("Constructor 2: Customer Name Initialized...");
    }
    Order(int orderId, String customerName, int totalAmount){
        this(orderId, customerName);
        this.totalAmount = totalAmount;
        System.out.println("Constructor 3: Total Amount Initialized...");
    }
    void display(){
        System.out.println("Order Details!");
        System.out.println("Order Id: " + orderId);
        System.out.println("Customer Name: " + (customerName != null ? customerName : "N/A"));
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("-------------------------------");
    }
}
public class Ques4 {
    public static void main(String[] args) {
        Order o1 = new Order(101);
        o1.display();

        Order o2 = new Order(102, "Harshit");
        o2.display();

        Order o3 = new Order(103, "Yogesh", 2500);
        o3.display();
    }
}

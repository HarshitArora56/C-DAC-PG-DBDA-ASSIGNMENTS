package Ques2;
import java.util.*;

public class ShoppingCart {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String[] cart = {"Laptop" , "Headphones", "Mobile"};
        int[] prices = {80000, 10000, 25000};
        try{
            //Array index out of bounds
            System.out.print("Enter item index to view (0-2): ");
            int index = sc.nextInt();
            System.out.println("Item: " + cart[index] + ", Price: " + prices[index]);

            //NumberFormatException
            sc.nextLine();
            System.out.print("Enter Quantity as a number: ");
            String quantity = sc.nextLine();
            int quant = Integer.parseInt(quantity);

            //Arithmetic Exception

            System.out.print("Enter Discount percentage (0-100): ");
            int discount = sc.nextInt();
            int totalPrice = prices[index] * quant;
            int finalPrice = totalPrice/(100 - discount);
            System.out.println("Total price: " +  totalPrice + " Final Price: " + finalPrice);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid item index. Enter valid index (0-2)");
        }catch (NumberFormatException e){
            System.out.println("Quantity must be a valid number");
        }catch (ArithmeticException e){
            System.out.println("Discount can't be 100%.");
        }finally {
            System.out.println("Thank You for shopping with us.");
        }
    }
}

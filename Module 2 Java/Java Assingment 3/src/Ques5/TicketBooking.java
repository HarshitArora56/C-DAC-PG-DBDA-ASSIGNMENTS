package Ques5;
import java.util.*;

public class TicketBooking {
    public static void main(String[] args) {
        List<String> seats = Arrays.asList("A1","A2","A3","B1","B2");

        Scanner sc = new Scanner(System.in);

        try {
            //InputMismatchException
            System.out.print("Enter the number of Tickets: ");
            int numOfTickets = sc.nextInt(); sc.nextLine(); // Enter String as input to check the working of this exception

            //IllegalArgumentException
            if(numOfTickets <= 0) {
                throw new IllegalArgumentException("Number of Tickets can't be 0 or less than 0.");
            }

            //IndexOutOfBoundsException
            System.out.print("Enter seat index to view (0 to " + (seats.size() - 1) + "): ");
            int index = sc.nextInt(); sc.nextLine();//enter the index which is not accessible to check the handling
            System.out.println("Selected seat: " + seats.get(index));
            System.out.println("Ticket Booking Successful for " + numOfTickets + "Ticket(s).");
        }catch(InputMismatchException e) {
            System.err.println("Error: Please enter a valid number.");
        }catch(IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }catch(IndexOutOfBoundsException e) {
            System.err.println("Error: Please enter index in valid range.");
        }finally {
            sc.close();
            System.out.println("Thank You for using ticket booking system.");
        }

    }

}


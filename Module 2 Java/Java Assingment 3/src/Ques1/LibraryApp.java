package Ques1;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        LibraryManager library = new Library();
        Scanner in = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("\n--- Library Menu ---");
            System.out.println("1.) Add Book\n2.) Remove Book\n3.) Search Book\n4.) Display Books\n5.) Exit");
            System.out.print("Choose: ");
            int choice = in.nextInt(); in.nextLine();
            switch(choice){
                case 1:
                    System.out.print("Title: "); String title = in.nextLine();
                    System.out.print("Author: "); String author = in.nextLine();
                    System.out.println("ISBN (int): "); int isbn = in.nextInt();
                    library.addBook(new Book(title, author, isbn));
                    break;
                case 2:
                    System.out.print("ISBN to remove: "); isbn = in.nextInt(); in.nextLine();
                    library.removeBookByIsbn(isbn);
                    break;
                case 3:
                    System.out.println("Title to search: "); title = in.nextLine();
                    library.searchBookByTitle(title);
                    break;
                case 4:
                    library.displayAllBooks();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exited");
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
        in.close();
    }
}

package Ques1;

import java.util.ArrayList;

public class Library implements LibraryManager{
    protected ArrayList<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book Added!");
    }

    @Override
    public void removeBookByIsbn(int isbnNumber){
          boolean isRemoved = false;
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getIsbnNumber() == isbnNumber){
                books.remove(i);
                isRemoved = true;
                System.out.println("Book Removed!");
                break;
            }
        }
        if(!isRemoved){
            System.out.println("Book not found!");
        }
    }

    @Override
    public void searchBookByTitle(String title){
        for(Book b : books){
            if (b.getTitle().equalsIgnoreCase(title)){
                System.out.println("Found the Book:\n" + b);
                return;
            }
        }
        System.out.println("No match for the title!");
    }

    @Override
    public void displayAllBooks(){
        if(books.isEmpty()){
            System.out.println("No Books in Library!");
        }else{
            System.out.println("Library Collection");
            for(Book book : books){
                System.out.println(book);
            }
        }
    }
}

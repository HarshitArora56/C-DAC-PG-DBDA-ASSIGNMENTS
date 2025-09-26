package Ques1;

public interface LibraryManager {
    void addBook(Book book);
    void removeBookByIsbn(int isbnNumber);
    void searchBookByTitle(String title);
    void displayAllBooks();
}

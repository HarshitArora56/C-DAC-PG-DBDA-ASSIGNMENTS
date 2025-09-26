package Ques1;

public class DigitalLibrary extends Library{
    @Override
    public void addBook(Book book){
        int isbn = book.getIsbnNumber();
        while(isbn >= 10){
            isbn /= 10;
        }

        if (isbn == 9){
            super.addBook(book);
        }else{
            System.out.println("Only digital books (ISBN starting with 9) allowed.)");
        }
    }
}

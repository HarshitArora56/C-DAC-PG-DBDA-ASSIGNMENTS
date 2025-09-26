class Author {
    private String firstName;
    private String lastName;

    public Author (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String toString(){
        return getFirstName() + " " + getLastName();
    }
}

class Book {
    private String title;
    private Author author;
    private double price;

    public Book(String title, Author author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(Author author){
        this.author = author;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String getTitle(){
        return title;
    }
    public Author getAuthor(){
        return author;
    }
    public double getPrice(){
        return price;
    }

    public String toString(){
        return "Title: " + getTitle() + "\nAuthor: " + getAuthor() + "\nPrice: $" + getPrice();
    }

}

public class BookDemo {
    public static void main(String[] args) {
        Author author = new Author("Russel", "Winderand");
        Book book1 = new Book("Developing Java Software", author, 79.75);
        System.out.println(book1);
    }
}

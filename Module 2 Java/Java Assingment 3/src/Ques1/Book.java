package Ques1;

public class Book{
    private String title;
    private String author;
    private int isbnNumber;

    Book(String title, String author, int isbnNumber){
        this.title = title;
        this.author = author;
        this.isbnNumber = isbnNumber;
    }

    Book(int isbnNumber){
        this("Unknown", "Unknown", isbnNumber);
        this.isbnNumber = isbnNumber;

    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public int getIsbnNumber(){
        return isbnNumber;
    }

    @Override
    public String toString(){
        return String.format("Title: %-20s Author: %-15s ISBN: %d", title, author, isbnNumber);
    }
}
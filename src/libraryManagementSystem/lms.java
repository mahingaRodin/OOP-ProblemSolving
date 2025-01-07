package libraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

//initializing the book class
class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return  isIssued;
    }
}

//library class

class Library {
    private List<Book> books = new ArrayList<>();

    //library methods
    public void addBook(Book book) {
        books.add(book);
    }
    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equals(title));
    }
    public Book searchItem(String title) {
        for(Book book : books) {
            if(book.getTitle().equals(title) && !book.isIssued()) {
                return book;
            }
        }
        return  null;
    }
    //

    public void displayAllBooks() {
        for (Book book : books ) {
            if(!book.isIssued()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}

public class lms {
}

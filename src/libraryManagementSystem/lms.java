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

    public void setIssued(boolean issued) {
        isIssued = issued;
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

    public void displayAllBooks() {
        for (Book book : books ) {
            if(!book.isIssued()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}

class  User {
    private String name;
    private List<Book> issuedBooks = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void issuedBook(Book book) {
        issuedBooks.add(book);
        book.setIssued(false);
    }
    public void returnBook(Book book) {
        issuedBooks.remove(book);
        book.setIssued(false);
    }

    public void displayIssuedBooks() {
        System.out.println(name+"'s Issued Books: ");
        for(Book book: issuedBooks) {
            System.out.println(book.getTitle());
        }
    }

}

//adding the main class implementation
public class lms {
    public static void main(String[] args) {
        Library library = new Library();
        User user = new User("Bob");

        //adding books to the library
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));

        //displaying all books
        library.displayAllBooks();



    }
}

import java.util.ArrayList;

public class Member {
    //attributes for the member class. we set it to final to make it uchangeable
    private final String name;
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();

    //constructor for member class
    public Member(String name) {
        this.name = name;
    }
    //getter method to get the member name & returns the name value stored in the object
    public String getName() {
        return name;
    }
    //method to add book object to the borrowedBooks array list
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }
    //this method removes a book object from the borrowedBooks list when the member returns a borrowed book
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
    //method to display the member's details using toString()
    @Override
    public String toString() {
        return "Name: " + name + ", Borrowed Books: " + borrowedBooks;
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>(); //creates a list of books called books
    private final ArrayList<Member> members = new ArrayList<>(); //creates a list of members called members

    public void addBook(Scanner scanner) { //method to add book
        books.add(new Book( //creates a new book object & adds it to the books list
        //we used prompt medtod here to avoid repetition and makes it easier to ask the user for input
            prompt(scanner, "Enter book title: "),
            prompt(scanner, "Enter author name: "),
            prompt(scanner, "Enter ISBN: ")
        ));
        System.out.println("Book added successfully.");
    }

    public void registerMember(Scanner scanner) { //method to register a new member
        members.add(new Member(prompt(scanner, "Enter member name: "))); //creates new member object & add it to thr member list
        System.out.println("Member registered successfully.");
    }

    public void borrowBook(Scanner scanner) { //method to borrow book
        String memberName = prompt(scanner, "Enter member name: ");
        Member member = findMember(memberName); //checks if the member exists
        if (member == null) {
            System.out.println("Member not found."); //if the member does not exist, it prints an error message and returns
            return;
        }

        String bookTitle = prompt(scanner, "Enter book title to borrow: ");
        Book book = findBook(bookTitle); //this checks if the book exists
        //if the book is not found or is already borrowed, it will pribt a message
        if (book == null) {
            System.out.println("Book not found."); 
        } else if (!book.isAvailable()) { 
            System.out.println("Book is already borrowed.");
        } else {
            book.setAvailable(false); //if the book is available, it sets the book's availability to false & prints a message if the user decide to borrow the book
            member.borrowBook(book);
            System.out.println("Book borrowed successfully.");
        }
    }

    public void returnBook(Scanner scanner) { //method to return book
        String memberName = prompt(scanner, "Enter member name: ");
        Member member = findMember(memberName); //checks if the member exists
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        String bookTitle = prompt(scanner, "Enter book title to return: "); //asks the user for the book title to return
        Book book = findBook(bookTitle); //checks if the book exists
        //if the book is not found or is already returned, it will print a message
        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isAvailable()) {
            System.out.println("This book was not borrowed.");
        //if the book was borrowed, it marks it as available again and lets the member return the book
        } else {
            book.setAvailable(true);
            member.returnBook(book);
            System.out.println("Book returned successfully.");
        }
    }

    public void viewAvailableBooks() { //method to show the list of available books
        viewBooks(true, "Available Books:"); //helper method
    }

    public void viewBorrowedBooks() { //method to show the list of borrowed books
        viewBooks(false, "Borrowed Books:"); //helper method
    }

    public void viewMemberActivity() { //method to dispkay the summary of all members and their activity
        System.out.println("\nMember Activity Summary:");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    private String prompt(Scanner scanner, String message) { //method to asks the user for input
        System.out.print(message);
        return scanner.nextLine();
    }
    //method that searches for a book by its title
    private Book findBook(String title) {
        for (Book book : books) {
            //if it finds a match, it returns the book. if not, it will return null
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    //method that searches for a member by their name
    private Member findMember(String name) {
        for (Member member : members) {
            //if it finds a match, it returns the member. if not, it returns null
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }
    //method that displays a list of books based on whether they are available or borrowed
    private void viewBooks(boolean isAvailable, String header) {
        System.out.println("\n" + header); //this prints the given header and then shows all books that match the isAvailable condition
        for (Book book : books) {
            if (book.isAvailable() == isAvailable) {
                System.out.println(book);
            }
        }
    }
  }
  

public class Book {
    //attributes of the book cladss
    //we used private access modifier para magkaroon ng better control sa class attributes & method & para mas madali imaintain
    private final String title;
    private final String author;
    private final String isbn;
    private boolean available = true;

    //constructor for book class
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    //getter method & setter method
    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override //we used override here to replacs or override a method that already exists in the special class which is the object class
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Status: " + (available ? "Available" : "Borrowed");
    }
}

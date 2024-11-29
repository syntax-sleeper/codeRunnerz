import java.util.Scanner;

//entry point of our program
public class Main{ 
    public static void main(String[] args) {
        //we create an object scanner to read users input
        Scanner scanner = new Scanner(System.in);
        //we also create a library object thay will manage the books and the members in the system
        Library library = new Library();
        int choice; //we declare a choice variable w/ int data type since there are only 8 choices

        do { //do-while loopinh which will display the menu & process the user input 
            //iddisplay yung menu option ng library system
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add New Book");
            System.out.println("2. Register Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Available Books");
            System.out.println("6. View Borrowed Books");
            System.out.println("7. Member Activity Summary");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: "); //this line will ask the user to enter the number depending on their chosen activity
            choice = scanner.nextInt(); //this one is responsible for reading users input
            scanner.nextLine(); // consume newline

            switch (choice) { //maghahandle ng different menu option based sa value ng choice na ni-input
                case 1: library.addBook(scanner); //tatawag sa addBook method na nasa class na librsry
                case 2: library.registerMember(scanner); //tatawag sa method na registerMember to add new member
                case 3: library.borrowBook(scanner); //tatawag sa borrowBook method para makapagborrow ng book
                case 4: library.returnBook(scanner); //tatawag sa returnBook method pra makapagretun ng mga nahiram na books
                case 5: library.viewAvailableBooks(); //tatawag sa viewAvailableBooks method na id-display lahat ng available books
                case 6: library.viewBorrowedBooks(); //tatawag sa viewBorrowedBooks method na mags-show ng list ng lahat ng nahiram na books
                case 7: library.viewMemberActivity(); //ttawag sa vewMemberActivity method na id-display ang summary ng member activity like their names and so on.
                case 8: System.out.println("Exiting the system..."); //ip-print ang parameyer sa loob ng quotstion & also ending ng loop
                default: System.out.println("Invalid choice. Please try again."); //if the user input a number na wala sa option, id-display nya nasa loob ng double quotation
            }
        } while (choice != 8); //choice is not euqual to 8, as long as hindi pipiliin ng user ang option 8, magc-continue nang magc-continue ang loop

        scanner.close();
    }
              }

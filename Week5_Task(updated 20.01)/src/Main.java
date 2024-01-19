import Entities.Book;
import Entities.Library;
import Helpers.Helper;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Creating books
        //Automatic id given
        Book book1 = new Book("Kozetta", "Viktor Hugo", "French", 10, 5);
        Book book2 = new Book("Robinzon Kruzo", " Daniel Defoe'", "English", 16, 8);
        Book book3 = new Book("Robinzon Kruzo", " Daniel Defoe'", "English", 20, 8);
        Book book4 = new Book("Robinzon Kruzo", " Daniel Defoe'", "Engliaash", 20, 8);
        //Manually id given
        Book book5 = new Book(10,"Cinayet ve Ceza", "Fyodr Dostoyevski", "Russian", 10, 15);
        Book book6 = new Book(11,"Bakı bulvarı", "Chingiz Abdullayev", "Azerbaijani", 10, 20);

        // Creating a library and adding books
        Library library = new Library();
        library.AddBook(book1);
        library.AddBook(book2);
        library.AddBook(book3);
        library.AddBook(book4);
        library.AddBook(book5);
        library.AddBook(book6);
        // Adding a new book with the same name to the library
        Book newBook = new Book(11,"Bakı bulvarı", "Chingiz Abdullayev", "Azerbaijani", 10, 10);
        library.AddBook(newBook);

        Scanner scan=new Scanner(System.in);
        // Showing all books in the library


        while(true)
        {
            System.out.println("Please enter the name of the library: ");
            String libname=scan.nextLine();
            library.setName(libname);

            System.out.println("Hi! Welcome to our library:");
            System.out.println("Here is what we have: ");
            library.ShowBooks();
            //Menu

            while(true) {

                System.out.println("1. Add book");
                System.out.println("2. Update book");
                System.out.println("3. Delete book");
                System.out.println("4. Find book");
                System.out.println("5. Show books");
                System.out.println("6. Kitabxananin adini deyish");
                System.out.println("Novbeti emeliyyati sechin(7 for exiting): ");
                String choice = scan.nextLine();
                int input = Helper.tryParseInt(choice);

                switch (input) {
                    case 1:
                        System.out.println("Enter book details:");
                        System.out.print("Title: ");
                        String title = scan.nextLine();
                        System.out.print("Author: ");
                        String author = scan.nextLine();
                        System.out.print("Language: ");
                        String language = scan.nextLine();
                        System.out.print("Price: ");
                        int price = scan.nextInt();
                        System.out.print("Count: ");
                        int count = scan.nextInt();
                        //Automatically assigns new ID
                        Book newB = new Book(title, author, language, price, count);
                        library.AddBook(newB);

                        System.out.println("Book added successfully!");
                        break;
                    case 2:
                        System.out.println("Enter the book ID to update:");
                        int bookIdToUpdate = scan.nextInt();

                        Book bookToUpdate = library.FindBookById(bookIdToUpdate);

                        if (bookToUpdate != null) {
                            System.out.println("What do you want to update?");
                            System.out.println("1. Count");
                            System.out.println("2. Price");

                            int c = scan.nextInt();

                            switch (c) {
                                case 1:
                                    System.out.println("Enter the new count (only Integer):");
                                    int newCount = scan.nextInt();
                                    bookToUpdate.setCount(newCount);
                                    System.out.println("Count updated successfully!");
                                    break;

                                case 2:
                                    System.out.println("Enter the new price (only Integer):");
                                    int newPrice = scan.nextInt();
                                    bookToUpdate.setPrice(newPrice);
                                    System.out.println("Price updated successfully!");
                                    break;

                                default:
                                    System.out.println("Invalid choice.");
                                    break;
                            }
                        } else {
                            System.out.println("Book with ID " + bookIdToUpdate + " not found.");
                        }

                        break;



                    case 3:
                        // Delete book from library
                        System.out.println("Enter the book ID to delete:");
                        int bookIdToDelete = scan.nextInt();

                        library.DeleteBookById(bookIdToDelete);

                        break;

                    case 4:
                        //Find book and display info
                        //User can enter ID, Author, or name

                        System.out.println("Enter the details for searching(ID, Name or Author)");
                        String keyword=scan.nextLine();

                        Library foundBooks = library.FindBookByKeyword(keyword);

                        if (foundBooks != null) {
                            System.out.println("Book found. Here are the details:");
                            foundBooks.ShowBooks();
                        }
                        else {
                            System.out.println("Book with " + keyword + " not found.");
                        }
                        break;
                    case 5:
                        System.out.println("Books in Library:");
                        library.ShowBooks();
                        break;
                    case 6:
                        // Change library name
                        System.out.println("Enter the new library name:");
                        String newLibName = scan.nextLine();
                        library.setName(newLibName);
                        System.out.println("Library name updated successfully!");
                        break;
                    case 7:
                        System.out.println("Exiting the program. Goodbye!");
                        System.exit(0); // Exit the program
                        break;


                }
            }
            }
    }

}












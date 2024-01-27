package Entities;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Library {
    private String name;
    private ArrayList<Book> mybooks; //instead Book[] Array list is used

    public Library()
    {
        mybooks= new ArrayList<>();

    }

    public String trueName(String name) {
        String input = name;
        if (name.isEmpty() || name.isBlank()) {
            input = "Central";
        }

        return input;
    }

    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }


    public void AddBook(Book book1)
    {
        //Stream edib bir bir elementleri book tipinden goturduk
        //filter existingBook adli deyiseni vasitesile yoxlayir adi ve muellifi
        //bu existingBook mybooks library-de olanlardi
        // sonra tapandan sonra yene stream qaytarir bize
        //Qaytarilan streamde eger tapibsa bir kitab olacaq(1 ad ve muellifde)
        //findFirst() hemin kiatbi goturur() varsa
        //ifPresentOrElse kitab var ya yox varsa neylesin yoxdusa ne
        Optional<Book> existingBook=mybooks.stream().filter(book->book.getName().equals(book1.getName()) &&
                        book.getAuthor().equals(book1.getAuthor()))
               .findFirst();


        existingBook.ifPresentOrElse(
                book -> book.increaseCount(book1.getCount()),
                () -> mybooks.add(book1)
        );

    }


    public void ShowBooks() {
        if (mybooks == null || mybooks.isEmpty()) {
            System.out.println("The library is empty. No books to show.");
        } else {
            mybooks.forEach(Book::FullInfo);
        }
    }
    public Book FindBookById(int bookId) {
        return mybooks.stream()
                .filter(book -> book.getId()==bookId)
                .findFirst()// if found here returns Book
                .orElse(null);
    }

    //This is the updated
//    public Library FindBookByKeyword(String keyword, int select)
//    {
//        //We will collect the found ones here
//         Library foundBooks=new Library();
//         //Burada mybooks.stream() yazanda streamdan elementleri goturdu
//        //yeni Book tipinden .filter(neyi yoxlasin(Book tipinden booku)-> nece?)
//        //.filter() bize yeni bir stream qaytarir bu Library tipindendir
//        //.forEach() streamdaki her bir booku goturur bu actiondur
//        //Yeni neyleyir onun icinde yaziriq foundbooksun.Addbook metodu ile elave etsin
//         if (select==1)
//         {
//             Optional<Book> mybook=mybooks.stream().
//                     filter(book -> String.valueOf(book.getId()).equals(keyword)).
//                     findFirst();
//             mybook.ifPresent(book -> foundBooks.AddBook(book));
//         }
//         if (select==2)
//         {
//             mybooks.stream().
//                     filter(book -> book.getName().equals(keyword))
//                     .forEach(book -> foundBooks.AddBook(book));
//
//         }
//        if (select==3)
//        {
//            mybooks.stream().
//                    filter(book -> book.getAuthor().equals(keyword))
//                    .forEach(foundBooks::AddBook);
//        }
//        return foundBooks;
//    }
    public boolean isEmpty() {
        return mybooks == null || mybooks.isEmpty();
    }

    public Library findBooksById(String keyword) {
        Library foundBooks = new Library();
        Optional<Book> matchingBook = mybooks.stream()
                .filter(book -> String.valueOf(book.getId()).equals(keyword))
                .findFirst();

        matchingBook.ifPresent(foundBooks::AddBook);

        return foundBooks;
    }

    public Library findBooksByName(String keyword) {
        Library foundBooks = new Library();
        mybooks.stream()
                .filter(book -> book.getName().equals(keyword))
                .forEach(foundBooks::AddBook);

        return foundBooks;
    }

    public Library findBooksByAuthor(String keyword) {
        Library foundBooks = new Library();
        mybooks.stream()
                .filter(book -> book.getAuthor().equals(keyword))
                .forEach(foundBooks::AddBook);

        return foundBooks;
    }



    public void DeleteBookById(int bookId) {
        boolean check=mybooks.removeIf(book->book.getId()==bookId);
        System.out.println(check? "Book with ID "+bookId+ " deleted successfully!" :"Book with ID " + bookId + " not found.");
    }


}

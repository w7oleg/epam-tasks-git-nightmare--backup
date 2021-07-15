package classes.maintask.book;

import classes.maintask.book.objectandaction.Act;
import classes.maintask.book.objectandaction.Book;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static boolean add;

    public static void main(String[] args) {

        List<Book> books = createBook();
        System.out.println("BooK autor" + Act.booksByAuthor("Oleg", books));
        System.out.println("Book Publisher: " + Act.booksByPublisher("Minsk", books));
        System.out.println("Book Year: " + Act.booksAfterYear(1600, books));

    }

    // public Book(int id, String name, String author, String publishing, int year, int pages, int price, String type)
    private static List<Book> createBook() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "aaa", "Oleg", "Belarus", 1234, 32, 40, "h"));
        books.add(new Book(2, "ccc", "Dima", "Minsk", 1724, 39, 50, "s"));
        books.add(new Book(3, "bbb", "Oleg", "Gomel", 1864, 62, 60, "h"));
        books.add(new Book(4, "ddd", "Max", "Belarus", 1674, 932, 90, "s"));
        books.add(new Book(5, "mmm", "Lim", "Minsk", 1936, 325, 10, "h"));
        return books;
    }
}

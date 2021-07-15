package classes.maintask.book.objectandaction;

import java.util.ArrayList;
import java.util.List;

public class Act {
    public static List<Book> booksByAuthor(String author, List<Book> books) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            /*for (String authorBook : book.getAuthor())*/
            {
                if (author.equals(book.getAuthor())) {
                    result.add(book);
                }
            }
        }
        return result;
    }

    public static List<Book> booksByPublisher(String publisher, List<Book> books) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (publisher.equals(book.getPublishing())) {
                result.add(book);
            }
        }

        return result;
    }

    public static List<Book> booksAfterYear(int year, List<Book> books) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (year < book.getYear()) {
                result.add(book);
            }
        }

        return result;
    }
}

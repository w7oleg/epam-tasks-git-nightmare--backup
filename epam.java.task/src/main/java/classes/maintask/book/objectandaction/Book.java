package classes.maintask.book.objectandaction;

public class Book {
    private int id;
    private String name;
    private String author;
    private String publishing;
    private int year;
    private int pages;
    private int price;
    private String type;

    public Book(int id, String name, String author, String publishing, int year, int pages, int price, String type) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishing = publishing;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.type = type;
    }

    public Book() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Book:" +
                "id=" + id +
                ", name: " + name +
                ", author: " + author +
                ", publishing: " + publishing +
                ", year: " + year +
                ", pages: " + pages +
                ", price: " + price +
                ", type: " + type + "\n\t\t\t";
    }
}

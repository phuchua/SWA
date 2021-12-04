package books.domain;

public class Book {
    public String isbn;
    public String author;
    public String title;
    public double price;

    public Book() {
    }

    public Book(String isbn, String author, String title, double price) {
        super();
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ISBN: %s\nAuthor: %s\nTitle: %s\nPrice: %f",
                this.getIsbn(), this.getAuthor(), this.getTitle(), this.getPrice());
    }
}

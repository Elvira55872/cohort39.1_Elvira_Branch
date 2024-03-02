package dataModels;

public class Book {
    private String bookName;
    private Author author;
    public int bookNumber;

    public enum gerne{
        CLASSIC,
        DETECTIVE,
        LOVE_STORY,
        SCIENCE
    }

    public Book(String bookName, Author author, int bookNumber) {
        this.bookName = bookName;
        this.author = author;
        this.bookNumber = bookNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public Author getAuthor() {
        return author;
    }
}

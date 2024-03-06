package dataModels;

public class Book {
    private String bookName;
    private Author author;
    public int bookNumber;

    private enum gerne {
        CLASSIC,
        DETECTIVE,
        LOVE_STORY,
        SCIENCE
    }

    public Book(String bookName, Author author) {
        this.bookName = bookName;
        this.author = author;
        this.bookNumber = 0;
    }

    public String getBookName() {
        return bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public int getBookNumber() {
        return bookNumber;
    }
}

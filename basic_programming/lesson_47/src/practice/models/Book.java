package practice.models;

// Модель
public class Book {
    private Author author;
    private String title;
    private Genre genre;

    public Book(Author author, String title) {
        this.author = author;
        this.title = title;
    }

    public Book(Author author, String title, Genre genre) {
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;

        if (getAuthor() != null ? !getAuthor().equals(book.getAuthor()) : book.getAuthor() != null) return false;
        if (getTitle() != null ? !getTitle().equals(book.getTitle()) : book.getTitle() != null) return false;
        return getGenre() == book.getGenre();
    }

    @Override
    public int hashCode() {
        int result = getAuthor() != null ? getAuthor().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getGenre() != null ? getGenre().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                '}';
    }

    public enum Genre{
        CLASSIC,
        DETECTIVE,
        LOVE_STORY,
        SCIENCE;
    }
}

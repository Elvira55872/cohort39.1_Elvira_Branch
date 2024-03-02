package repositories;

import dataModels.Book;

import java.util.List;

public interface BookRepository {
    void addBook(Book book);
    Book getBookByNumber(int bookNumber);
    void removeBook(Book book);
    List<Book> findAllBooks();
}

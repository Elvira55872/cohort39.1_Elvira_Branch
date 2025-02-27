package repositories;

import dataModels.Book;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private List<Book> books;

    public BookRepositoryImpl(List<Book> books) {
        this.books = books;
    }

    @Override
    public void addBook(Book book) {
        if (books.contains(book)) {
            System.out.println("Book is already existing");
        } else {
            books.add(book);
        }
    }

    @Override
    public Book getBookByNumber(int bookNumber) {
        boolean containsBook = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookNumber() == bookNumber) {
                containsBook = true;
                return books.get(i);
            }
        }
        System.out.println("Book doesnt exist");
        return null;
    }

    @Override
    public void removeBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
        } else {
            System.out.println("This book is not existing");
        }
    }

    @Override
    public List<Book> findAllBooks() {
        return books;
    }
}

package practice.repositories;

import practice.interfaces.BookRepository;
import practice.models.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private List<Book> books;

    public BookRepositoryImpl() {
        books = new ArrayList<>();
    }

    public BookRepositoryImpl(Collection<Book> books) {
        this.books = new ArrayList<>(books);
    }

    @Override
    public void addBook(Book book) {
        if (books.contains(book)) {
            System.out.println("Данная книга уже есть в репозитории");
        } else {
            books.add(book);
            System.out.println("Книга " + book.toString() + " была успешно добавлена в книжный репозиторий");
        }
    }

    @Override
    public List<Book> findAllBooks() {
        return books;
    }

    @Override
    public boolean removeBook(Book book) {
        return books.remove(book);
    }
}

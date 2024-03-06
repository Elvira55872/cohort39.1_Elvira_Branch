package services;

import dataModels.Author;
import dataModels.Book;
import repositories.AuthorRepository;
import repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookService {
    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> findAllBooks(String name) {
        List<Book> bookList = new ArrayList<>();

        for (Book book : repository.findAllBooks()) {
            if (book.getBookName().contains(name)) {
                bookList.add(book);
            }
        }
        return bookList;
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAllBooks();
    }

    @Override
    public void addBook(Scanner scanner) {
        //stub
        //получаем данные о книге
        scanner.nextLine();
        System.out.println("Пожалуйста введите название книги:");
        String bookName = scanner.nextLine();
        // получаем данные об авторе и создаем автора
        System.out.println("Пожалуйста введите полное имя автора:");
        String authorName = scanner.nextLine();
        System.out.println("Пожалуйста год рождения автора:");
        int yearOfBirth = scanner.nextInt();
        // validation
        Author author = new Author(authorName, yearOfBirth);
        // создаем книгу
        Book book = new Book(bookName, author);
        repository.addBook(book);
    }
}

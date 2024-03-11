package practice;

import practice.interfaces.AuthorRepository;
import practice.interfaces.BookRepository;
import practice.interfaces.ReaderRepository;
import practice.repositories.AuthorRepositoryImpl;
import practice.repositories.BookRepositoryImpl;
import practice.repositories.ReaderRepositoryImpl;

public class StartLibraryApplication {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepositoryImpl();
        AuthorRepository authorService = new AuthorRepositoryImpl();
        ReaderRepository readerService = new ReaderRepositoryImpl();

        LibraryApplication app = new LibraryApplication(bookRepository, authorService, readerService);
        app.run();
    }
}

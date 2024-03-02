package practice.services;

import practice.interfaces.BookRepository;

//Слой бизнес-логики
public class BookService {
    private BookRepository bookRepository;

    // метод показа всех книг в библиотеке.
    // что для этого надо?
    // - иметь доступ к репозитоию с книгами
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}

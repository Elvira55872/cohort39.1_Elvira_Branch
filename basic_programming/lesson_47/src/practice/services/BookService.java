package practice.services;

import practice.interfaces.BookRepository;
import practice.models.Author;
import practice.models.Book;
import practice.repositories.BookRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Слой бизнес-логики
public class BookService {
    private BookRepository bookRepository;
    private AuthorService authorService;


    public BookService() {
        this.bookRepository = new BookRepositoryImpl();
    }
    // метод показа всех книг в библиотеке.
    // что для этого надо?
    // - иметь доступ к репозитоию с книгами
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    public List<Book> getAllBook() {
        return bookRepository.findAllBooks();
    }

    public List<Book> findBooksByTitle(String title) {
        List<Book> books = new ArrayList<>();

        for (Book book : getAllBook()) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                books.add(book);
            }
        }
        return books;
    }

    public List<Book> findBooksByAuthor(String authorName) {
        List<Book> books = new ArrayList<>();

        for (Book book : getAllBook()) {
            if (book.getAuthor().getName().toLowerCase()
                    .contains(authorName.toLowerCase())) {
                books.add(book);
            }
        }
        return books;
    }

    public List<Book> findBooksByGenre(Book.Genre genre) {
        List<Book> books = new ArrayList<>();

        for (Book book : getAllBook()) {
            if (book.getGenre() == genre) {
                books.add(book);
            }
        }
        return books;
    }

    public void removeBookByTitle(String title) {
        List<Book> books = findBooksByTitle(title);

        if (books.size() > 1) {
            System.out.println("уточните пожалуйста название книги, которую вы хотели бы удалить из репозитория, " +
                    "найдено несколько книг, удовлетворяющих вашему запросу: ");
            System.out.println(books);
        } else if (books.size() == 0) {
            System.out.println("В репозитории не найдено ни одной книги с таким названим " + title);
        } else {
            if (books.get(0).getTitle().equalsIgnoreCase(title)) {
                if (bookRepository.removeBook(books.get(0))) {

                    // проверяем, что книг этошго автора больше нет в книжном репозитории, если нет,
                    // то удаляем автора из репозитория авторов
                    if (findBooksByAuthor(books.get(0).getAuthor().getName()).size() == 0) {
                        authorService.removeAuthor(books.get(0).getAuthor());
                    }

                    System.out.println("Книга " + title + " была успешно удалена из репозитория");
                } else {
                    // todo: create custom exception class. Maybe some kind of Runtime?
                    // throw exception
                }
            } else {
                System.out.println("Книга с таким названием не была найдена в репозитории, возможно вы имели в виду " +
                        books.get(0).toString());
            }
        }
    }


    public void removeBookByAuthorName(String authorName) {
        List<Book> books = findBooksByTitle(authorName);

        if (books.size() > 1) {
            System.out.println("уточните пожалуйста имя автора, книгу которого  вы хотели бы удалить из репозитория, " +
                    "найдено несколько авторов, удовлетворяющих вашему запросу: ");
            System.out.println(books);
        } else if (books.size() == 0) {
            System.out.println("В репозитории не найдено ни одной книги этого автора " + authorName);
        } else {
            if (books.get(0).getAuthor().getName().equalsIgnoreCase(authorName)) {
                if (bookRepository.removeBook(books.get(0))) {

                    authorService.removeAuthor(books.get(0).getAuthor());

                    System.out.println("Книга автора " + authorName + " была успешно удалена из репозитория");
                } else {
                    // todo: create custom exception class. Maybe some kind of Runtime?
                    // throw exception
                }
            } else {
                System.out.println("Книга этого автора не была найдена в репозитории, возможно вы имели в виду " +
                        books.get(0).toString());
            }
        }
    }

    public Book addBook(Scanner scanner) {
        Book newBook = null;

        Author author = authorService.addAuthor(scanner);

        System.out.println("Пожалуйста введите полное название книги:");
        String title = scanner.nextLine();
        System.out.println("Пожалуйста выберите цифру для жанра:\n" +
                "1 - CLASSIC,\n" +
                "2 - DETECTIVE,\n" +
                "3 - LOVE_STORY,\n" +
                "4 - SCIENCE,\n" +
                "0 - без жанра");

        int genreNumber = Integer.parseInt(scanner.nextLine());

        switch (genreNumber) {
            case 1 -> newBook = new Book(author, title, Book.Genre.CLASSIC);
            case 2 -> newBook = new Book(author, title, Book.Genre.DETECTIVE);
            case 3 -> newBook = new Book(author, title, Book.Genre.LOVE_STORY);
            case 4 -> newBook = new Book(author, title, Book.Genre.SCIENCE);
            case 0 -> newBook = new Book(author, title);
        }

        bookRepository.addBook(newBook);

        return newBook;
    }
}

package practice;

import practice.interfaces.AuthorRepository;
import practice.interfaces.BookRepository;
import practice.interfaces.ReaderRepository;
import practice.models.Book;
import practice.repositories.AuthorRepositoryImpl;
import practice.repositories.BookRepositoryImpl;
import practice.repositories.ReaderRepositoryImpl;
import practice.services.AuthorService;
import practice.services.BookService;
import practice.services.ReaderService;

import java.util.List;
import java.util.Scanner;


// Слой представления
public class LibraryApplication {
    private final AuthorService authorService;
    private final BookService bookService;
    private final ReaderService readerService;
    private final Scanner scanner;

    public LibraryApplication() {
        this.bookService = new BookService();
        this.authorService = new AuthorService(bookService);
        this.readerService = new ReaderService();

        //stub
        this.bookService.setAuthorService(this.authorService);
        this.scanner = new Scanner(System.in);
    }

    public LibraryApplication(BookRepository bookRepository,
                              AuthorRepository authorRepository,
                              ReaderRepository readerRepository) {

        this.bookService = new BookService(bookRepository);
        this.authorService = new AuthorService(authorRepository, bookService);
        this.readerService = new ReaderService(readerRepository);


        //stub
        this.bookService.setAuthorService(this.authorService);
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("Добро пожаловать в систему управления библиотекой!");
            System.out.println("1. Показать список книг");
            System.out.println("2. Показать список авторов");
            System.out.println("3. Показать список читателей");
            System.out.println("4. Добавить новую книгу");
            System.out.println("5. Регистрация нового читателя");
            System.out.println("6. Добавить нового автора");
            System.out.println("0. Выход");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Вывести названия всех имеющихся книг или искать конкретную по:\n" +
                            "1 - имени автора\n" +
                            "2 - названию книги\n" +
                            "3 - жанру\n" +
                            "0 - все имеющиеся книги");

                    choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1:
                            System.out.println("Введите пожалуйста имя автора:");
                            String authorName = scanner.nextLine();
                            System.out.println("Список найденных книг:");
                            print(bookService.findBooksByAuthor(authorName));
                            break;
                        case 2:
                            System.out.println("Введите пожалуйста название книги:");
                            String title = scanner.nextLine();
                            System.out.println("Список найденных книг:");
                            print(bookService.findBooksByTitle(title));
                            break;
                        case 3:
                            print(bookService.findBooksByGenre(findGenre()));
                            break;
                        case 0:
                            print(bookService.getAllBook());
                    }
                    break;
                case 2:
                    System.out.println("Вывести всех авторов или искать по имени?");

                    if (scanner.nextLine().equals("1")) {
                        System.out.println(authorService.getAllAuthors());
                    } else {
                        System.out.println("введите имя автора");
                        String authorName = scanner.nextLine();
                        System.out.println(authorService.findAllAuthors(authorName));
                    }
                    break;
                case 3:
                    // Логика отображения списка читателей
                    break;
                case 4:
                    bookService.addBook(scanner);
                    break;
                case 5:
                    // Логика регистрации нового читателя
                    break;
                case 6:
                    authorService.addAuthor(scanner);
                    // Логика регистрации нового автора
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный ввод, попробуйте снова.");
            }
        }
    }

    public static void print(List list) {
        for (Object o : list) {
            System.out.println(o.toString());
        }
    }

    private Book.Genre findGenre() {
        System.out.println("Пожалуйста выберите цифру для жанра:\n" +
                "1 - CLASSIC,\n" +
                "2 - DETECTIVE,\n" +
                "3 - LOVE_STORY,\n" +
                "4 - SCIENCE,\n" +
                "0 - без жанра");

        int genreNumber = Integer.parseInt(scanner.nextLine());

        switch (genreNumber) {
            case 1 -> {return Book.Genre.CLASSIC;}
            case 2 -> {return Book.Genre.DETECTIVE;}
            case 3 -> {return Book.Genre.LOVE_STORY;}
            case 4 -> {return Book.Genre.SCIENCE;}
        }
        return null;
    }
}


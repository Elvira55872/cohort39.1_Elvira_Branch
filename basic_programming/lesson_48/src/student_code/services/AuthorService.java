package student_code.services;

import student_code.interfaces.AuthorRepository;
import student_code.models.Author;
import student_code.repository.AuthorRepositoryImpl;

import java.util.Scanner;
import java.util.Set;

/**
 * Это JavaDOC
 * <p>
 * AuthorService: Управление авторами, включая добавление новых авторов и обновление их данных.
 * <p>
 * Пишется на английском языке!!!
 * <p>
 * Нужно ответить на вопросы:
 * <p>
 * 1 - что это за класс?
 * <p>
 * 2 - для чего он используется?
 * (Пример: используется для взаимодействия с репозиторием для хранения записи обо всех авторах)
 * <p>
 * 3 - ка кон используется?
 * <p>
 * Если есть основной метод(main, validate или др), надо об этом указать.
 * <p>
 * Если этот класс активно взаимодействует с другими классами (у нас это CMSConsoleInterface
 * и 2 других класса-сервисов), надо это указать!
 */

public class AuthorService {
    private AuthorRepository repository;
    private final Scanner scanner;

    // 2 КОНСТРУКТОРА
    public AuthorService(AuthorRepository repository, Scanner scanner) {
        this.repository = repository;
        this.scanner = scanner;
    }

    public AuthorService(Scanner scanner) {
        repository = new AuthorRepositoryImpl();
        this.scanner = scanner;
    }

    public Author addAuthor() {
        String name = getUniqueName();
        if (name == null) {
            return null;
        }
        // тут логика на проверку правильности формата почты и ее уникальности
        // (решила не писать их и не перегружать код)
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Bio:");
        String bio = scanner.nextLine();

        Author author = new Author(name, email, bio);
        repository.addAuthor(author);

        return author;
    }

    private void delete(Author author) {
        if (repository.removeAuthor(author)) {
            System.out.println(author.toString() + "was successfully deleted");
        } else {
            System.out.println(author.toString() + "is not existing");
        }
    }

    public void deleteAuthor() {
        delete(findAuthor());
    }


    // МЕТОДЫ ДЛЯ ОБНОВЛЕНИЯ ДАННЫХ У СУЩЕСТВУЮЩИХ АВТОРОВ
    public void updateAuthor() {
        System.out.println("To update Author, first u need to select author: ");
        Author author = findAuthor();
        System.out.println("What u want to update:\n" +
                "1 - name\n" +
                "2 - email\n" +
                "3 - bio\n" +
                "0 - exit");
        int answer = scanner.nextInt();
        clearLine();

        if (answer == 1) {
            updateAuthorsName(author);
        } else if (answer == 2) {
            updateAuthorsEmail(author);
        } else if (answer == 3) {
            updateAuthorsBio(author);
        } else {
            return;
        }
    }

    // 3 метода с передачей автора в качестве аргумента
    //1
    public void updateAuthorsName(Author author) {
        String name = getUniqueName();
        // проверка на то, что новое имя отличается от старого
        if (name == null) {
            System.out.println("Name is not unique or the same as old name");
        } else {
            author.setName(name);
            System.out.println("Name successfully updated");
        }
    }

    //2
    public void updateAuthorsEmail(Author author) {
        // предположим тут проверка на уникальность почты
        System.out.println("New email:");
        String email = scanner.nextLine().trim();
        // проверка на то, что новый мэил отличается от старого
        if (!email.equals(author.getEmail())) {
            author.setEmail(email);
            System.out.println("Email successfully updated");
        } else {
            System.out.println("New Email is the sam as old Email");
        }
    }

    //3
    public void updateAuthorsBio(Author author) {
        System.out.println("New bio:");
        author.setBio(scanner.nextLine().trim());
        System.out.println("Bio successfully updated");
    }

    // МЕТОДЫ ДЛЯ ПОИСКА АВТОРОВ
    public Author findAuthor() {
        System.out.println("1 - find author by name\n"
                + "2 - find by ID\n"
                + "0 - exit");
        int answer = scanner.nextInt();
        clearLine();
        Author author = null;

        if (answer == 1) {
            System.out.println("Name: ");
            author = findAuthorByName(scanner.nextLine());
        } else if (answer == 2) {
            System.out.println("ID: ");
            author = findAuthorByID(scanner.nextInt());
            clearLine();
        }
        return author;
    }

    public Set<Author> findAllAuthors() {
        return repository.findAllAuthors();
    }

    public Author findAuthorByName(String name) {
        for (Author author : repository.findAllAuthors()) {
            if (author.getName().equalsIgnoreCase(name)) {
                return author;
            }
        }
        return null;
    }

    public Author findAuthorByID(int id) {
        for (Author author : repository.findAllAuthors()) {
            if (author.getID() == id) {
                return author;
            }
        }
        return null;
    }


    protected Author findAuthorForArticle() {
        System.out.println("Author name: ");
        Author author = findAuthorByName(scanner.nextLine());

        while (author == null) {
            System.out.println("Author with this name doesnt exist\n" +
                    "1 - try another name\n" +
                    "2 - register new user\n" +
                    "0 - exit");
            int answer = scanner.nextInt();
            clearLine();

            if (answer == 1) {
                System.out.println("Author name: ");
                author = findAuthorByName(scanner.nextLine());
            } else if (answer == 2) {
                author = addAuthor();
            } else {
                return null;
            }
        }
        return author;
    }

    // СИСТЕМНЫЕ МЕТОДЫ
    // метод для очищения строки после использования scanner.nextInt()
    private void clearLine() {
        scanner.nextLine();
    }

    private String getUniqueName() {
        System.out.println("Name:");
        String name = scanner.nextLine().toLowerCase();
        Author author = findAuthorByName(name);

        while (author != null) {
            System.out.println("Author with this name already exists");
            System.out.println("1 - try another name\n"
                    + "2 - exit");
            if (scanner.nextInt() == 1) {
                clearLine();
                System.out.println("Name:");
                name = scanner.nextLine();
                author = findAuthorByName(name);
            } else {
                return null;
            }
        }
        return name;
    }
}

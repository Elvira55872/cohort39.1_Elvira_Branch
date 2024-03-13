package student_code.services;

import student_code.interfaces.AuthorRepository;
import student_code.models.Author;
import student_code.repository.AuthorRepositoryImpl;

import java.util.Scanner;
import java.util.Set;

/**
 * Сервисный слой содержит бизнес-логику приложения и связывает пользовательский интерфейс с репозиториями:
 * AuthorService: Управление авторами, включая добавление новых авторов и обновление их данных.
 * <p>
 * Сервисный слой - это бэкэнд, который стоит между тем что видит клиент и базой данных
 * Нам надо "подружить" наши сервисы с репозиториями
 */
public class AuthorService {
    // нужно сказать сервису, откуда мы будем брать данные
    // для того чтобы не привязываться к низкоуровневой реализации (AuthorRepositiryIml),
    // мы возьмем абстракцию AuthorRepositiry
    private AuthorRepository repository;
    private final Scanner scanner; // он используется в методах ниже, сделала один чтобы не плодить сканеры в каждом методе

    // конструктор, который принимает какой-то репозиторий в качестве аргумента
    public AuthorService(AuthorRepository repository, Scanner scanner) {
        this.repository = repository;
        this.scanner = scanner;
    }

    // конструктор, который НЕ принимает репозиторий
    // в этом случае нам надо создать репозиторий
    public AuthorService(Scanner scanner) {
        repository = new AuthorRepositoryImpl();
        this.scanner = scanner;
    }

    public void addAuthor() {
        String name = getUniqueName();
        if (name == null) {
            return;
        }
        // тут логика на проверку правильности формата почты и ее уникальности
        // (решила не писать их и не перегружать код)
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Bio:");
        String bio = scanner.nextLine();

        repository.addAuthor(new Author(name, email, bio));
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
    // и я не знаю правильно ли в качестве аргумента передавать автора
    // или же надо в качестве аргумента передавать сразу новое значение ? (тут я даже не знаю как реализовать можно)
    // или делать это через сканнер ??
    // и делать это в отдельных методах для каждого поля или сделать 1 метод со свич кейсами? (этот вариант мне кажется громоздким и менее читабельным (BookService))

    public void updateAuthor() {
        Author author = findAuthor();
        System.out.println("To update:\n" +
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
    private Author findAuthor() {
        System.out.println("1 - find author by name\n"
                + "2 - find by ID\n"
                + "0 - exit");
        int answer = scanner.nextInt();
        scanner.nextLine();
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
            if (author.getName().equals(name)) {
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

    // СИСТЕМНЫЕ МЕТОДЫ
    // метод для очищения строки после использования scanner.nextInt()
    private void clearLine() {
        scanner.nextLine();
    }

    private String getUniqueName() {
        System.out.println("Name:");
        String name = scanner.nextLine();
        Author author = findAuthorByName(name);

        while (author != null) {
            System.out.println("Author with this name already exists");
            System.out.println("1 - try another name\n"
                    + "2 - exit");
            if (scanner.nextInt() == 1) {
                scanner.nextLine();
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

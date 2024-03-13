package student_code.services;

import student_code.interfaces.AuthorRepository;
import student_code.models.Article;
import student_code.models.Author;
import student_code.repository.AuthorRepositoryImpl;

import java.util.HashSet;
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
    private final Scanner scanner = new Scanner(System.in); // он используется в методах ниже, сделала один чтобы не плодить сканеры в каждом методе

    // конструктор, который принимает какой-то репозиторий в качестве аргумента
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    // конструктор, который НЕ принимает репозиторий
    // в этом случае нам надо создать репозиторий
    public AuthorService() {
        repository = new AuthorRepositoryImpl();
    }

    public void addAuthor(Scanner scanner) {
        System.out.println("Name:");
        String name = scanner.nextLine();

        // добавила проверку имени на уникальность, чтобы далее поиск автора по имени работал корректно и выдавал нужного автора
//!!!   //НО она не работает почему то ... текст из блока if не выходит при создании второго автора с таким же именем
        if (repository.equals(findAuthorByName(name))) {
            System.out.println("Author with this name already exists");
        } else {
            // todo: тут логика на проверку правильности формата почты и ее уникальности (решила не перегружать код)
            System.out.println("Email:");
            String email = scanner.nextLine();
            System.out.println("Bio:");
            String bio = scanner.nextLine();

            Author author = new Author(name, email, bio);
            repository.addAuthor(author);
        }
    }

    public void deleteAuthor(Author author) {
        if (repository.removeAuthor(author)) {
            System.out.println(author.toString() + "was successfully deleted");
        } else {
            System.out.println(author.toString() + "is not existing");
        }
    }

    // МЕТОДЫ ДЛЯ ОБНОВЛЕНИЯ ДАННЫХ У СУЩЕСТВУЮЩИХ АВТОРОВ
    // и я не знаю правильно ли в качестве аргумента передавать автора
    // или же надо в качестве аргумента передавать сразу новое значение ? (тут я даже не знаю как реализовать можно)
    // или делать это через сканнер ??
    // и делать это в отдельных методах для каждого поля или сделать 1 метод со свич кейсами? (этот вариант мне кажется громоздким и менее читабельным (BookService))

    // 3 метода с передачей автора в качестве аргумента
    //1
    public void updateAuthorsName(Author author) {
        System.out.println("New name:");
        String name = scanner.nextLine().trim();
        // проверка на то, что новое имя отличается от старого
        if (!name.equals(author.getName().toLowerCase())) {
            author.setName(name);
            System.out.println("Name successfully updated");
        } else {
            System.out.println("New name is the sam as old name");
        }
    }
//2
    public void updateAuthorsEmail(Author author) {
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
        System.out.println("New email:");
        String bio = scanner.nextLine().trim();
        // проверка на то, что новый bio отличается от старого
        if (!bio.equals(author.getBio())) {
            author.setBio(bio);
            System.out.println("Bio successfully updated");
        } else {
            System.out.println("New bio is the sam as old bio");
        }
    }

    // 3 метода без передачи автора в качестве аргумента
    //1
    public void updateAuthorsName(Scanner scanner) {
        System.out.println("Write author ID:");
        Author author = findAuthorByID(scanner.nextInt());
        scanner.nextLine();

        if (author == null) {
            System.out.println("Author with this ID doesnt exist");
        } else {
            System.out.println("Write new name:");
            author.setName(scanner.nextLine().trim());
        }
    }
//2
    public void updateAuthorsEmail(Scanner scanner) {
        System.out.println("Write author ID:");
        Author author = findAuthorByID(scanner.nextInt());
        scanner.nextLine();

        if (author == null) {
            System.out.println("Author with this ID doesnt exist");
        } else {
            System.out.println("Write new email:");
            author.setEmail(scanner.nextLine().trim());
        }
    }
//3
    public void updateAuthorsBio(Scanner scanner) {
        System.out.println("Write author ID:");
        Author author = findAuthorByID(scanner.nextInt());
        scanner.nextLine();

        if (author == null) {
            System.out.println("Author with this ID doesnt exist");
        } else {
            System.out.println("Write new BIO:");
            author.setBio(scanner.nextLine().trim());
        }
    }

    // МЕТОДЫ ДЛЯ ПОИСКА АВТОРОВ
    public Set<Author> findAllAuthors() {
        return repository.findAllAuthors();
    }

    public Author findAuthorByName(String name) {
        for(Author author : repository.findAllAuthors()){
            if(author.getName().equals(name)){
                return author;
            }
        }
        return null;
    }

        // еще одна реализация поиска по имени, с возвращением сета авторов

//    public Set<Author> findAuthorByName(String name) {
//        Set<Author> authorsByName = new HashSet<>();
//
//        for(Author author : repository.findAllAuthors()){
//            if(author.getName().equals(name)){
//                authorsByName.add(author);
//            }
//        }
//
//        return authorsByName;
//    }


    // при тестировании работы приложения поняла что неудобно искать автора по ID , тк мы не знаем ID
    // эта же проблема есть во всех остальных сервисах в методах поиска по ID объекта
    public Author findAuthorByID(int id){
        for(Author author : repository.findAllAuthors()){
            if(author.getID() == id){
                return author;
            }
        }
        return null;
    }
}

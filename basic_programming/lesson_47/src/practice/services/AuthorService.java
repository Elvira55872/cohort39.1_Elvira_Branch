package practice.services;

import practice.interfaces.AuthorRepository;
import practice.models.Author;
import practice.repositories.AuthorRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

// Слой бизнес-логики
public class AuthorService {
    private AuthorRepository repository;
    private BookService bookService;

    public AuthorService(BookService bookService) {
        repository = new AuthorRepositoryImpl();
        this.bookService = bookService;
    }

    public AuthorService(AuthorRepository repository, BookService bookService) {
        this.repository = repository;
        this.bookService = bookService;
    }

    public List<Author> findAllAuthors(String name) {
        List<Author> authorList = new ArrayList<>();

        for (Author author : repository.findAllAuthors()) {
            if (author.getName().toLowerCase().contains(name.toLowerCase())) {
                authorList.add(author);
            }
        }

        return authorList;
    }

    public List<Author> getAllAuthors() {
        return repository.findAllAuthors();
    }

    public Author addAuthor(Scanner scanner) {
        System.out.println("Пожалуйста введите полное имя автора:");
        String authorName = scanner.nextLine();
        System.out.println("Пожалуйста год рождения автора:");
        int yearOfBirth = Integer.parseInt(scanner.nextLine());
        // todo validation

        Author author = new Author(authorName, yearOfBirth);
        repository.addAuthor(author);

        return author;
    }

    public void removeAuthor(Author author) {
        if (repository.removeAuthor(author)) {
            System.out.println(author.toString() + " был успешно удален из репозитория");
        } else {
            System.out.println(author.toString() + " не был найден в репозитории");
        }
    }

    public void removeAuthor(String authorName) {
        List<Author> authors = findAllAuthors(authorName);

        if (authors.size() > 1) {
            System.out.println("уточните пожалуйста имя автора, которого вы хотели бы удалить из репозитория, " +
                    "найдено несколько авторов, удовлетворяющих вашему запросу: ");
            System.out.println(authors);
        } else if (authors.size() == 0) {
            System.out.println("В репозитории не найдено ни одного автора с именем " + authorName);
        } else {
            if (authors.get(0).getName().equalsIgnoreCase(authorName)) {
                if (repository.removeAuthor(authors.get(0))) {
                    // todo: удалить все книги этого автора!
                    System.out.println("автор " + authorName + " был успешно удален из репозитория");
                } else {
                    // throw exception
                }
            } else {
                System.out.println("Автор с таким именем не был найден в репозитории, возможно вы имели в виду " +
                        authors.get(0).toString());
                // возможное продолжение с да/нет
            }
        }
    }
}

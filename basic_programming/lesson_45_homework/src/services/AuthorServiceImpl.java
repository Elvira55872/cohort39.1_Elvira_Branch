package services;

import dataModels.Author;
import repositories.AuthorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Author> findAllAuthors(String name) {
        List<Author> authorList = new ArrayList<>();

        for (Author author : repository.findAllAuthors()) {
            if (author.getAuthorName().toLowerCase().contains(name.toLowerCase())) {
                authorList.add(author);
            }
        }

        return authorList;
    }

    @Override
    public List<Author> getAllAuthors() {
        return repository.findAllAuthors();
    }

    @Override
    public void addAuthor(Scanner scanner) {
        //stub
        scanner.nextLine();
        System.out.println("Пожалуйста введите полное имя автора:");
        String authorName = scanner.nextLine();
        System.out.println("Введите год рождения автора:");
        int yearOfBirth = scanner.nextInt();
        // validation

        Author author = new Author(authorName, yearOfBirth);
        repository.addAuthor(author);
    }
}

package services;

import dataModels.Author;

import java.util.List;
import java.util.Scanner;

public interface AuthorService {
    List<Author> findAllAuthors(String name);
    List<Author> getAllAuthors();
    void addAuthor(Scanner scanner);
}

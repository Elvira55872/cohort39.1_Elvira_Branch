package repositories;

import dataModels.Author;

import java.util.List;

public interface AuthorRepository {
    void addAuthor(Author author);
    void removeAuthor(Author author);
    List<Author> findAllAuthors();
}

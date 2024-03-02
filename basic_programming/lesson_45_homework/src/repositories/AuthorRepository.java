package repositories;

import dataModels.Author;

import java.util.List;

public interface AuthorRepository {
    void addAutor(Author author);
    void removeAutor(Author author);
    List<Author> findAllAuthors();
}

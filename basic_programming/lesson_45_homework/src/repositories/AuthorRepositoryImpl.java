package repositories;

import dataModels.Author;

import java.util.List;

public class AuthorRepositoryImpl implements AuthorRepository{
    private List<Author> authors;

    public AuthorRepositoryImpl(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public void addAuthor(Author author) {
        if (authors.contains(author)){
            System.out.println("Author is already existing");
        } else {
            authors.add(author);
        }
    }

    @Override
    public void removeAuthor(Author author) {
        if (authors.contains(author)){
            authors.remove(author);
        } else {
            System.out.println("This author is not existing");
        }
    }

    @Override
    public List<Author> findAllAuthors() {
        return authors;
    }
}

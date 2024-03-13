package student_code.repository;

import student_code.interfaces.AuthorRepository;
import student_code.models.Author;

import java.util.*;

public class AuthorRepositoryImpl implements AuthorRepository {
    private Set<Author> authors;

    public AuthorRepositoryImpl() {
        authors = new HashSet<>();
    }

    public AuthorRepositoryImpl(Collection<Author> authors) {
        this.authors = new HashSet<>(authors);
    }

    @Override
    public void addAuthor(Author author) {
        if (authors.contains(author)) {
            System.out.println("Author already exists");
        } else {
            authors.add(author);
        }
    }

    @Override
    public boolean removeAuthor(Author author) {
        return authors.remove(author);
    }

    @Override
    public Set<Author> findAllAuthors() {
        return authors;
    }
}

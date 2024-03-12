package practice.repository;

import student_code.interfaces.AuthorRepository;
import student_code.models.Author;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AuthorRepositoryIml implements AuthorRepository {
    private Set<Author> authors;

    public AuthorRepositoryIml() {
        authors = new HashSet<>();
    }

    public AuthorRepositoryIml(Collection<Author> authors) {
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

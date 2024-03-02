package services;

import dataModels.Author;
import practice.interfaces.AuthorRepository;

public class AuthorServiceImpl implements AuthorService{
    private AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }
}

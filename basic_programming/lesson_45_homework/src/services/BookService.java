package services;

import dataModels.Book;

import java.util.List;
import java.util.Scanner;

public interface BookService {
    List<Book> findAllBooks(String name);
    List<Book> getAllBooks();
    void addBook(Scanner scanner);
}

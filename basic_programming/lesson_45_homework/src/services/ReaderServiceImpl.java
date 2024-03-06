package services;

import dataModels.Reader;
import repositories.ReaderRepository;

import java.util.Scanner;

public class ReaderServiceImpl implements ReaderService {
    private ReaderRepository repository;

    public ReaderServiceImpl(ReaderRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addReader(Scanner scanner) {
        //stub
        System.out.println("Введите ваш email");
        String email = scanner.nextLine();
        System.out.println("Придумайте пароль");
        String password = scanner.nextLine();
        // validation
        Reader reader = new Reader(email, password);
        repository.addReader(reader);
    }
}

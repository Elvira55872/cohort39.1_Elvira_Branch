package practice.services;

import practice.interfaces.ReaderRepository;
import practice.models.Reader;
import practice.repositories.ReaderRepositoryImpl;

import java.util.Scanner;

// Слой бизнес-логики
public class ReaderService {

    private ReaderRepository repository;

    public ReaderService() {
        repository = new ReaderRepositoryImpl();
    }

    public ReaderService(ReaderRepository repository) {
        this.repository = repository;
    }

    public void registerReader(Scanner scanner) {
        System.out.println("введите пожалуйста email для регистрации:");
        String mail = scanner.nextLine();
        System.out.println("придумайте пожалуйста пароль:");
        String password = scanner.nextLine();

        if (findReader(mail) != null) {
            System.out.println("данный email уже существует в системе");
            System.out.println("Хотите ли восстановить пароль?");
        }

        // todo password and mail validation with regex
        // 8 syb min, min 1 digit, min 1 spec syb, min 1 in upper case and min 1 in lower case

        Reader reader = new Reader(mail, password);

        repository.registerReader(reader);
        System.out.println("Пользователь успешно зарегистророван");
    }

    public void removeReader(Scanner scanner) {
        System.out.println("введите пожалуйста email учетной записи, которую вы хотели бы удалить:");
        String mail = scanner.nextLine();
        System.out.println("введите пожалуйста пароль учетной записи, которую вы хотели бы удалить:");
        String password = scanner.nextLine();

        Reader reader = findReader(mail);

        if (reader == null) {
            System.out.println("Пользователя с такой учтной записью не существует в системе");
        }

        if (reader.getPassword().equals(password)) {
            if (repository.removeReader(reader)) {
                System.out.println("пользователь удален из системы");
            } else {
                // throw custom exception
            }
        }
    }

    public void updatePassword(Scanner scanner) {
        System.out.println("введите пожалуйста email учетной записи:");
        String mail = scanner.nextLine();
        System.out.println("введите пожалуйста старый пароль учетной записи:");
        String password = scanner.nextLine();

        Reader reader = findReader(mail);

        if (reader == null) {
            System.out.println("Пользователя с такой учетной записью не существует в системе");
        }

        if (reader.getPassword().equals(password)) {
            System.out.println("Введите пожалуйста новый пароль");
            String updatedPasswordFirstAttempt = scanner.nextLine();
            System.out.println("Введите пожалуйста повторите новый пароль");
            String updatedPasswordSecondAttempt = scanner.nextLine();

            if (updatedPasswordFirstAttempt.equals(updatedPasswordSecondAttempt)) {
                reader.setPassword(updatedPasswordFirstAttempt);
                System.out.println("Пароль был успешно обновлен");
            } else {
                System.out.println("Пароли отличаются");
            }
        } else {
            System.out.println("Вы ввели некорректный пароль");
        }
    }

    public Reader findReader(String mail) {
        for (Reader reader : repository.findAllReaders()) {
            if (reader.getMail().equalsIgnoreCase(mail)) {
                return reader;
            }
        }
        return null;
    }
}

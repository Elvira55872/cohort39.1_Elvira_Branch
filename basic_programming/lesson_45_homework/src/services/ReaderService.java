package services;

import java.util.Scanner;

public interface ReaderService {
    // мне кажется что тут кроме добавления нового читателя ничего не нужно
    // тк читатели не должны видеть других читателей
    // но это уже зависит от бизнес логики, является ли приложение социальным или нет
    void addReader(Scanner scanner);
}

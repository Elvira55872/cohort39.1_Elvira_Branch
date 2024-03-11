package practice;

import java.util.Scanner;

public class CMSConsoleInterface {
    private Scanner scanner;

    public CMSConsoleInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\nДобро пожаловать в систему управления контентом (CMS)!");
            System.out.println("1. Просмотреть список статей");
            System.out.println("2. Добавить новую статью");
            System.out.println("3. Добавить комментарий к статье");
            System.out.println("4. Выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Поглощаем остаток строки после числа

            switch (choice) {
                case 1:
                    viewArticles();
                    break;
                case 2:
                    addArticle();
                    break;
                case 3:
                    addComment();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private void viewArticles() {
        // Здесь будет логика для отображения списка статей
        System.out.println("Просмотр списка статей...");
    }

    private void addArticle() {
        // Здесь будет логика для добавления новой статьи
        System.out.println("Добавление новой статьи...");
    }

    private void addComment() {
        // Здесь будет логика для добавления комментария к статье
        System.out.println("Добавление комментария к статье...");
    }

    public static void main(String[] args) {
        CMSConsoleInterface cmsInterface = new CMSConsoleInterface();
        cmsInterface.start();
    }
}


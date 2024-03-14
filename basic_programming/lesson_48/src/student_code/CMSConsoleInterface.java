package student_code;

import student_code.services.ArticleService;
import student_code.services.AuthorService;
import student_code.services.CommentService;

import java.util.Scanner;

public class CMSConsoleInterface {
    private Scanner scanner;
    private final ArticleService articleService;
    private final AuthorService authorService;
    private final CommentService commentService;

    public CMSConsoleInterface() {
        this.scanner = new Scanner(System.in);

        this.articleService = new ArticleService(scanner);
        this.authorService = new AuthorService(scanner);
        this.commentService = new CommentService(scanner);

        // после добавления этой строки я смогла создать статью, без нее выходил NullPointerException
        this.articleService.setAuthorService(this.authorService);
        // без этой строки не могла добавить комментарий к статье, выходил NullPointerException
        this.articleService.setCommentService(this.commentService);
        // тоже проблемы без этого
        this.commentService.setAuthorService(this.authorService);
        this.commentService.setArticleService(this.articleService);
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\nДобро пожаловать в систему управления контентом (CMS)!");
            System.out.println("1. Добавить нового автора");
            System.out.println("2. Добавить новую статью");
            System.out.println("3. Добавить комментарий");
            System.out.println();
            System.out.println("4. Посмотреть список авторов");
            System.out.println("5. Просмотреть список статей");
            System.out.println();
            System.out.println("6. Все статьи определенного автора");
            System.out.println("7. Все комментарии определенного автора");
            System.out.println("8. Все комментарии к определенной статье");
            System.out.println();
            System.out.println("9. Обновить автора");
            System.out.println("10. Обновить статью");
            System.out.println("11. Обновить комментарий");
            System.out.println();
            System.out.println("12. Удалить автора");
            System.out.println("13. Удалить статью");
            System.out.println("14. Удалить комментарий");
            System.out.println();
            System.out.println("15. Выйти");
            System.out.println();
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Поглощаем остаток строки после числа

            switch (choice) {
                case 1 -> addAuthor();
                case 2 -> addArticle();
                case 3 -> addComment();

                case 4 -> viewAuthors();
                case 5 -> viewArticles();

                case 6 -> viewArticlesByAuthor();
                case 7 -> viewCommentsByAuthor();
                case 8 -> viewCommentsByArticle();

                case 9 -> updateAuthor();
                case 10 -> updateArticle();
                case 11 -> updateComment();

                case 12 -> removeAuthor();
                case 13 -> removeArticle();
                case 14 -> removeComment();

                case 15 -> running = false;
                default -> System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private void addAuthor() {
        System.out.println("Создание нового автора...");
        authorService.addAuthor();
    }

    private void addArticle() {
        System.out.println("Добавление новой статьи...");
        articleService.addArticle();
    }

    private void addComment() {
        System.out.println("Добавление комментария к статье...");
        commentService.addComment();
    }

    private void viewAuthors() {
        System.out.println("Список всех авторов: " + authorService.findAllAuthors());
    }

    private void viewArticles() {
        System.out.println("Список всех статей: " + articleService.findAllArticles());
    }

    private void viewArticlesByAuthor() {
        System.out.println("Статьи по автору: " + articleService.findArticlesByAuthor());
    }

    private void viewCommentsByAuthor() {
        System.out.println("Комментарии по автору: " + commentService.findCommentsByAuthor());
    }

    private void viewCommentsByArticle() {
        System.out.println("Комментарии по статье: " + commentService.findCommentsByArticle());

    }

    private void updateAuthor() {
        System.out.println("Обновление автора...");
        authorService.updateAuthor();
    }

    private void updateArticle() {
        System.out.println("Обновление статьи...");
        articleService.updateArticle();
    }

    private void updateComment() {
        System.out.println("Обновление комментария...");
        commentService.updateCommentText();
    }

    private void removeAuthor() {
        System.out.println("Удаление автора...");
        authorService.deleteAuthor();
    }

    private void removeArticle() {
        System.out.println("Удаление статьи...");
        articleService.deleteArticle();
    }

    private void removeComment() {
        System.out.println("Удаление комментария...");
        commentService.deleteComment();
    }

    public static void main(String[] args) {
        CMSConsoleInterface cmsInterface = new CMSConsoleInterface();
        cmsInterface.start();
    }
}


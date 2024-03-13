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

        this.articleService = new ArticleService();
        this.authorService = new AuthorService(scanner);
        this.commentService = new CommentService();

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
            System.out.println("1. Просмотреть список статей");
            System.out.println("2. Добавить новую статью");
            System.out.println("3. Добавить нового автора");
            System.out.println("4. Добавить комментарий к статье");
            System.out.println("5. Посмотреть список авторов");
            System.out.println("6. Посмотреть список статей по автору");
            System.out.println("7. Посмотреть список комментариев автора");
            System.out.println("8. Посмотреть список комментариев к статье");
            System.out.println("9. Удалить автора");
            System.out.println("10. Выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Поглощаем остаток строки после числа

            // todo : заменить swich-выражениями для большей читабельности (8 урок)
            switch (choice) {
                case 1:
                    viewArticles();
                    break;
                case 2:
                    addArticle();
                    break;
                case 3:
                    addAuthor();
                    break;
                case 4:
                    addComment();
                    break;
                // тут еще надо добавить удаление автора, статьи и комментария
                // и методы по изменению данных во всех 3х моделях
                // не прописала их тк уже и так много информации в которой легко запутаться
                case 5:
                    viewAuthors();
                    break;
                case 6:
                    viewArticlesByAuthor();
                    break;
                case 7:
                    viewCommentsByAuthor();
                    break;
                case 8:
                    viewCommentsByArticle();
                    break;
                case 9:
                    removeAuthor();
                    break;
                case 10:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private void removeAuthor() {
        authorService.deleteAuthor();
    }

    private void viewArticles() {
        // Здесь будет логика для отображения списка статей
        System.out.println("Просмотр списка статей..." + articleService.findAllArticles());
    }

    private void addArticle() {
        // Здесь будет логика для добавления новой статьи
        System.out.println("Добавление новой статьи...");
        articleService.addArticle(scanner);
    }

    private void addComment() {
        // Здесь будет логика для добавления комментария к статье
        System.out.println("Добавление комментария к статье...");
        commentService.addComment(scanner);
    }

    private void addAuthor() {
        // Здесь будет логика для создания автора
        System.out.println("Создание нового автора...");
        authorService.addAuthor();
    }


    // ниже методы которые я сама добавила
    private void viewAuthors() {
        System.out.println("Список всех авторов: " + authorService.findAllAuthors());
    }

    private void viewArticlesByAuthor() {
        System.out.println("Статьи по автору: " + articleService.findArticlesByAuthor(scanner));
    }

    private void viewCommentsByAuthor() {
        System.out.println("Комметарии по автору: " + commentService.findAllCommentsByAuthorsName(scanner));
    }

    private void viewCommentsByArticle() {
        System.out.println("Комметарии по статье: " + commentService.findAllCommentsByArticleTitel(scanner));

    }

    public static void main(String[] args) {
        CMSConsoleInterface cmsInterface = new CMSConsoleInterface();
        cmsInterface.start();
    }
}


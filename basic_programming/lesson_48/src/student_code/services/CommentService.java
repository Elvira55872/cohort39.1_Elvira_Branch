package student_code.services;

import student_code.interfaces.CommentRepository;
import student_code.models.Article;
import student_code.models.Author;
import student_code.models.Comment;
import student_code.repository.CommentRepositoryImpl;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//CommentService: Обработка комментариев, включая добавление к статьям, их поиск, обновление и удаление.

// ВОПРОС:
// "включая добавление к статьям" - нам надо сделать логику прикрепления сета комментариев к статье ?
// или вы имели в виду, что просто создать комментарий надо?
public class CommentService {
    private CommentRepository repository;
    private final Scanner scanner;

    // 2 поля ниже нужны для работы методов, тк комментарий привязан к автору и статье
    private AuthorService authorService;
    private ArticleService articleService;

    // 2 конструктора
    public CommentService(CommentRepository repository, Scanner scanner) {
        this.repository = repository;
        this.scanner = scanner;
    }

    public CommentService(Scanner scanner) {
        repository = new CommentRepositoryImpl();
        this.scanner = scanner;
    }

    // добавила этот метод, тк без него выходит NullPointerException при добавлении комментария в приложении
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }


    public void addComment() {
        System.out.println("To add comment, first u need to identify yourself as existing author!\n" +
                "What is your name?");

        Author author = authorService.findAuthorForArticle();
        if (author == null) {
            return;
        }

        Article article = articleService.findArticleForComment();
        if (article == null) {
            return;
        }

        System.out.println("Text of comment: ");
        String text = scanner.nextLine();

        repository.addComment(new Comment(article, text, author));
    }


    protected void delete(Comment comment) {
        if (repository.removeComment(comment)) {
            System.out.println(comment.toString() + "was successfully deleted");
        } else {
            System.out.println(comment.toString() + "is not existing");
        }
    }

    public void deleteComment() {
        delete(findComment());
    }

    // МЕТОД ДЛЯ ОБНОВЛЕНИЯ ДАННЫХ В СУЩЕСТВУЮЩЕМ КОММЕНТАРИИ
    // у комментария нельзя изменить автора или статью к которой он написан, поэтому меняем только текст коммента
    public void updateCommentText() {
        System.out.println("To update comment text, first u need to select comment: ");
        Comment comment = findComment();

        while (comment == null) {
            System.out.println("Comment doesnt exist\n" +
                    "1 - continue searching for comment\n" +
                    "0 - exit");
            int choise = scanner.nextInt();
            clearLine();

            if(choise == 1){
                System.out.println("To update comment text, first u need to select comment: ");
                comment = findComment();
            } else {
                return;
            }
        }

        System.out.println("Write new text:");
        comment.setText(scanner.nextLine());
    }

    // МЕТОДЫ ДЛЯ ПОИСКА КОММЕНТАРИЕВ
    public Set<Comment> findAllComments() {
        return repository.findAllComments();
    }

    public Comment findComment() {
        System.out.println("1 - find comment by Author\n"
                + "2 - find by text\n"
                + "3 - find by ID\n"
                + "4 - find by Article\n"
                + "0 - exit");
        int answer = scanner.nextInt();
        clearLine();
        Comment comment = null;

        if (answer == 1) {
            comment = findCommentByAuthor();
        } else if (answer == 2) {
            comment = findCommentByText();
        } else if (answer == 3) {
            System.out.println("Wtite ID of comment: ");
            comment = findCommentByID(scanner.nextInt());
            clearLine();
        } else if (answer == 4) {
            comment = findCommentByArticle();
        }
        return comment;
    }

    public Comment findCommentByID(int id) {
        for (Comment comment : repository.findAllComments()) {
            if (comment.getID() == id) {
                return comment;
            }
        }
        return null;
    }

    // 2 метода для поиска комментариев или 1 комментария по АВТОРУ
    public Set<Comment> findCommentsByAuthor() {
        System.out.println("To find comments by Author, first u need to select author: ");
        return repository.findAllAuthorComments(authorService.findAuthor());
    }

    public Comment findCommentByAuthor() {
        Set<Comment> commentsByAuthor = findCommentsByAuthor();

        System.out.println("Comments of serached Author: " + commentsByAuthor +
                "\nChoose needed comment by its ID: ");
        int id = scanner.nextInt();
        clearLine();

        return findCommentByID(id);
    }

    // 2 метода для поиска комментариев или 1 комментария по СТАТЬЕ
    public Set<Comment> findCommentsByArticle() {
        System.out.println("To find comments by article, first u need to select article: ");
        return repository.findAllArticleComments(articleService.findArticle());
    }

    protected Set<Comment> findCommentsByArticle(Article article) {
        return repository.findAllArticleComments(articleService.findArticle());
    }

    public Comment findCommentByArticle() {
        Set<Comment> commentsByArticle = findCommentsByArticle();

        System.out.println("Comments of serached article: " + commentsByArticle +
                "\nChoose needed comment by its ID: ");
        int id = scanner.nextInt();
        clearLine();
        return findCommentByID(id);
    }

    // 2 метода поиска комментария по его тексту
    public Set<Comment> findCommentsByText() {
        Set<Comment> commentsByText = new HashSet<>();
        System.out.println("Text of comment to find all comments with this text: ");
        String text = scanner.nextLine();

        for (Comment comment : repository.findAllComments()) {
            if (comment.getText().contains(text)) {
                commentsByText.add(comment);
            }
        }
        return commentsByText;
    }

    public Comment findCommentByText() {
        Set<Comment> commentsByText = findCommentsByText();

        System.out.println("Comments of serached text: " + commentsByText +
                "\nChoose needed comment by its ID: ");
        int id = scanner.nextInt();
        clearLine();
        return findCommentByID(id);
    }

    // СИСТЕМНЫЕ МЕТОДЫ
    // метод для очищения строки после использования scanner.nextInt()
    private void clearLine() {
        scanner.nextLine();
    }
}
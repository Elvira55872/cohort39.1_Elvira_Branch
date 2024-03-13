package student_code.services;

import student_code.interfaces.CommentRepository;
import student_code.models.Article;
import student_code.models.Author;
import student_code.models.Comment;
import student_code.repository.CommentRepositoryImpl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//CommentService: Обработка комментариев, включая добавление к статьям, их поиск, обновление и удаление.

// ВОПРОС:
// "включая добавление к статьям" - нам надо сделать логику прикрепления сета комментариев к статье ?
// или вы имели в виду, что просто создать комментарий надо?
public class CommentService {
    private CommentRepository repository;

    // 2 поля ниже нужны для работы методов, тк комментарий привязан к автору и статье
    private AuthorService authorService;
    private ArticleService articleService;

    // 2 конструктора
    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    public CommentService() {
        repository = new CommentRepositoryImpl();
    }

    // добавила этот метод, тк без него выходит NullPointerException при добавлении комментария в приложении
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }


    public void addComment(Scanner scanner) {
        // ранее тут был поиск автора по ID, но при использовании приложения невозможно знать ID статьи или автора
        System.out.println("Author name:");
        Author author = authorService.findAuthorByName(scanner.nextLine());

        // ранее тут был поиск автора по ID, но при использовании приложения невозможно знать ID статьи или автора
        System.out.println("Article titel:");
        Article article = articleService.findArticlesByTitel(scanner.nextLine());

        System.out.println("Text of comment:");
        String text = scanner.nextLine();

        repository.addComment(new Comment(article, text, author));
    }

    public void deleteComment(Comment comment) {
        if (repository.removeComment(comment)) {
            System.out.println(comment.toString() + "was successfully deleted");
        } else {
            System.out.println(comment.toString() + "is not existing");
        }
    }


    // МЕТОД ДЛЯ ОБНОВЛЕНИЯ ДАННЫХ В СУЩЕСТВУЮЩЕМ КОММЕНТАРИИ
    // у комментария нельзя изменить автора или статью к которой он написан, поэтому меняем только текст коммента
    public void updateCommentText(Scanner scanner) {
        System.out.println("Write comment ID:");
        Comment comment = findCommentByID(scanner.nextInt());
        scanner.nextLine();

        if (comment == null) {
            System.out.println("Article with this ID doesnt exist");
        } else {
            System.out.println("Write new titel:");
            comment.setText(scanner.nextLine());
        }
    }

    // МЕТОДЫ ДЛЯ ПОИСКА КОММЕНТАРИЕВ
    public Set<Comment> findAllComments() {
        return repository.findAllComments();
    }

    public Comment findCommentByID(int id) {
        for (Comment comment : repository.findAllComments()) {
            if (comment.getID() == id) {
                return comment;
            }
        }
        return null;
    }

    // наверное этот метод не получится использовать из самого приложения, тк не понятно как передать автора
    // после этого метода есть переписанный метод со сканером
    public Set<Comment> findAllCommentsByAuthor(Author author) {
        Set<Comment> commentsByAuthor = new HashSet<>();

        for (Comment comment : repository.findAllComments()) {
            if (comment.getAuthor().equals(author)) {
                commentsByAuthor.add(comment);
            }
        }
        return commentsByAuthor;
    }

    public Set<Comment> findAllCommentsByAuthorsName(Scanner scanner) {
        Set<Comment> commentsByAuthorName = new HashSet<>();
        System.out.println("Write authors name to find all his comments: ");
        Author author = authorService.findAuthorByName(scanner.nextLine().trim());

        for (Comment comment : repository.findAllComments()) {
            if (comment.getAuthor().equals(author)) {
                commentsByAuthorName.add(comment);
            }
        }
        return commentsByAuthorName;
    }

    // наверное этот метод не получится использовать из самого приложения, тк не понятно как передать статью
    // после этого метода есть переписанный со сканером
    public Set<Comment> findAllCommentsByArticle(Article article) {
        Set<Comment> commentsByArticle = new HashSet<>();

        for (Comment comment : repository.findAllComments()) {
            if (comment.getArticle().equals(article)) {
                commentsByArticle.add(comment);
            }
        }
        return commentsByArticle;
    }

    public Set<Comment> findAllCommentsByArticleTitel(Scanner scanner) {
        Set<Comment> commentsByArticle = new HashSet<>();
        Article article = articleService.findArticlesByTitel(scanner);

        for (Comment comment : repository.findAllComments()) {
            if (comment.getArticle().equals(article)) {
                commentsByArticle.add(comment);
            }
        }
        return commentsByArticle;
    }


}

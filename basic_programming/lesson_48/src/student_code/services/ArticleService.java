package student_code.services;

import student_code.interfaces.ArticleRepository;
import student_code.models.Article;
import student_code.models.Author;
import student_code.repository.ArticleRepositoryImpl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//ArticleService: Логика работы со статьями, включая создание, поиск по критериям, обновление и удаление.
public class ArticleService {
    private ArticleRepository repository;

    // ниже 2 объекта нужны для работы методов, тк статьи имеют авторов и комментарии
    private AuthorService authorService;
    private CommentService commentService;

    // 2 конструктора
    public ArticleService() {
        repository = new ArticleRepositoryImpl();
    }

    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    // добавила эти 2 метода, тк без них выходит NullPointerException при добавлении статьи и комментария в приложении
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }
    public void setCommentService (CommentService commentService){
        this.commentService = commentService;
    }

    public void addArticle(Scanner scanner) {
        System.out.println("Title:");
        String title = scanner.nextLine();

        System.out.println("Content:");
        String content = scanner.nextLine();

        // по ID у меня не получилось найти автора, попробую сделать через поиск по имени

//        System.out.println("Author ID:");
//        Author author = authorService.findAuthorByID(scanner.nextInt());

        // поиск по имени
        System.out.println("Author name:");
        Author author = authorService.findAuthorByName(scanner.nextLine());

        repository.addArticle(new Article(title, content, author));
    }

    public void deleteArticle(Article article) {
        if (repository.removeArticle(article)) {
            System.out.println(article.toString() + "was successfully deleted");
        } else {
            System.out.println(article.toString() + "is not existing");
        }
    }

    // МЕТОДЫ ДЛЯ ОБНОВЛЕНИЯ ДАННЫХ В СУЩЕСТВУЮЩЕЙ СТАТЬЕ
    // попробую сделать методы для ИЗМЕНЕНИЯ СТАТЬИ без передачи статьи в качестве аргумента (как это было с автором)
    public void updateArticleTitle(Scanner scanner) {
        System.out.println("Write article ID:");
        Article article = findArticleByID(scanner.nextInt());
        scanner.nextLine();

        if (article == null) {
            System.out.println("Article with this ID doesnt exist");
        } else {
            System.out.println("Write new titel:");
            article.setTitle(scanner.nextLine().trim());
        }
    }

    public void updateArticleContent(Scanner scanner) {
        System.out.println("Write article ID:");
        Article article = findArticleByID(scanner.nextInt());
        scanner.nextLine();

        if (article == null) {
            System.out.println("Article with this ID doesnt exist");
        } else {
            System.out.println("Write new content:");
            article.setContent(scanner.nextLine());
        }
    }

    // у статьи нельзя изменить автора, так решили ранее

    // МЕТОДЫ ДЛЯ ПОИСКА СТАТЕЙ
    public Set<Article> findAllArticles() {
        return repository.findAllArticles();
    }

    public Article findArticleByID(int id) {
        for (Article article : repository.findAllArticles()) {
            if (article.getID() == id) {
                return article;
            }
        }
        return null;
    }

    // ниже 3 метода по поиску статьи по заголовку :

//    public Set<Article> findArticlesByTitel(String titel) {
//        Set<Article> articlesByTitel = new HashSet<>();
//
//        for (Article atricle : repository.findAllArticles()) {
//            // сделала через .contains() чтобы найти все статьи с таим словом/фразой
//            // тк titel не уникальный, выдавать конкретную статью нелогично на мой взгляд
//            if (atricle.getTitle().contains(titel.trim())) {
//                articlesByTitel.add(atricle);
//            }
//        }
//        return articlesByTitel;
//    }

    public Article findArticlesByTitel(String titel) {
        for (Article atricle : repository.findAllArticles()) {
            if (atricle.getTitle().equals(titel.trim())) {
                return atricle;
            }
        }
        return null;
    }

// дописала этот метод чтобы работало public Set<Comment> findAllCommentsByArticleTitel(Scanner scanner) в классе CommentService
    public Article findArticlesByTitel(Scanner scanner) {
        System.out.println("Write titel of article to find its comments: ");
        String titel = scanner.nextLine();

        for (Article atricle : repository.findAllArticles()) {
            if (atricle.getTitle().equals(titel.trim())) {
                return atricle;
            }
        }
        return null;
    }

    public Set<Article> findArticlesByAuthor(Scanner scanner){
        Set<Article> articlesByAuthor = new HashSet<>();
        System.out.println("Write author name to find his articles");
        String authorName = scanner.nextLine();
        Author author = authorService.findAuthorByName(authorName);
        for (Article article: repository.findAllArticles()){
            if (article.getAuthor().equals(author)){
                articlesByAuthor.add(article);
            }
        }
        return articlesByAuthor;
    }
}

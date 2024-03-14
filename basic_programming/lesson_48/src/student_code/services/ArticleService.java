package student_code.services;

import student_code.interfaces.ArticleRepository;
import student_code.models.Article;
import student_code.models.Author;
import student_code.repository.ArticleRepositoryImpl;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//ArticleService: Логика работы со статьями, включая создание, поиск по критериям, обновление и удаление.
public class ArticleService {
    private ArticleRepository repository;
    private final Scanner scanner;

    // ниже 2 объекта нужны для работы методов, тк статьи имеют авторов и комментарии
    private AuthorService authorService;
    private CommentService commentService;

    // 2 конструктора
    public ArticleService(Scanner scanner) {
        repository = new ArticleRepositoryImpl();
        this.scanner = scanner;
    }

    public ArticleService(ArticleRepository repository, Scanner scanner) {
        this.repository = repository;
        this.scanner = scanner;
    }

    // добавила эти 2 метода, тк без них выходит NullPointerException при добавлении статьи и комментария в приложении
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public void addArticle() {
        System.out.println("Title: ");
        String title = scanner.nextLine();

        System.out.println("Content: ");
        String content = scanner.nextLine();

        System.out.println("Author name: ");
        Author author = authorService.findAuthorByName(scanner.nextLine().toLowerCase());
        // логика не позволяющая создать статью с автором null
        while (author == null) {
            System.out.println("Author with this name doesnt exist\n" +
                    "1 - try another name\n" +
                    "0 - exit");
            int answer = scanner.nextInt();
            clearLine();

            if (answer == 1) {
                System.out.println("Author name: ");
                author = authorService.findAuthorByName(scanner.nextLine().toLowerCase());
            } else {
                return;
            }
        }

        repository.addArticle(new Article(title, content, author));
    }

    public void delete(Article article) {
        if (repository.removeArticle(article)) {
            System.out.println(article.toString() + "was successfully deleted");
        } else {
            System.out.println(article.toString() + "is not existing");
        }
    }

    public void deleteArticle() {
        delete(findArticle());
    }

    // МЕТОДЫ ДЛЯ ОБНОВЛЕНИЯ ДАННЫХ В СУЩЕСТВУЮЩЕЙ СТАТЬЕ
    public void updateArticle() {
        System.out.println("To update article, first u need to find article which u want to update");
        Article article = findArticle();

        System.out.println("What u want to update:\n" +
                "1 - titel\n" +
                "2 - content\n" +
                "0 - exit");
        int answer = scanner.nextInt();
        clearLine();

        if (answer == 1) {
            updateArticleTitle(article);
        } else if (answer == 2) {
            updateArticleContent(article);
        } else {
            return;
        }
    }

    public void updateArticleTitle(Article article) {
        if (article == null) {
            System.out.println("Article with this ID doesnt exist");
        } else {
            System.out.println("Write new titel:");
            article.setTitle(scanner.nextLine().trim());
            System.out.println("Titel of article" + article + "successfully updated");
        }
    }

    public void updateArticleContent(Article article) {
        if (article == null) {
            System.out.println("Article with this ID doesnt exist");
        } else {
            System.out.println("Write new content:");
            article.setContent(scanner.nextLine());
            System.out.println("Content of article" + article + "successfully updated");
        }
    }

    // у статьи нельзя изменить автора, так решили ранее


    // МЕТОДЫ ДЛЯ ПОИСКА СТАТЕЙ
    public Set<Article> findAllArticles() {
        return repository.findAllArticles();
    }

    public Article findArticle() {
        System.out.println("1 - find article by titel\n"
                + "2 - find by content\n"
                + "3 - find by ID\n"
                + "0 - exit");
        int answer = scanner.nextInt();
        clearLine();
        Article article = null;

        if (answer == 1) {
            article = findArticleByTitel();
        } else if (answer == 2) {
            article = findArticleByContent();
        } else if (answer == 3) {
            article = findArticleByID();
        } else {
            return null;
        }
        return article;
    }

    // только 1 метод поиска по ID, тк ID уникальный
    public Article findArticleByID() {
        System.out.println("Write ID to get article: ");
        int ID = scanner.nextInt();
        clearLine();

        for (Article article : repository.findAllArticles()) {
            if (article.getID() == ID) {
                return article;
            }
        }

        return null;
    }

    // ниже 2 метода для поиска статей или 1 статьи по АВТОРУ
    public Set<Article> findArticlesByAuthor() {
        System.out.println("To find articles by Author, first u need to select author: ");
        return repository.findAllArticlesByAuthor(authorService.findAuthor());
    }

    public Article findArticleByAuthor() {
        Set<Article> articlesByAuthor = repository.findAllArticlesByAuthor(authorService.findAuthor());

        System.out.println("Articles of searched Author: " + articlesByAuthor);

        return findArticleByID();
    }

    // ниже 2 метода для поиска статей или 1 статьи по тексту в статье
    public Set<Article> findArticlesByContent() {
        Set<Article> articlesByContent = new HashSet<>();
        System.out.println("Write content to search for article: ");
        String content = scanner.nextLine();

        for (Article atricle : repository.findAllArticles()) {
            // сделала через .contains() чтобы найти все статьи с таким словом/фразой
            if (atricle.getContent().contains(content)) {
                articlesByContent.add(atricle);
            }
        }

        return articlesByContent;
    }

    public Article findArticleByContent() {
        Set<Article> articlesByContent = findArticlesByContent();

        System.out.println("Articles with serched content: " + articlesByContent);

        return findArticleByID();
    }

    // ниже 2 метода для поиска статей или 1 статьи по заголовку

    public Set<Article> findArticlesByTitel() {
        Set<Article> articlesByTitel = new HashSet<>();

        System.out.println("Write titel to search articles: ");
        String titel = scanner.nextLine();

        for (Article atricle : repository.findAllArticles()) {
            if (atricle.getTitle().contains(titel.trim())) {
                articlesByTitel.add(atricle);
            }
        }

        return articlesByTitel;
    }

    public Article findArticleByTitel() {
        Set<Article> articlesByTitel = findArticlesByTitel();

        System.out.println("Articles with serached titel: " + articlesByTitel);

        return findArticleByID();
    }

    // СИСТЕМНЫЕ МЕТОДЫ
    // метод для очищения строки после использования scanner.nextInt()
    private void clearLine() {
        scanner.nextLine();
    }
}


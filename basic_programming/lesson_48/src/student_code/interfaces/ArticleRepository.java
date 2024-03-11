package student_code.interfaces;

import student_code.models.Article;
import student_code.models.Author;

import java.util.Set;

// Управление статьями (добавление, поиск, обновление, удаление)
public interface ArticleRepository {
    void addArticle(Article article);

    boolean removeArticle(Article article);

    Set<Article> findAllArticles();

    Set<Article> findAllArticlesByAuthor(Author author);
}

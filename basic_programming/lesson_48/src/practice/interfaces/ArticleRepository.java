package practice.interfaces;



import practice.models.Article;
import practice.models.Author;

import java.util.Set;

// Управление статьями (добавление, поиск, обновление, удаление)
public interface ArticleRepository {
    void addArticle(Article article);

    boolean removeArticle(Article article);

    Set<Article> findAllArticles();

    Set<Article> findAllArticlesByAuthor(Author author);
}

package student_code.interfaces;

import student_code.models.Article;

import java.util.List;

// Управление статьями (добавление, поиск, обновление, удаление)
public interface ArticleRepository {
    void addArticle(Article article);

    boolean removeArticle(Article article);

    List<Article> findAllArticles();
}

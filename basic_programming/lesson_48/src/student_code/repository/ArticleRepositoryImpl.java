package student_code.repository;

import student_code.interfaces.ArticleRepository;
import student_code.models.Article;
import student_code.models.Author;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArticleRepositoryImpl implements ArticleRepository {
    private Set<Article> articles;
    private Map<Author,Set<Article>> allArliclesOfAuthor;

    public ArticleRepositoryImpl() {
        articles = new HashSet<>();
        allArliclesOfAuthor = new HashMap<>();
    }

    @Override
    public void addArticle(Article article) {
        Author author = article.getAuthor();

        Set<Article> temp = allArliclesOfAuthor.getOrDefault(author, new HashSet<>());
        temp.add(article);
        allArliclesOfAuthor.put(author, temp);

        articles.add(article);
    }

    @Override
    public boolean removeArticle(Article article) {
        if(allArliclesOfAuthor.containsKey(article.getAuthor())){
            allArliclesOfAuthor.get(article.getAuthor()).remove(article);
        }

        return articles.remove(article);
    }

    @Override
    public Set<Article> findAllArticles() {
        return articles;
    }

    @Override
    public Set<Article> findAllArticlesByAuthor(Author author) {
        return allArliclesOfAuthor.get(author);
    }
}

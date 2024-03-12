package practice.repository;


import practice.interfaces.ArticleRepository;
import practice.models.Article;
import practice.models.Author;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArticleRepositoryIml implements ArticleRepository {
    private Set<Article> articles;
    private Map<Author,Set<Article>> allArliclesOfAuthor;

    public ArticleRepositoryIml() {
        articles = new HashSet<>();
        allArliclesOfAuthor = new HashMap<>();
    }

    @Override
    public void addArticle(Article article) {
        Author author = article.getAuthor();

        Set<Article> temp = allArliclesOfAuthor.getOrDefault(article, new HashSet<>());
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

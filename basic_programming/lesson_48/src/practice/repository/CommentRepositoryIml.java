package practice.repository;


import practice.interfaces.CommentRepository;
import practice.models.Article;
import practice.models.Author;
import practice.models.Comment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommentRepositoryIml implements CommentRepository {
    private Set<Comment> comments;
    private Map<Article, Set<Comment>> articleComments;
    private Map<Author, Set<Comment>> authorComments;

    public CommentRepositoryIml() {
        articleComments = new HashMap<>();
        authorComments = new HashMap<>();
        comments = new HashSet<>();
    }

    @Override
    public void addComment(Comment comment) {
        // получаем из комментария автора и статью
        // вспомогательные переменные
        Author author = comment.getAuthor();
        Article article = comment.getArticle();

        // операции для Map<Article, Set<Comment>>
        Set<Comment> temp = articleComments.getOrDefault(article, new HashSet<>());
        temp.add(comment);
        articleComments.put(article, temp);

        // операции для Map<Author, Set<Comment>>
        temp = authorComments.getOrDefault(author, new HashSet<>());
        temp.add(comment);
        authorComments.put(author, temp);

        // общий список комментариев
        comments.add(comment);
    }

    @Override
    public boolean removeComment(Comment comment) {
        if (articleComments.containsKey(comment.getArticle())){
            articleComments.get(comment.getArticle()).remove(comment);
        }

        if (authorComments.containsKey(comment.getAuthor())){
            authorComments.get(comment.getAuthor()).remove(comment);
        }

        return comments.remove(comment);
    }

    @Override
    public Set<Comment> findAllComments() {
        return comments;
    }

    @Override
    public Set<Comment> findAllArticleComments(Article article) {
        return articleComments.get(article);
    }

    @Override
    public Set<Comment> findAllAuthorComments(Author author) {
        return authorComments.get(author);
    }
}

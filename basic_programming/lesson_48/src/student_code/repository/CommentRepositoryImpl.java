package student_code.repository;

import student_code.interfaces.CommentRepository;
import student_code.models.Article;
import student_code.models.Author;
import student_code.models.Comment;

import java.util.*;

public class CommentRepositoryImpl implements CommentRepository {
    private Set<Comment> comments;
    private Map<Article, Set<Comment>> articleComments;
    private Map<Author, Set<Comment>> authorComments;

    public CommentRepositoryImpl() {
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

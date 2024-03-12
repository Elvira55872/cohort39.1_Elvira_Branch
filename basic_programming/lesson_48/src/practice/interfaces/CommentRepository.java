package practice.interfaces;



import practice.models.Article;
import practice.models.Author;
import practice.models.Comment;

import java.util.Set;

// Управление комментариями (добавление, поиск, обновление, удаление).
public interface CommentRepository {
    void addComment(Comment comment);

    boolean removeComment(Comment comment);

    Set<Comment> findAllComments();

    Set<Comment> findAllArticleComments(Article article);

    Set<Comment> findAllAuthorComments(Author author);
}

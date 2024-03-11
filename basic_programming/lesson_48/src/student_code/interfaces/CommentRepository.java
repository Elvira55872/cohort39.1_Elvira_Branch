package student_code.interfaces;

import student_code.models.Article;
import student_code.models.Author;
import student_code.models.Comment;

import java.util.Set;

// Управление комментариями (добавление, поиск, обновление, удаление).
public interface CommentRepository {
    void addComment(Comment comment);

    boolean removeComment(Comment comment);

    Set<Comment> findAllComments();

    Set<Comment> findAllArticleComments(Article article);

    Set<Comment> findAllAuthorComments(Author author);
}

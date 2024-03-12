package practice.models;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * ID: Уникальный идентификатор комментария.
 * articleId: Идентификатор статьи, к которой оставлен комментарий.
 * text: Текст комментария.
 * publishDate: Дата публикации комментария.
 * authorId: Идентификатор автора комментария.
 */
public class Comment {
    private int ID;
    private Article article;
    private String text;
    private LocalDateTime publishDate;
    private Author author;
    private static int count;

    public Comment( Article article, String text, Author author) {
        this.ID = count++;
        this.article = article;
        this.text = text;
        this.publishDate = LocalDateTime.now();
        this.author = author;
    }

    public int getID() {
        return ID;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return ID == comment.ID && Objects.equals(article, comment.article) && Objects.equals(text, comment.text) && Objects.equals(publishDate, comment.publishDate) && Objects.equals(author, comment.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, article, text, publishDate, author);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "ID=" + ID +
                ", article=" + article +
                ", text='" + text + '\'' +
                ", publishDate=" + publishDate +
                ", author=" + author +
                '}';
    }
}

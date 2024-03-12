package practice.models;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * ID: Уникальный идентификатор статьи.
 * title: Заголовок статьи.
 * content: Содержимое статьи.
 * publishDate: Дата публикации.
 * authorId: Идентификатор автора статьи.
 */
public class Article {
    private int ID;
    private String title;
    private String content;
    private LocalDateTime publishDate;
    private Author author;
    private static int count;

    public Article( String title, String content, Author author) {
        this.ID = count++;
        this.title = title;
        this.content = content;
        this.publishDate = LocalDateTime.now();
        this.author = author;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        Article article = (Article) o;
        return ID == article.ID && Objects.equals(title, article.title) && Objects.equals(content, article.content) && Objects.equals(publishDate, article.publishDate) && Objects.equals(author, article.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, title, content, publishDate, author);
    }

    @Override
    public String toString() {
        return "Article{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publishDate=" + publishDate +
                ", author=" + author +
                '}';
    }
}

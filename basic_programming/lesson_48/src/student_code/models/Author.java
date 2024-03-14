package student_code.models;

import java.util.Objects;

/**
 * ID: Уникальный идентификатор автора.
 * name: Имя автора.
 * email: Электронная почта автора.
 * bio: Краткая биография автора.
 */

public class Author {
    private int ID;
    private String name;
    private String email;
    private String bio;
    private static int count;

    public Author(String name, String email, String bio) {
        this.name = name.toLowerCase();
        this.email = email.toLowerCase();
        this.bio = bio;
        this.ID = count++;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return ID == author.ID && Objects.equals(name, author.name) && Objects.equals(email, author.email) && Objects.equals(bio, author.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, email, bio);
    }

    @Override
    public String toString() {
        return "Author{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}

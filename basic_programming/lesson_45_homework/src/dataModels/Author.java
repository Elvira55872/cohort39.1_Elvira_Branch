package dataModels;

public class Author {
    private String authorName;
    private String country;
    private int yearOfBirth;

    public Author(String authorName, String country, int yearOfBirth) {
        this.authorName = authorName;
        this.country = country;
        this.yearOfBirth = yearOfBirth;
    }

    public Author(String authorName, int yearOfBirth) {
        this.authorName = authorName;
        this.yearOfBirth = yearOfBirth;
        this.country = null;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getCountry() {
        return country;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}

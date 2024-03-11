package practice.models;

// Модель
public class Reader {
    private String mail;
    private String password;

    public Reader(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reader reader)) return false;

        return getMail() != null ? getMail().equals(reader.getMail()) : reader.getMail() == null;
    }

    @Override
    public int hashCode() {
        return getMail() != null ? getMail().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "mail='" + mail + '\'' +
                ", password='" + "******" + '\'' +
                '}';
    }
}

package dataModels;

public class Reader {
    private String email;
    private String password;

    public Reader(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        // logic for getting to get email
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        // logic for getting the password
        return password;
    }

    public void setPassword(String password) {
        // logic for setting the password
        this.password = password;
    }
}

package consultation2024_01_18.teachers_sandbox;

public class RegexExample {
    public static void main(String[] args) {
        String digits = "XVMIC";

        String digitPattern = "[d+]";

        boolean containOnlyDigits = digits.matches("[I|V|X|C|M]+");

        System.out.println("containOnlyDigits = " + containOnlyDigits);


    }
}

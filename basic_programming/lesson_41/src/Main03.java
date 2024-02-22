public class Main03 {
    /*
    Реализовать методы для "шифра цезаря"
     */

    public static String encrypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            sb.append((char)(text.charAt(i) + 3));
        }
        return sb.toString();
    }

    public static String decrypt(String data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            sb.append((char)(data.charAt(i) - 3));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String openText = "Hello world!";
        System.out.println("Input text: " + openText);
        String enc = encrypt(openText);
        System.out.println("Encrypted data: " + enc);
        String text = decrypt(enc);
        System.out.println("Decrypted text: " + text);

    }
}

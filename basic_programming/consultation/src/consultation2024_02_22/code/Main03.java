package consultation2024_02_22.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Map<String, Double> prices = new HashMap<>();

        prices.put("apple", 2.0);
        prices.put("tomato", 3.5);
        prices.put("bread", 1.5);

        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy?");
        String choice = scanner.nextLine().toLowerCase();

        Double price = prices.get(choice);

        if (price == null) {
            System.out.println("We dont have that!");
        } else {
            System.out.println("Sure! This will be " + price + " euro");
        }
    }
}

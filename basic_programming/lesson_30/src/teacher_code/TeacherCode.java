package teacher_code;

import practice.MockService;

import java.util.*;

public class TeacherCode {
    public static void main(String[] args) {
        Map<String, String> countries = new IdentityHashMap<>();

        // добавлять можно исключительно парой -
        // нельзя добавить только ключ или только значение
        countries.put("Germany", "Berlin");
        countries.put("Austrie", "Vien");
        countries.put("France", "Paris");
        countries.put("Great Britain", "London");

        // чтобы получить все ключи, мы можем воспользоваться методом .keySet(),
        // который вернет set, содержащий клиючи из мапы

        Set<String> keys = countries.keySet();

        for (String key : keys) { // -> for (String key : countries.keySet()) {
            System.out.println(key + " : " + countries.get(key));
        }

        // метод .values() - возвращает коллекцию, состоящую из значений, содержащихся в мапе

        ArrayList<String> values = new ArrayList<>(countries.values());
        for (String value : values) { // -> for (String value : countries.values())
            System.out.print(value + ", ");
        }
        System.out.println();

        // метод .containsKey() - проверяет, что данный ключ есть в мапе
        System.out.println("countries.containsKey(\"Austrie\") = " + countries.containsKey("Austrie"));

        // метод .containsValue() - проверяет, что данное значение есть в мапе
        System.out.println("countries.containsValue(\"Munich\") = " + countries.containsValue("Munich"));


        // пытаемся положить странные значения в мапу:
        countries.put("Italy", null);

        // не все мапы поддерживают значение null, в качестве ключа
        try {
            countries.put(null, "Rome");
        } catch (RuntimeException e) {
            System.out.println(countries.getClass().getSimpleName() +
                    " не поддерживает добавление null в качестве ключа");
        }

        // countries.put(null, null);

        // если попытаться положить в мапу новую пару с уже имеющимся ключом, но новым значением,
        // то старое значение будет перезаписано:
        countries.put("Germany", "Munich");
        printMap(countries);

        try {
            System.out.println("countries.get(null) = " + countries.get(null));
        } catch (Exception e) {
            System.out.println(countries.getClass().getSimpleName() +
                    " не поддерживает операцию получение значения по null в качестве ключа");
        }
    }

    //Метод для распечатки мап
    static void printMap(Map map) {
        for (Object key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}

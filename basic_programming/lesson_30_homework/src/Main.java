import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Задача 1.
 * Работа с Map
 *
 * Реализовать метод removeSameValues(Map<K, V> map).
 * Данный метод должен принимать в качестве аргумента мапу,
 * ваша задача - Оставить в данной мапе исключительно пары с уникальным значением (не ключом).
 * null - также может быть представлен, в этом случае допустимо оставить только одно null значение в мапе.
 *
 * Упрощенная версия: использовать данный метод на основе removeSameValues(Map<String, String> map)
 */
public class Main<K, V> {
    public static void main(String[] args) {
        Map<Integer, String> m = new HashMap<>();
        m.put(0,"lala");
        m.put(1,"baba");
        m.put(2,"lala");
        m.put(3,"nana");

        System.out.println(m.values());

    }

    public void removeSameValues(Map<K, V> map){
        // метод .containsValue() - проверяет, что данное значение есть в мапе
        for (int i = 0; i < map.size(); i++) {
            ArrayList<V> values = new ArrayList<>(map.values());
            for (V data: values){

            }

        }
    }
}

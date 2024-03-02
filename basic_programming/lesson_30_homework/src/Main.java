import java.util.*;

/**
 * Задача 1.
 * Работа с Map
 * <p>
 * Реализовать метод removeSameValues(Map<K, V> map).
 * Данный метод должен принимать в качестве аргумента мапу,
 * ваша задача - Оставить в данной мапе исключительно пары с уникальным значением (не ключом).
 * null - также может быть представлен, в этом случае допустимо оставить только одно null значение в мапе.
 * <p>
 * Упрощенная версия: использовать данный метод на основе removeSameValues(Map<String, String> map)
 */

/**
 * HINTS
 * 1. Создаем временный набор (Set) для хранения уникальных значений, которые мы уже добавили в итоговую мапу.
 * Это позволит нам проверять, существует ли значение в мапе без необходимости итерировать всю мапу каждый раз.
 * <p>
 * 2. Итерируем исходную мапу, чтобы проверить каждое значение. Для каждого значения мы проверяем,
 * содержится ли оно уже в нашем временном наборе уникальных значений.
 * <p>
 * 3. Если значение уже содержится в наборе, удаляем соответствующий ключ из исходной мапы.
 * Если значение не содержится в наборе, добавляем его в набор уникальных значений.
 */
public class Main {
    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>();
        m.put("null", "lala");
        m.put("one", "baba");
        m.put("two", "lala");
        m.put("three", "nana");
        System.out.println(m.entrySet());
        System.out.println(removeSameValues(m));
    }

    public static Map<String, String> removeSameValues(Map<String, String> map) {
        // по подсказкам Ильяса
        Map<String, String> result = new HashMap<>(); // новая пустая мапа куда будем класть уникальные значения
        Set<Map.Entry<String, String>> tempSet = map.entrySet(); // сет только с уникальными значениями из мапы

        for (Map.Entry<String, String> pair : tempSet) {
            if (!result.containsValue(pair.getValue())) {
                result.put(pair.getKey(), pair.getValue());
            }
        }
        return result;
    }
}

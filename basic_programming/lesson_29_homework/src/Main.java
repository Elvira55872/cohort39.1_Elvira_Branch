import java.util.HashSet;
import java.util.Set;

/**
 * Задача: Работа с set
 * Пересечение множеств: Напишите метод, который принимает два множества и возвращает новое множество,
 * содержащее их пересечение. (Допустимо взять Set<String>)
 * (Только те элементы, которые содержаться в обоих Set) Напишите тесты для вашего метода
 */
public class Main {

    public static Set<String> sameDataFounder(Set<String> one, Set<String> two) {
        Set<String> sameData = new HashSet<>(one);
        sameData.retainAll(two);
        return sameData;
    }
}

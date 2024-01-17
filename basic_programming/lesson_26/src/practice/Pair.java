package practice;

/**
 * Pair - обобщенный класс, предназначенный для хранения двух связанных данных различных типов.
 */
public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static void main(String[] args) {
        // Использование
        Pair<String, Integer> pair = new Pair<>("age", 25);
    }
}




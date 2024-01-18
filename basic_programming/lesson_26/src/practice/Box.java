package practice;

public class Box<T> {
    private T content;

    public void set(T content) {
        this.content = content;
    }

    public T get() {
        return content;
    }

    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello World");
        String value = stringBox.get();

        // Во время выполнения, информация о типе T не доступна
        // Следующая строка не вызовет ошибку во время компиляции,
        // но может привести к ошибке во время выполнения
        Box rawBox = new Box(); // сырой тип
        rawBox = stringBox;     // допустимо
        rawBox.set(123);        // потенциальная ошибка во время выполнения

        // Попытка извлечения строки из Box, который теперь содержит Integer
        String riskyValue =  stringBox.get(); // может вызвать ClassCastException
    }
}

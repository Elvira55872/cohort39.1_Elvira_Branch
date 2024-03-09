import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Условия задания: "плюсом будет использование НЕ String", "Подсказка, попробуйте изменить лист".

        // Поэтому все фунциональные интерфейсы будут работать с Листом, хранящим значения интеджер
        List<Integer> myList = new ArrayList<>();

        //Action
        /* ЗАДАНИЕ:
        надо написать некую реализацию метода execute,
        который в качестве аргумента принимает значение из дженерика,
        и ничего не возвращает
        Подсказка, попробуйте изменить лист  */
        /*
        МОЙ КОММЕНТАРИЙ
        Дженериком является List<Integer>
        В моей реализации функциональный интерфейс Action в методе execute добавляет в List цифру 5
         */
        Action<List<Integer>> action = x -> x.add(5);
        action.execute(myList);
        System.out.println("Action + myList = " + myList);

        //Condition
        /* ЗАДАНИЕ:
        в качестве дженерика принимает дженерик, такой же тип данных должен работать
        в качестве аргумента в методе test, который обязан вернуть булеан */
        /*
        МОЙ КОММЕНТАРИЙ
        Дженериком является List<Integer>
        В моей реализации функциональный интерфейс Condition в методе test проверяет List на наличие элементов в нем
         */
        Condition<List<Integer>> condition = x -> x.isEmpty();
        condition.test(myList);
        System.out.println("Condition.test(myList) = " + condition.test(myList));


        //Provider
        /* ЗАДАНИЕ:
        в качестве дженерика принимает некий тип, этот же тип должен быть возвращен
        в анонимном методе provide() который и надо переопределить.
        То есть данный метод должен создавать внутри себя экземпляр класса <дженерик> */
        /*
        МОЙ КОММЕНТАРИЙ
        Функциональный интерфейс Provider в моей реализации создает ArrayList со значениями интеджер в нем
         */
        Provider<List<Integer>> provider = ArrayList::new;
        provider.provide();
        // Outpur: true
        // Это говорит о том, что объект был создан и он пуст
        System.out.println("provider.provide().isEmpty() = " + provider.provide().isEmpty()); // true,
    }
}
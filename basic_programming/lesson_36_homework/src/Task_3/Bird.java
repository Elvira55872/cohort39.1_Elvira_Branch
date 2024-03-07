package Task_3;

/**
 * Создать класс Bird с методом fly(),
 * затем реализуйте подклассы Penguin и Eagle.
 *
 * Оба должны наследовать Bird, но только Eagle может летать.
 */
public class Bird {
    int age;
    String gender;

    public Bird(int age, String gender) {
        this.age = age;
        this.gender = gender;
    }

    public void fly(){

    }
}

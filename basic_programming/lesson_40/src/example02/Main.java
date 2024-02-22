package example02;

public class Main {
    /*
    Разработать интерфейс, который опишет метод для вывода приветствия на разных языках.
    Реализовать несколько вариантов объектов этого интерфейса через анонимные классы.
     */
    static Greeter ruGreeter = new Greeter() {
        @Override
        public void printGreeting() {
            System.out.println("Привет, мир!");
        }
    };

    public static void main(String[] args) {
        Greeter engGreeter = new Greeter() {

            @Override
            public void printGreeting() {
                System.out.println("Hello world!");
            }
        };

        engGreeter.printGreeting();
        ruGreeter.printGreeting();
    }
}

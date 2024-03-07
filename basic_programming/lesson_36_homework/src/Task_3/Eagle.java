package Task_3;

public class Eagle extends Bird {
    public Eagle(int age, String gender) {
        super(age, gender);
    }

    @Override
    public void fly() {
        System.out.println("Eagle is flying");
    }
}

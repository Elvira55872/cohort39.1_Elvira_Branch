package consultation2024_02_22.code.example01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Animal animal = new Animal("Wolf", 9);
        //Animal fish = new Fish("Cod", 3, 15, "gray");

        Animal animal = new Cat("Cat", 4, "British hang-ear");

        System.out.println(animal);

        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            System.out.println(cat);
            System.out.println(cat.getBreed());
        }

    }
}

package lesson21.OOP.pet;

import java.util.Objects;

public class Cat extends Pet implements Groomable {
    private String name;
    private int age;
    private String breed;
    private String furColor;

    public Cat(String name, int age, String breed, String furColor) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.furColor = furColor;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getFurColor() {
        return furColor;
    }

    // Методы из Pet
    @Override
    public void makeSound() {
        System.out.println(name + " мяукает");
    }

    @Override
    public void play(String toy) {
        System.out.println(name + " играет с " + toy);
    }

    @Override
    public void eat(String food) {
        System.out.println(name + " ест " + food);
    }

    @Override
    public void sleep() {
        System.out.println(name + " спит");
    }

    // Метод из Groomable
    @Override
    public void groom() {
        System.out.println(name + " вычесан");
    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        Cat cat = (Cat) o;
        return age == cat.age &&
                Objects.equals(name, cat.name) &&
                Objects.equals(breed, cat.breed) &&
                Objects.equals(furColor, cat.furColor);
    }
}

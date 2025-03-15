package Lab2.Tasks;

class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Животное издает звук");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void bark() {
        System.out.println("Гав-гав!");
    }

    @Override
    public void makeSound() {
        bark();
    }
}

class Cat extends Animal {
    private String foodType;

    public Cat(String name, int age, String foodType) {
        super(name, age);
        this.foodType = foodType;
    }

    public String getFoodType() {
        return foodType;
    }

    public void meow() {
        System.out.println("Мяу-мяу!");
    }

    @Override
    public void makeSound() {
        meow();
    }
}

class ShapeTask8 {
    public double calculateArea() {
        System.out.println("Метод не реализован для этой фигуры.");
        return 0;
    }

    public double calculatePerimeter() {
        System.out.println("Метод не реализован для этой фигуры.");
        return 0;
    }
}

class CircleTask8 extends ShapeTask8 {
    private double radius;

    public CircleTask8(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class SquareTask8 extends ShapeTask8 {
    private double side;

    public SquareTask8(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}

public class Task8 {

    public static void main(String[] args) {
        Dog dog = new Dog("Рекс", 3, "Овчарка");
        Cat cat = new Cat("Мурка", 2, "Рыба");

        System.out.println(dog.getName());
        dog.makeSound();

        System.out.println(cat.getName());
        cat.makeSound();

        CircleTask8 circle = new CircleTask8(5.0);
        SquareTask8 square = new SquareTask8(4.0);

        System.out.println("Площадь круга: " + circle.calculateArea());
        System.out.println("Периметр квадрата: " + square.calculatePerimeter());
    }
}
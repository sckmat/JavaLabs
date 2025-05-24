package Lab7.Examples;

import java.io.*;
import java.nio.charset.StandardCharsets;

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Example7 {

    public static void main(String[] args) {
        Person person = new Person("Иванов Иван", 30);

        try {
            FileOutputStream fileOut = new FileOutputStream("src/Lab7/Examples/person.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(person);

            out.close();
            fileOut.close();

            System.out.println("Данные в person.ser");
        } catch (IOException e) {
            System.out.println("Ошибка при сериализации: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

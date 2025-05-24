package Lab7.Tasks;

import java.io.*;

class Student implements Serializable {
    private final String name;
    private final int age;
    private final double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public void printInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Оценка: " + grade);
    }
}

public class Task8 {
    public static void main(String[] args) {
        String fileName = "src/Lab7/Tasks/student.dat";

        Student student = new Student("Иван Иванов", 20, 4.8);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(student);
            System.out.println("Объект сохранён в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении объекта: " + e.getMessage());
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            Student restoredStudent = (Student) in.readObject();
            System.out.println("\nОбъект восстановлен из файла:");
            restoredStudent.printInfo();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при восстановлении объекта: " + e.getMessage());
        }
    }
}

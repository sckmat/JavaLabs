package Lab1.Tasks;

import java.time.LocalDate;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите ваш год рождения: ");
        int birthYear = scanner.nextInt();

        System.out.print("Был ли уже ваш день рождения в этом году? (да/нет): ");
        String birthdayPassed = scanner.next().toLowerCase();

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        int age;
        if (birthdayPassed.equals("да"))
            age = currentYear - birthYear;
        else
            age = currentYear - birthYear - 1;

        System.out.printf("%s, ваш возраст: %s", name, age);

        scanner.close();
    }
}

package Lab1.Tasks;

import java.time.LocalDate;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваш возраст: ");
        int age = scanner.nextInt();

        System.out.print("Был ли у вас день рождения в этом году? (да/нет): ");
        String birthdayPassed = scanner.next().toLowerCase();

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        int birthYear;
        if (birthdayPassed.equals("да"))
            birthYear = currentYear - age;
        else
            birthYear = currentYear - age - 1;

        System.out.println("Ваш год рождения: " + birthYear);

        scanner.close();
    }
}

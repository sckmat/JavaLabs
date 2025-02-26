package Lab1.Tasks;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваш год рождения: ");
        int birthYear = scanner.nextInt();

        System.out.print("Введите ваш месяц рождения (1-12): ");
        int birthMonth = scanner.nextInt();

        System.out.print("Введите ваш день рождения: ");
        int birthDay = scanner.nextInt();
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        Period age = Period.between(birthDate, currentDate);

        System.out.printf("Ваш возраст: %s", age.getYears());

        scanner.close();
    }
}

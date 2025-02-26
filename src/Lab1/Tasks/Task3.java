package Lab1.Tasks;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название текущего дня недели: ");
        String dayOfWeek = scanner.nextLine();

        System.out.print("Введите название месяца: ");
        String month = scanner.nextLine();

        System.out.print("Введите дату (номер дня в месяце): ");
        int dayOfMonth = scanner.nextInt();

        System.out.printf("Сегодняшняя дата: %s %s %s", dayOfWeek, dayOfMonth, month);

        scanner.close();
    }
}

package Lab1.Tasks;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int number1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int number2 = scanner.nextInt();

        int sum = number1 + number2;

        System.out.printf("Сумма чисел %s и %s равна: %s", number1, number2, sum);

        scanner.close();
    }
}

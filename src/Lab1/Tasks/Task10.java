package Lab1.Tasks;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int number1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int number2 = scanner.nextInt();

        int sum = number1 + number2;
        int difference = number1 - number2;

        System.out.println("Сумма чисел: " + sum);
        System.out.println("Разность чисел: " + difference);

        scanner.close();
    }
}

package Lab1.Tasks;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        int previousNumber = number - 1;
        int nextNumber = number + 1;
        int sum = previousNumber + number + nextNumber;
        int squareOfSum = sum * sum;

        System.out.println("Последовательность чисел:");
        System.out.printf("1. Число, на единицу меньше введенного: %s\n", previousNumber);
        System.out.printf("2. Введенное число: %s\n", number);
        System.out.printf("3. Число, на единицу больше введенного: %s\n", nextNumber);
        System.out.printf("4. Квадрат суммы первых трех чисел: %s", squareOfSum);

        scanner.close();
    }
}

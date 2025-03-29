package Lab3.Tasks;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое число: ");
        int decimalNumber = scanner.nextInt();

        if (decimalNumber == 0) {
            System.out.println("Двоичное представление: 0");
        } else {
            System.out.print("Двоичное представление: ");
            convertToBinary(decimalNumber);
        }

        scanner.close();
    }

    public static void convertToBinary(int n) {
        if (n > 1) {
            convertToBinary(n / 2);
        }
        System.out.print(n % 2);
    }
}

package Lab4.Tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            int[] array = createArray();
            double average = calculatePositiveAverage(array);
            printResult(average);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: несоответствие числового типа данных!");
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Программа завершена.");
        }
    }

    private static int[] createArray() throws InputMismatchException {
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        if (size <= 0)
            throw new IllegalArgumentException("Размер массива должен быть положительным!");

        int[] array = new int[size];
        System.out.println("Введите элементы массива:");

        for (int i = 0; i < size; i++)
            array[i] = getArrayElement(i);

        return array;
    }

    private static int getArrayElement(int index) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введена строка вместо числа! Повторите ввод элемента " + (index + 1));
                scanner.next();
            }
        }
    }

    private static double calculatePositiveAverage(int[] array) {
        int sum = 0;
        int count = 0;

        for (int value : array) {
            if (value > 0) {
                sum += value;
                count++;
            }
        }

        if (count == 0)
            throw new IllegalArgumentException("Положительные элементы отсутствуют!");

        return (double) sum / count;
    }

    private static void printResult(double average) {
        System.out.printf("Среднее значение положительных элементов: %.2f\n", average);
    }
}

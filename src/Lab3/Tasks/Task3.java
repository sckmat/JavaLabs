package Lab3.Tasks;

import java.util.Scanner;

public class Task3 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Введите элементы массива:");
        inputArrayRecursive(array, 0);

        System.out.println("Введенный массив:");
        printArrayRecursive(array, 0);
    }

    public static void inputArrayRecursive(int[] array, int index) {
        if (index >= array.length) {
            return;
        }
        System.out.printf("Элемент %d: ", index);
        array[index] = scanner.nextInt();
        inputArrayRecursive(array, index + 1);
    }

    public static void printArrayRecursive(int[] array, int index) {
        if (index >= array.length) {
            return;
        }
        System.out.printf("array[%d] = %d\n", index, array[index]);
        printArrayRecursive(array, index + 1);
    }
}

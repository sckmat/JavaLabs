package Lab4.Tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            int[][] matrix = createMatrix();
            int columnNumber = getColumnNumber(matrix[0].length);
            printColumn(matrix, columnNumber);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: требуется ввести целое число!");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Программа завершена.");
        }
    }

    private static int[][] createMatrix() {
        System.out.print("Введите количество строк матрицы: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов матрицы: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Введите элементы матрицы:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Элемент [%d][%d]: ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int getColumnNumber(int maxColumns) {
        System.out.print("Введите номер столбца (от 0 до " + (maxColumns - 1) + "): ");
        int columnNumber = scanner.nextInt();

        if (columnNumber < 0 || columnNumber >= maxColumns)
            throw new IllegalArgumentException("Столбца с таким номером не существует!");

        return columnNumber;
    }

    private static void printColumn(int[][] matrix, int columnNumber) {
        System.out.println("Столбец " + columnNumber + ":");
        for (int[] row : matrix)
            System.out.println(row[columnNumber]);
    }
}

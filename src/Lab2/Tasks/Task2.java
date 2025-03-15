package Lab2.Tasks;

public class Task2 {

    public static void main(String[] args) {
        int rows = 4;
        int cols = 5;

        int[][] matrix = createSnakeMatrix(rows, cols);
        printMatrix(matrix);
    }

    public static int[][] createSnakeMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        int value = 1;

        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = value++;
                }
            } else {
                for (int j = cols - 1; j >= 0; j--) {
                    matrix[i][j] = value++;
                }
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints)
                System.out.printf("%2d ", anInt);
            System.out.println();
        }
    }
}

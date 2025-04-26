package Lab5.Timus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Timus1313 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int sum = 0; sum <= 2 * (n - 1); sum++) {
            for (int i = n - 1; i >= 0; i--) {
                int j = sum - i;
                if (j >= 0 && j < n) {
                    result.add(matrix[i][j]);
                }
            }
        }

        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
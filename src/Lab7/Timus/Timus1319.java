package Lab7.Timus;

import java.util.Scanner;

public class Timus1319 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] grid = new int[N][N];

        int num = 1;

        for (int sum = 0; sum <= 2 * (N - 1); sum++) {
            for (int i = 0; i < N; i++) {
                int j = sum - i;
                if (j >= 0 && j < N) {
                    grid[i][N - 1 - j] = num++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(grid[i][j]);
                if (j < N - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}

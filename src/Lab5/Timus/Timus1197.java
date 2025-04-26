package Lab5.Timus;

import java.util.Scanner;

public class Timus1197 {
    private static final int[][] MOVES = {
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String position = scanner.nextLine();
            System.out.println(countKnightMoves(position));
        }

        scanner.close();
    }

    public static int countKnightMoves(String pos) {
        char fileChar = pos.charAt(0);
        char rankChar = pos.charAt(1);

        int x = fileChar - 'a' + 1;
        int y = rankChar - '1' + 1;

        int count = 0;

        for (int[] move : MOVES) {
            int newX = x + move[0];
            int newY = y + move[1];

            if (newX >= 1 && newX <= 8 && newY >= 1 && newY <= 8) {
                count++;
            }
        }

        return count;
    }
}

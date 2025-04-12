package Lab4.Timus;

import java.util.Scanner;

public class Timus1787 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int n = scanner.nextInt();

        int[] arrivals = new int[n];
        for (int i = 0; i < n; i++)
            arrivals[i] = scanner.nextInt();

        int queue = 0;
        for (int i = 0; i < n; i++) {
            queue += arrivals[i];
            queue = Math.max(queue - k, 0);
        }

        System.out.println(queue);
        scanner.close();
    }
}

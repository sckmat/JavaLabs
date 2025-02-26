package Lab1.Timus;

import java.util.Scanner;

public class Timus1293 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int totalSulfide = N * 2 * A * B;

        System.out.println(totalSulfide);

        scanner.close();
    }
}

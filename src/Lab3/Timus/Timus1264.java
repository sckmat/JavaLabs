package Lab3.Timus;

import java.util.Scanner;

public class Timus1264 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        long seconds = (long) N * (M + 1);
        System.out.println(seconds);
    }
}

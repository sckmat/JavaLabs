package Lab3.Timus;

import java.util.Scanner;

public class Timus2066 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int result = Math.min(a - b - c, Math.min(a - b * c, a * b - c));
        System.out.println(result);
    }
}

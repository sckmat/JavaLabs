package Lab2.Timus;

import java.util.Scanner;

public class Timus2001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a1 = scanner.nextInt();
        int b1 = scanner.nextInt();
        scanner.nextLine();

        int a2 = scanner.nextInt();
        int b2 = scanner.nextInt();
        scanner.nextLine();

        int a3 = scanner.nextInt();
        int b3 = scanner.nextInt();

        int x = a1 - a3;
        int y = b1 - b2;

        System.out.println(x + " " + y);
    }
}

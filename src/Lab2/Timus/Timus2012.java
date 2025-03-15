package Lab2.Timus;

import java.util.Scanner;

public class Timus2012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int f = scanner.nextInt();

        if ((12 - f) * 45 <= 240)
            System.out.println("YES");
        else
            System.out.println("NO");

        scanner.close();
    }
}

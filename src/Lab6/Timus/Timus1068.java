package Lab6.Timus;

import java.util.Scanner;

public class Timus1068 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;

        if (n >= 1) {
            sum = n * (n + 1) / 2;
        } else {
            int count = 1 - n + 1;
            sum = (1 + n) * count / 2;
        }

        System.out.println(sum);
    }
}

package Lab2.Timus;

import java.util.Scanner;

public class Timus1409 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int h = scanner.nextInt();
        int l = scanner.nextInt();

        int notShotByHarry = l - 1;
        int notShotByLarry = h - 1;

        System.out.println(notShotByHarry + " " + notShotByLarry);
    }
}

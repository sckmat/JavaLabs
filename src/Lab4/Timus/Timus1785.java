package Lab4.Timus;

import java.util.Scanner;

public class Timus1785 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String translation;

        if (n >= 1000) {
            translation = "legion";
        } else if (n >= 500) {
            translation = "zounds";
        } else if (n >= 250) {
            translation = "swarm";
        } else if (n >= 100) {
            translation = "throng";
        } else if (n >= 50) {
            translation = "horde";
        } else if (n >= 20) {
            translation = "lots";
        } else if (n >= 10) {
            translation = "pack";
        } else if (n >= 5) {
            translation = "several";
        } else {
            translation = "few";
        }

        System.out.println(translation);
        scanner.close();
    }
}

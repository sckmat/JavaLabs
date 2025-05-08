package Lab6.Timus;

import java.util.Scanner;

public class Timus1585 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int emperor = 0;
        int little = 0;
        int macaroni = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.nextLine();
            switch (type) {
                case "Emperor Penguin":
                    emperor++;
                    break;
                case "Little Penguin":
                    little++;
                    break;
                case "Macaroni Penguin":
                    macaroni++;
                    break;
            }
        }

        if (emperor > little && emperor > macaroni) {
            System.out.println("Emperor Penguin");
        } else if (little > emperor && little > macaroni) {
            System.out.println("Little Penguin");
        } else {
            System.out.println("Macaroni Penguin");
        }
    }
}

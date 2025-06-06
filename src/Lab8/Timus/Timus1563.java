package Lab8.Timus;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Timus1563 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> visited = new HashSet<>();
        int bayans = 0;

        for (int i = 0; i < n; i++) {
            String shop = scanner.nextLine();
            if (visited.contains(shop)) {
                bayans++;
            } else {
                visited.add(shop);
            }
        }

        System.out.println(bayans);
    }
}

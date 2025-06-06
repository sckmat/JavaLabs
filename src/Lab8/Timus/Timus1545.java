package Lab8.Timus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Timus1545 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> hieroglyphs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            hieroglyphs.add(scanner.nextLine());
        }

        String prefix = scanner.nextLine();

        for (String h : hieroglyphs) {
            if (h.startsWith(prefix)) {
                System.out.println(h);
            }
        }
    }
}

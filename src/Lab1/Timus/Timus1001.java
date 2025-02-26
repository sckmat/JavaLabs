package Lab1.Timus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Timus1001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Long> list = new ArrayList<>();

        while (scanner.hasNextLong())
            list.add(scanner.nextLong());

        for (int i = list.size() - 1; i >= 0; i--)
        {
            long number = list.get(i);
            double sqrt = Math.sqrt(number);
            System.out.printf("%.4f%n", sqrt);
        }
    }
}

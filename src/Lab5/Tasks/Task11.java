package Lab5.Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task11 {
    public static List<Integer> filterLessThan(List<Integer> list, int threshold) {
        return list.stream()
                .filter(n -> n < threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество чисел: ");
        int count = Integer.parseInt(scanner.nextLine());

        List<Integer> numbers = new ArrayList<>();

        System.out.println("Введите числа:");
        for (int i = 0; i < count; i++) {
            numbers.add(Integer.parseInt(scanner.nextLine()));
        }

        System.out.print("Введите число, с которым нужно сравнивать (порог): ");
        int threshold = Integer.parseInt(scanner.nextLine());

        List<Integer> result = filterLessThan(numbers, threshold);

        System.out.println("\nЧисла меньше " + threshold + ":");
        for (int number : result) {
            System.out.println(number);
        }

        scanner.close();
    }
}

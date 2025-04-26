package Lab5.Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task7 {
    public static List<Integer> filterDivisible(List<Integer> list, int divisor) {
        return list.stream()
                .filter(num -> num % divisor == 0)
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

        System.out.print("Введите число, на которое нужно делить без остатка: ");
        int divisor = Integer.parseInt(scanner.nextLine());

        List<Integer> filtered = filterDivisible(numbers, divisor);

        System.out.println("\nЧисла, делящиеся на " + divisor + " без остатка:");
        for (int num : filtered) {
            System.out.println(num);
        }

        scanner.close();
    }
}

package Lab5.Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task8 {
    public static List<String> filterByLength(List<String> list, int minLength) {
        return list.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        int count = Integer.parseInt(scanner.nextLine());

        List<String> strings = new ArrayList<>();

        System.out.println("Введите строки:");
        for (int i = 0; i < count; i++) {
            strings.add(scanner.nextLine());
        }

        System.out.print("Введите минимальную длину строки: ");
        int minLength = Integer.parseInt(scanner.nextLine());

        List<String> result = filterByLength(strings, minLength);

        System.out.println("\nСтроки, длина которых больше " + minLength + ":");
        for (String str : result) {
            System.out.println(str);
        }

        scanner.close();
    }
}

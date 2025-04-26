package Lab5.Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task10 {
    public static List<String> filterOnlyLetters(List<String> list) {
        return list.stream()
                .filter(s -> s.matches("[a-zA-Zа-яА-Я]+"))
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

        List<String> result = filterOnlyLetters(strings);

        System.out.println("\nСтроки, содержащие только буквы:");
        for (String str : result) {
            System.out.println(str);
        }

        scanner.close();
    }
}

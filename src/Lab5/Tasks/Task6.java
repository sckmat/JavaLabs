package Lab5.Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task6 {
    public static List<String> filterBySubstring(List<String> list, String substring) {
        return list.stream()
                .filter(s -> s.contains(substring))
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

        System.out.print("Введите подстроку для поиска: ");
        String substring = scanner.nextLine();

        List<String> filtered = filterBySubstring(strings, substring);

        System.out.println("\nСтроки, содержащие подстроку \"" + substring + "\":");
        for (String str : filtered) {
            System.out.println(str);
        }

        scanner.close();
    }
}

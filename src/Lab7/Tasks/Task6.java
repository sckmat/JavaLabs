package Lab7.Tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу: ");
        String fileName = scanner.nextLine();

        System.out.print("Введите слово для поиска: ");
        String keyword = scanner.nextLine();

        File file = new File(fileName);

        if (!file.exists() || !file.isFile()) {
            System.out.println("Файл не найден.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains(keyword)) {
                    System.out.println(line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Слово \"" + keyword + "\" не найдено в файле.");
            }

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        scanner.close();
    }
}

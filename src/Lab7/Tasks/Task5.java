package Lab7.Tasks;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (file.exists() && file.isFile()) {
            System.out.println("Размер файла: " + file.length() + " байт(а)");
        } else {
            System.out.println("Файл не найден");
        }

        scanner.close();
    }
}

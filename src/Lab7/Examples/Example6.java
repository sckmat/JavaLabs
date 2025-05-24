package Lab7.Examples;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Example6 {
    public static void main(String[] args) {
        String inputFileName = "src/Lab7/Examples/input.txt";
        String outputFileName = "src/Lab7/Examples/output.txt";

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(inputFileName), StandardCharsets.UTF_8))) {
            String userInput = Lab7.Examples.ConsoleInput.readLine("Введите строку для записи в input.txt: ");
            writer.write(userInput);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в input.txt: " + e.getMessage());
        }

        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName));
                PrintWriter printWriter = new PrintWriter(outputFileName, StandardCharsets.UTF_8)
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                printWriter.println(line.toUpperCase());
            }
            System.out.println("Данные записаны в файл: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}

package Lab7.Examples;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Example5 {
    public static void main(String[] args) {
        String inputFileName = "src/Lab7/Examples/input.txt";
        String outputFileName = "src/Lab7/Examples/output.txt";

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(inputFileName), StandardCharsets.UTF_8))) {
            String userInput = Lab7.Examples.ConsoleInput.readLine("Введите строку для записи в input.txt: ");
            writer.write(userInput);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в input.txt: " + e.getMessage());
        }

        try (InputStream inputStream = new FileInputStream(inputFileName)) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            OutputStream outputStream = new FileOutputStream(outputFileName);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line.toUpperCase());
                bufferedWriter.newLine();
            }

            System.out.println("Данные записаны в файл: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}

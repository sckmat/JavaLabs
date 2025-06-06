package Lab8.Tasks.Task4;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.Scanner;

public class SongExcelManager {
    private static final String FILE_PATH = "src/Lab8/Tasks/Task4/songs.xlsx";
    private static final String SHEET_NAME = "Songs";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                Выберите действие:
                1. Записать песни в Excel
                2. Прочитать песни из Excel
                3. Выход
                """);

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> writeSongsToExcel();
                case "2" -> readSongsFromExcel();
                case "3" -> {
                    System.out.println("Завершение программы.");
                    return;
                }
                default -> System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

    private static void writeSongsToExcel() {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet(SHEET_NAME);

            String[] headers = {"Название", "Автор", "Год"};
            XSSFRow headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            Object[][] data = {
                    {"Imagine", "John Lennon", 1971},
                    {"Bohemian Rhapsody", "Queen", 1975},
                    {"Yesterday", "The Beatles", 1965}
            };

            for (int i = 0; i < data.length; i++) {
                XSSFRow row = sheet.createRow(i + 1);
                for (int j = 0; j < data[i].length; j++) {
                    row.createCell(j).setCellValue(data[i][j].toString());
                }
            }

            try (FileOutputStream outputStream = new FileOutputStream(FILE_PATH)) {
                workbook.write(outputStream);
                System.out.println("Данные успешно записаны в файл: " + FILE_PATH);
            }

        } catch (IOException e) {
            System.err.println("Ошибка при записи в Excel: " + e.getMessage());
            System.err.println("Убедитесь, что файл не открыт в Excel и путь корректен.");
        }
    }

    private static void readSongsFromExcel() {
        try (FileInputStream inputStream = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheet(SHEET_NAME);
            if (sheet == null) {
                System.err.println("Лист '" + SHEET_NAME + "' не найден.");
                System.err.println("Проверьте, существует ли лист в файле.");
                return;
            }

            System.out.println("Список песен из Excel:");
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + FILE_PATH);
            System.err.println("Сначала выполните запись песен в Excel.");
        } catch (IOException e) {
            System.err.println("Ошибка при чтении Excel: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка: " + e.getMessage());
        }
    }
}
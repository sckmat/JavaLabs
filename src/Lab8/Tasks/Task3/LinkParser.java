package Lab8.Tasks.Task3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LinkParser {
    private static final String URL = "https://itlearn.ru/first-steps";
    private static final int MAX_RETRIES = 3;
    private static final String OUTPUT_FILE = "src/Lab8/Tasks/Task3/links.txt";

    public static void main(String[] args) {
        Document doc = null;
        int attempts = 0;

        while (attempts < MAX_RETRIES && doc == null) {
            try {
                System.out.println("Попытка подключения #" + (attempts + 1));
                doc = Jsoup.connect(URL).get();
            } catch (IOException e) {
                System.err.println("Ошибка подключения: " + e.getMessage());
                attempts++;
                if (attempts == MAX_RETRIES) {
                    System.err.println("Не удалось подключиться к сайту после " + MAX_RETRIES + " попыток.");
                    return;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {}
            }
        }

        if (doc != null) {
            Elements links = doc.select("a[href]");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
                for (Element link : links) {
                    String href = link.attr("abs:href");
                    writer.write(href);
                    writer.newLine();
                    System.out.println(href);
                }
                System.out.println("Ссылки успешно сохранены в файл: " + OUTPUT_FILE);
            } catch (IOException e) {
                System.err.println("Ошибка записи в файл: " + e.getMessage());
            }
        }
    }
}


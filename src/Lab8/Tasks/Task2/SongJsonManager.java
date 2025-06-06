package Lab8.Tasks.Task2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;

public class SongJsonManager {
    private static final String FILE_PATH = "src/Lab8/Tasks/Task2/songs.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                Выберите действие:
                1. Показать все песни
                2. Найти по автору
                3. Добавить песню
                4. Удалить по названию
                5. Выйти
                """);

            switch (scanner.nextLine()) {
                case "1" -> showAllSongs();
                case "2" -> searchByAuthor(scanner);
                case "3" -> addSong(scanner);
                case "4" -> deleteSong(scanner);
                case "5" -> {
                    System.out.println("Выход.");
                    return;
                }
                default -> System.out.println("Неверный ввод.");
            }
        }
    }

    private static JSONObject loadJson() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONParser parser = new JSONParser();
            return (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при чтении JSON: " + e.getMessage());
        }
    }

    private static void saveJson(JSONObject jsonObject) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(jsonObject.toJSONString());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи JSON: " + e.getMessage());
        }
    }

    private static void showAllSongs() {
        JSONObject root = loadJson();
        JSONArray songs = (JSONArray) root.get("songs");

        ((Stream<Object>) songs.stream())
                .filter(obj -> obj instanceof JSONObject)
                .map(obj -> (JSONObject) obj)
                .forEach(SongJsonManager::printSong);
    }

    private static void searchByAuthor(Scanner scanner) {
        JSONObject root = loadJson();
        JSONArray songs = (JSONArray) root.get("songs");

        System.out.print("Введите имя автора: ");
        String author = scanner.nextLine();

        ((Stream<Object>) songs.stream())
                .filter(obj -> obj instanceof JSONObject)
                .map(obj -> (JSONObject) obj)
                .filter(song -> author.equalsIgnoreCase((String) song.get("author")))
                .forEach(SongJsonManager::printSong);
    }

    private static void addSong(Scanner scanner) {
        JSONObject root = loadJson();
        JSONArray songs = (JSONArray) root.get("songs");

        JSONObject newSong = new JSONObject();

        System.out.print("Введите название песни: ");
        newSong.put("title", scanner.nextLine());

        System.out.print("Введите автора: ");
        newSong.put("author", scanner.nextLine());

        System.out.print("Введите год: ");
        newSong.put("year", Integer.parseInt(scanner.nextLine()));

        songs.add(newSong);
        saveJson(root);
        System.out.println("Песня добавлена.");
    }

    private static void deleteSong(Scanner scanner) {
        JSONObject root = loadJson();
        JSONArray songs = (JSONArray) root.get("songs");

        System.out.print("Введите название песни для удаления: ");
        String titleToDelete = scanner.nextLine();

        Iterator<?> iterator = songs.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj instanceof JSONObject song) {
                if (titleToDelete.equalsIgnoreCase((String) song.get("title"))) {
                    iterator.remove();
                    found = true;
                    break;
                }
            }
        }

        if (found) {
            saveJson(root);
            System.out.println("Песня удалена.");
        } else {
            System.out.println("Песня не найдена.");
        }
    }

    private static void printSong(JSONObject song) {
        System.out.println("   Название: " + song.get("title"));
        System.out.println("   Автор: " + song.get("author"));
        System.out.println("   Год: " + song.get("year"));
        System.out.println();
    }
}

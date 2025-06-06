package Lab8.Tasks.Task1;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class SongXmlManager {
    private static final String FILE_PATH = "src/Lab8/Tasks/Task1/example.xml";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                Выберите действие:
                1. Добавить песню
                2. Поиск по автору
                3. Поиск по году
                4. Удалить песню по названию
                5. Выйти
                """);

            switch (scanner.nextLine()) {
                case "1" -> addSong(scanner);
                case "2" -> searchSongsByAuthor(scanner);
                case "3" -> searchSongsByYear(scanner);
                case "4" -> deleteSongByTitle(scanner);
                case "5" -> {
                    System.out.println("Выход...");
                    return;
                }
                default -> System.out.println("Неверный ввод.");
            }
        }
    }

    private static Document loadDocument() throws Exception {
        File file = new File(FILE_PATH);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(file);
    }

    private static void saveDocument(Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
    }

    private static void addSong(Scanner scanner) throws Exception {
        Document doc = loadDocument();
        Element root = doc.getDocumentElement();

        Element song = doc.createElement("song");

        System.out.print("Введите название: ");
        Element title = doc.createElement("title");
        title.setTextContent(scanner.nextLine());
        song.appendChild(title);

        System.out.print("Введите автора: ");
        Element author = doc.createElement("author");
        author.setTextContent(scanner.nextLine());
        song.appendChild(author);

        System.out.print("Введите год: ");
        Element year = doc.createElement("year");
        year.setTextContent(scanner.nextLine());
        song.appendChild(year);

        root.appendChild(song);
        saveDocument(doc);
        System.out.println("Песня добавлена.");
    }

    private static void searchSongsByAuthor(Scanner scanner) throws Exception {
        Document doc = loadDocument();
        NodeList list = doc.getElementsByTagName("song");

        System.out.print("Введите имя автора: ");
        String authorQuery = scanner.nextLine().toLowerCase();

        for (int i = 0; i < list.getLength(); i++) {
            Element song = (Element) list.item(i);
            String author = song.getElementsByTagName("author").item(0).getTextContent();

            if (author.toLowerCase().contains(authorQuery)) {
                printSong(song);
            }
        }
    }

    private static void searchSongsByYear(Scanner scanner) throws Exception {
        Document doc = loadDocument();
        NodeList list = doc.getElementsByTagName("song");

        System.out.print("Введите год: ");
        String yearQuery = scanner.nextLine();

        for (int i = 0; i < list.getLength(); i++) {
            Element song = (Element) list.item(i);
            String year = song.getElementsByTagName("year").item(0).getTextContent();

            if (year.equals(yearQuery)) {
                printSong(song);
            }
        }
    }

    private static void deleteSongByTitle(Scanner scanner) throws Exception {
        Document doc = loadDocument();
        NodeList list = doc.getElementsByTagName("song");

        System.out.print("Введите название для удаления: ");
        String titleQuery = scanner.nextLine().toLowerCase();

        boolean removed = false;
        for (int i = 0; i < list.getLength(); i++) {
            Element song = (Element) list.item(i);
            String title = song.getElementsByTagName("title").item(0).getTextContent();

            if (title.toLowerCase().equals(titleQuery)) {
                Node parent = song.getParentNode();
                parent.removeChild(song);
                removed = true;
                break;
            }
        }

        if (removed) {
            saveDocument(doc);
            System.out.println("Песня удалена.");
        } else {
            System.out.println("Песня не найдена.");
        }
    }

    private static void printSong(Element song) {
        System.out.println("   Название: " + song.getElementsByTagName("title").item(0).getTextContent());
        System.out.println("   Автор: " + song.getElementsByTagName("author").item(0).getTextContent());
        System.out.println("   Год: " + song.getElementsByTagName("year").item(0).getTextContent());
        System.out.println();
    }
}


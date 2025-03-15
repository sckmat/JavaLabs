package Lab2.Tasks;

import java.util.Scanner;

public class Task3 {
    public static String getEncryptString(String encryptString, int shift) {
        char[] arrayChar = encryptString.toCharArray();
        char[] arrayCharNew = new char[arrayChar.length];

        for (int i = 0; i < arrayChar.length; i++)
            arrayCharNew[i] = (char) (arrayChar[i] + shift);

        return new String(arrayCharNew);
    }

    public static String getDecryptString(String decryptString, int shift) {
        return getEncryptString(decryptString, -shift);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст для шифрования:");
        String text = scanner.nextLine();

        System.out.println("Введите ключ:");
        int shift = scanner.nextInt();
        scanner.nextLine();

        String encryptedText = getEncryptString(text, shift);
        System.out.println("Текст после преобразования: " + encryptedText);

        System.out.println("Выполнить обратное преобразование? (y/n)");
        String response = scanner.nextLine().trim().toLowerCase();

        if (response.equals("y")) {
            String decryptedText = getDecryptString(encryptedText, shift);
            System.out.println("Текст после обратного преобразования: " + decryptedText);
        } else if (response.equals("n")) {
            System.out.println("До свидания!");
        } else {
            System.out.println("Введите корректный ответ.");
        }

        scanner.close();
    }
}

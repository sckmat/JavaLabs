package Lab1.Tasks;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите фамилию: ");
        String surname = in.nextLine();

        System.out.println("Введите имя: ");
        String name = in.nextLine();

        System.out.println("Введите отчество: ");
        String patronymic = in.nextLine();

        System.out.printf("Hello  %s %s %s", surname, name, patronymic);
        in.close();
    }
}

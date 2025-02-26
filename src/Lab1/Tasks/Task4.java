package Lab1.Tasks;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название месяца: ");
        String month = scanner.nextLine();

        System.out.printf("Введите количество дней в месяце %s:", month);
        int days = scanner.nextInt();

        System.out.printf("Месяц %s содержит %s дней", month, days);

        scanner.close();
    }
}

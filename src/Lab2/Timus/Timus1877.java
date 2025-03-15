package Lab2.Timus;

import java.util.Scanner;

public class Timus1877 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String code1 = scanner.nextLine();
        String code2 = scanner.nextLine();

        int thiefCode = 0;
        boolean isFirstLock = true;

        while (thiefCode <= 9999) {
            String currentThiefCode = String.format("%04d", thiefCode);

            if ((isFirstLock && currentThiefCode.equals(code1)) ||
                    (!isFirstLock && currentThiefCode.equals(code2))) {
                System.out.println("yes");
                return;
            }

            isFirstLock = !isFirstLock;
            thiefCode++;
        }

        System.out.println("no");
    }
}

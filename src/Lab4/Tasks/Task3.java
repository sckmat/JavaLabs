package Lab4.Tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            byte[] array = createByteArray();
            byte sum = calculateStrictByteSum(array);
            System.out.println("Сумма элементов: " + sum);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введена строка вместо числа!");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: число за пределами диапазона byte (-128..127)!");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Программа завершена.");
        }
    }

    private static byte[] createByteArray() throws InputMismatchException {
        System.out.print("Введите размер массива: ");
        byte size = readByte();

        if (size <= 0)
            throw new IllegalArgumentException("Размер массива должен быть положительным!");

        byte[] array = new byte[size];
        System.out.println("Введите элементы массива (числа от -128 до 127):");

        for (byte i = 0; i < size; i++)
            array[i] = readByteElement(i);

        return array;
    }

    private static byte readByteElement(byte index) {
        System.out.printf("Элемент [%d]: ", index);
        return readByte();
    }

    private static byte readByte() {
        while (true) {
            try {
                int value = scanner.nextInt();
                if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE)
                    throw new NumberFormatException();
                return (byte) value;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введена строка вместо числа! Повторите ввод.");
                scanner.next();
            }
        }
    }

    private static byte calculateStrictByteSum(byte[] array) {
        byte sum = 0;
        for (byte value : array) {
            if (value > 0 && sum > Byte.MAX_VALUE - value)
                throw new ArithmeticException("Переполнение при суммировании (положительное)!");

            if (value < 0 && sum < Byte.MIN_VALUE - value)
                throw new ArithmeticException("Переполнение при суммировании (отрицательное)!");

            sum += value;
        }
        return sum;
    }
}

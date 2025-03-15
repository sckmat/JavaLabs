package Lab2.Tasks;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner id = new Scanner(System.in);
        System.out.println("Введите размер массива");

        int size = id.nextInt();

        int[] nums = new int[size];
        Random random = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(200);
            System.out.println("Элемент массива [" + i + "] = " + nums[i]);
        }

        int minValue = nums[0];
        for (int num : nums) {
            if (num < minValue) {
                minValue = num;
            }
        }

        ArrayList<Integer> minIndices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minValue) {
                minIndices.add(i);
            }
        }

        System.out.println("Минимальное значение в массиве: " + minValue);
        System.out.println("Индексы элементов с минимальным значением: " + minIndices);
    }
}

package Lab3.Tasks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task6 {

    public static int testArrayList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int currentIndex = 0;
        while (list.size() > 1) {
            currentIndex = (currentIndex + 1) % list.size();
            list.remove(currentIndex);
        }

        return list.getFirst();
    }

    public static int testLinkedList(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int currentIndex = 0;
        while (list.size() > 1) {
            currentIndex = (currentIndex + 1) % list.size();
            list.remove(currentIndex);
        }

        return list.getFirst();
    }

    public static void main(String[] args) {
        int n = 100000;

        long startTime = System.currentTimeMillis();
        int resultArrayList = testArrayList(n);
        long durationArrayList = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        int resultLinkedList = testLinkedList(n);
        long durationLinkedList = System.currentTimeMillis() - startTime;

        if (resultArrayList != resultLinkedList) {
            System.err.println("Результаты не совпадают!");
            return;
        }

        System.out.println("N = " + n);
        System.out.println("Оставшийся (последний выживший): " + resultArrayList);
        System.out.println("\nВремя выполнения:");
        System.out.printf("ArrayList:  %,d мс\n", durationArrayList);
        System.out.printf("LinkedList: %,d мс\n", durationLinkedList);
        System.out.println("\nArrayList быстрее в " + (double) durationLinkedList / durationArrayList + " раз");
    }
}
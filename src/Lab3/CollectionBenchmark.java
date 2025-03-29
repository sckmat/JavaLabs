package Lab3;

import java.util.*;

public class CollectionBenchmark {
    private static final int SIZE = 1_000_000;
    private static final int GET_OPERATIONS = 1_000_000_000;

    public static void main(String[] args) {
        System.out.println("Количество элементов: " + SIZE);
        System.out.println("Операций получения: " + GET_OPERATIONS + "\n");

        System.out.println("=== Время добавления элементов (нс) ===");
        testAddOperations();

        System.out.println("\n=== Время удаления элементов (нс) ===");
        testRemoveOperations();

        System.out.println("\n=== Время получения элементов (нс) ===");
        testGetOperations();
    }

    private static void testAddOperations() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
        }
        long arrayListEnd = System.nanoTime() - start;

        start = System.nanoTime();
        arrayList.addFirst(-1);
        long arrayListStart = System.nanoTime() - start;

        start = System.nanoTime();
        arrayList.add(arrayList.size()/2, -2);
        long arrayListMiddle = System.nanoTime() - start;

        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            linkedHashMap.put(i, i);
        }
        long linkedHashMapTime = System.nanoTime() - start;

        HashSet<Integer> hashSet = new HashSet<>();
        start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            hashSet.add(i);
        }
        long hashSetTime = System.nanoTime() - start;

        System.out.println("ArrayList:");
        System.out.printf("  В начало: %,d нс\n", arrayListStart);
        System.out.printf("  В середину: %,d нс\n", arrayListMiddle);
        System.out.printf("  В конец: %,d нс\n", arrayListEnd);

        System.out.println("LinkedHashMap:");
        System.out.printf("  Добавление: %,d нс\n", linkedHashMapTime);

        System.out.println("HashSet:");
        System.out.printf("  Добавление: %,d нс\n", hashSetTime);
    }

    private static void testRemoveOperations() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
            linkedHashMap.put(i, i);
            hashSet.add(i);
        }

        long start = System.nanoTime();
        arrayList.removeFirst();
        long arrayListFirst = System.nanoTime() - start;

        start = System.nanoTime();
        arrayList.remove(arrayList.size()/2);
        long arrayListMiddle = System.nanoTime() - start;

        start = System.nanoTime();
        arrayList.removeLast();
        long arrayListLast = System.nanoTime() - start;

        start = System.nanoTime();
        linkedHashMap.remove(0);
        long linkedHashMapFirst = System.nanoTime() - start;

        start = System.nanoTime();
        linkedHashMap.remove(SIZE/2);
        long linkedHashMapMiddle = System.nanoTime() - start;

        start = System.nanoTime();
        linkedHashMap.remove(SIZE-1);
        long linkedHashMapLast = System.nanoTime() - start;

        start = System.nanoTime();
        hashSet.remove(0);
        long hashSetFirst = System.nanoTime() - start;

        start = System.nanoTime();
        hashSet.remove(SIZE/2);
        long hashSetMiddle = System.nanoTime() - start;

        start = System.nanoTime();
        hashSet.remove(SIZE-1);
        long hashSetLast = System.nanoTime() - start;

        System.out.println("ArrayList:");
        System.out.printf("  Из начала: %,d нс\n", arrayListFirst);
        System.out.printf("  Из середины: %,d нс\n", arrayListMiddle);
        System.out.printf("  Из конца: %,d нс\n", arrayListLast);

        System.out.println("LinkedHashMap:");
        System.out.printf("  Из начала: %,d нс\n", linkedHashMapFirst);
        System.out.printf("  Из середины: %,d нс\n", linkedHashMapMiddle);
        System.out.printf("  Из конца: %,d нс\n", linkedHashMapLast);

        System.out.println("HashSet:");
        System.out.printf("  Из начала: %,d нс\n", hashSetFirst);
        System.out.printf("  Из середины: %,d нс\n", hashSetMiddle);
        System.out.printf("  Из конца: %,d нс\n", hashSetLast);
    }

    private static void testGetOperations() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
            linkedHashMap.put(i, i);
        }

        long start = System.nanoTime();
        for (int i = 0; i < GET_OPERATIONS; i++) {
            arrayList.get(i % SIZE);
        }
        long arrayListTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < GET_OPERATIONS; i++) {
            linkedHashMap.get(i % SIZE);
        }
        long linkedHashMapTime = System.nanoTime() - start;

        HashSet<Integer> hashSet = new HashSet<>(arrayList);
        start = System.nanoTime();
        for (int i = 0; i < GET_OPERATIONS; i++) {
            hashSet.contains(i % SIZE);
        }
        long hashSetTime = System.nanoTime() - start;

        System.out.printf("ArrayList (по индексу): %,d нс\n", arrayListTime);
        System.out.printf("LinkedHashMap (по ключу): %,d нс\n", linkedHashMapTime);
        System.out.printf("HashSet (проверка наличия): %,d нс\n", hashSetTime);
    }
}

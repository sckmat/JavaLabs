package Lab6.Tasks;

public class Task4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            int threadNumber = i;

            Thread thread = new Thread(() -> {
                System.out.println("Thread " + threadNumber);
            });

            thread.start();
        }
    }
}

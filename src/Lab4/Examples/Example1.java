package Lab4.Examples;

public class Example1 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
        } catch (RuntimeException e) { // исключение перехвачено
            System.out.println("1  "+ e);  // исключение обработано
        }
        System.out.println("2");
    }

}

package Lab4.Examples;

public class Example5 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
        } catch (NullPointerException e) {
            System.out.println("1");
        }
        System.out.println("2");
    }

}

package Lab4.Examples;

public class Example6 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
        } catch (ArithmeticException e) {
            System.out.println("1");
        } catch (Exception e) {
            System.out.println("2");
        }
        System.out.println("4");
    }

}

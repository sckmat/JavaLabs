package Lab3.Examples;

public class Example5 {
    private static int depth = 0;

    public static int fact(int n) {
        printIndent();
        System.out.println("fact(" + n + ") called");
        depth++;

        int result;
        if (n == 0) {
            result = 0;
        } else if (n == 1) {
            result = 1;
        } else {
            result = fact(n - 2) + fact(n - 1);
        }

        depth--;
        printIndent();
        System.out.println("fact(" + n + ") returns " + result);
        return result;
    }

    private static void printIndent() {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
    }

    public static void main(String[] args) {
        System.out.println("Final result: " + fact(5));
    }
}

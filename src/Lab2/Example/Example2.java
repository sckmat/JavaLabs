package Lab2.Example;

public class Example2 {

    public static String getEncryptString(String encryptString, int shift) {
        char[] arrayChar = encryptString.toCharArray();
        char[] arrayCharNew = new char[arrayChar.length];

        for (int i = 0; i < arrayChar.length; i++) {
            arrayCharNew[i] = (char) (arrayChar[i] + shift);
        }

        encryptString = new String(arrayCharNew);

        return encryptString;
    }

    public static void main(String[] args) {
        String originalString = "Hello, World!";
        int shift = 3;
        String encryptedString = getEncryptString(originalString, shift);
        System.out.println("Original: " + originalString);
        System.out.println("Encrypted: " + encryptedString);
    }
}

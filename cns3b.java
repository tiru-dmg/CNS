/* Write a Java program to perform encryption and decryption using the
following algorithms:
Substitution cipher*/
import java.util.Scanner;

public class SubstitutionCipher {
    static String encrypt(String text, int key) {
        return text.chars()
            .map(c -> Character.isLetter(c) ? (Character.isUpperCase(c) ? 
                (c - 'A' + key) % 26 + 'A' : (c - 'a' + key) % 26 + 'a') : c)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = sc.nextLine();
        int key = 3;
        String encrypted = encrypt(input, key);
        String decrypted = encrypt(encrypted, 26 - key);
        System.out.println("Encrypted string: " + encrypted);
        System.out.println("Decrypted string: " + decrypted);
    }
}

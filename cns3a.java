/* Write a Java program to perform encryption and decryption using the
following algorithms:
a) Ceaser Cipher*/


import java.util.*;
public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string");
        String text = sc.nextLine();
        System.out.println("enter key");
        int key = sc.nextInt() % 26;
        String encrypted = cipher(text, key);
        String decrypted = cipher(encrypted, 26 - key);
        System.out.println("encrypted string\n" + encrypted);
        System.out.println("decrypted string\n" + decrypted);
    }
    static String cipher(String text, int key) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c))
                sb.append((char) ('A' + (c - 'A' + key) % 26));
            else if (Character.isLowerCase(c))
                sb.append((char) ('a' + (c - 'a' + key) % 26));
            else
                sb.append(c);
        }
        return sb.toString();
    }
}

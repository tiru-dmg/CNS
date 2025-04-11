/*Calculate the message digest of a text using the SHA-1 algorithm in JAVA.*/
import java.security.MessageDigest;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter plain text: ");
        String text = sc.nextLine();
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] hash = md.digest(text.getBytes());
        StringBuilder hex = new StringBuilder();
        for (byte b : hash) hex.append(String.format("%02x", b));
        System.out.println("original text: " + text);
        System.out.println("SHA-1 HASH: " + hex);
    }
}

/*Write a C/JAVA program to implement the Rijndael algorithm logic.*/
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the string to encrypt: ");
        String input = sc.nextLine();
        String key = "1234567812345678";
        SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, skey);
        byte[] enc = cipher.doFinal(input.getBytes());
        String encrypted = new String(java.util.Base64.getEncoder().encode(enc));
        System.out.println("encrypted text: " + encrypted);

        cipher.init(Cipher.DECRYPT_MODE, skey);
        byte[] dec = cipher.doFinal(java.util.Base64.getDecoder().decode(encrypted));
        System.out.println("decrypted text: " + new String(dec));
    }
}

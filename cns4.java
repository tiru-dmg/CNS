/*Write a Java program to implement the DES algorithm logic.*/
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the string to encrypt:\n");
        String input = sc.nextLine();

        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        SecretKey key = keyGen.generateKey();

        Cipher encCipher = Cipher.getInstance("DES");
        encCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = encCipher.doFinal(input.getBytes());
        String encryptedValue = Base64.getEncoder().encodeToString(encrypted);
        System.out.println("encrypted value: " + encryptedValue);

        Cipher decCipher = Cipher.getInstance("DES");
        decCipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = decCipher.doFinal(Base64.getDecoder().decode(encryptedValue));
        System.out.println("decrypted value: " + new String(decrypted));
    }
}

/*Using Java Cryptography, encrypt the text “Hello world” using BlowFish.
Create your own key using Java keytool.*/

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        String text = "Hello world";
        String keyStr = "sneha"; // 8-56 bytes for Blowfish
        SecretKey key = new SecretKeySpec(keyStr.getBytes(), "Blowfish");

        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(text.getBytes());
        String encryptedText = Base64.getEncoder().encodeToString(encrypted);

        cipher.init(Cipher.DECRYPT_MODE, key);
        String decryptedText = new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText)));

        System.out.println("original text: " + text);
        System.out.println("encrypted text: " + encryptedText);
        System.out.println("decrypted text: " + decryptedText);
    }
}

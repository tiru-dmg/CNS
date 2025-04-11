/*Write a C/JAVA program to implement the BlowFish algorithm logic.*/

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter text to encrypt:");
        String input = sc.nextLine();
        System.out.println("orginal text:" + input);
        String key = "sneha";
        SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, skey);
        byte[] enc = cipher.doFinal(input.getBytes());
        System.out.print("encrypted:[");
        for (int i = 0; i < enc.length; i++) {
            System.out.print(enc[i]);
            if (i < enc.length - 1) System.out.print(",");
        }
        System.out.println("]");
        cipher.init(Cipher.DECRYPT_MODE, skey);
        byte[] dec = cipher.doFinal(enc);
        System.out.println("decrypted:" + new String(dec));
    }
}

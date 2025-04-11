/* Write a Java program to perform encryption and decryption using the
following algorithms:
HILL CIPHER*/

import java.util.*;
public class Main {
    static int modInv(int a, int m) {
        a %= m;
        for (int x = 1; x < m; x++) if ((a * x) % m == 1) return x;
        return -1;
    }
    static int[][] inverse(int[][] m) {
        int det = (m[0][0]*m[1][1] - m[0][1]*m[1][0] + 26) % 26;
        int inv = modInv(det, 26);
        if (inv == -1) return null;
        return new int[][]{
                {m[1][1]*inv % 26, (26 - m[0][1])*inv % 26},
                {(26 - m[1][0])*inv % 26, m[0][0]*inv % 26}
        };
    }
    static String process(String text, int[][] key) {
        if (text.length() % 2 != 0) text += "X";
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            int a = text.charAt(i) - 'A', b = text.charAt(i+1) - 'A';
            int x = (key[0][0]*a + key[0][1]*b) % 26;
            int y = (key[1][0]*a + key[1][1]*b) % 26;
            res.append((char)(x+'A')).append((char)(y+'A'));
        }
        return res.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER KEY 2x2 MATRIX:");
        int[][] key = new int[2][2];
        for (int i = 0; i < 2; i++) for (int j = 0; j < 2; j++) key[i][j] = sc.nextInt();
        System.out.println("ENTER PLAIN TEXT:");
        String plain = sc.next().toUpperCase();
        String cipher = process(plain, key);
        System.out.println("CIPHER TEXT: " + cipher);
        int[][] invKey = inverse(key);
        if (invKey == null) {
            System.out.println("DECRYPTION NOT POSSIBLE: KEY MATRIX NOT INVERTIBLE");
        } else {
            String decrypted = process(cipher, invKey);
            System.out.println("DECRYPTED TEXT: " + decrypted);
        }
    }
}

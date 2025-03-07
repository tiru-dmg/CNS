import java.util.*;

public class Main {
    private static final int N = 2;
    private static int[][] key = new int[N][N], invKey = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2x2 Key Matrix:");
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) key[i][j] = sc.nextInt();

        System.out.println("Enter plaintext:");
        String text = sc.next().toUpperCase();
        if (text.length() % 2 != 0) text += "X";
        sc.close();

        String cipher = encrypt(text);
        System.out.println("Ciphertext: " + cipher);

        System.out.println(calcInvKey() ? "Decrypted text: " + decrypt(cipher) : "Key Matrix is not invertible. Exiting.");
    }

    private static String encrypt(String text) { return process(text, key); }
    private static String decrypt(String text) { return process(text, invKey); }

    private static String process(String text, int[][] mat) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < text.length(); i += N) {
            int[] pair = {text.charAt(i) - 'A', text.charAt(i + 1) - 'A'}, resPair = new int[N];
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++) resPair[j] = (resPair[j] + mat[j][k] * pair[k]) % 26;
            res.append((char) (resPair[0] + 'A')).append((char) (resPair[1] + 'A'));
        }
        return res.toString();
    }

    private static boolean calcInvKey() {
        int det = (key[0][0] * key[1][1] - key[0][1] * key[1][0] + 26) % 26, detInv = -1;
        for (int i = 1; i < 26; i++) if ((det * i) % 26 == 1) { detInv = i; break; }
        if (detInv == -1) return false;
        invKey[0][0] = key[1][1] * detInv % 26;
        invKey[0][1] = (-key[0][1] * detInv % 26 + 26) % 26;
        invKey[1][0] = (-key[1][0] * detInv % 26 + 26) % 26;
        invKey[1][1] = key[0][0] * detInv % 26;
        return true;
    }
}

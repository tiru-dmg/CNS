import java.util.Scanner;

public class SubstitutionCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any string: ");
        String input = sc.nextLine().toLowerCase();
        
        String a = "abcdefghijklmnopqrstuvwxyz";
        String b = "zyxwvutsrqponmlkjihgfedcba";
        
        String encrypted = transform(input, a, b);
        String decrypted = transform(encrypted, b, a);
        
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
        
        sc.close();
    }

    public static String transform(String text, String from, String to) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            int index = from.indexOf(c);
            result.append(index != -1 ? to.charAt(index) : c);
        }
        return result.toString();
    }
}

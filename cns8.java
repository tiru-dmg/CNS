/*Write a Java program to implement RSA Algoithm.*/
import java.math.BigInteger;
import java.util.Scanner;
import java.security.SecureRandom;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter two prime numbers:");
        BigInteger p = sc.nextBigInteger(), q = sc.nextBigInteger();
        BigInteger n = p.multiply(q), phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = BigInteger.probablePrime(8, new SecureRandom());
        while (!phi.gcd(e).equals(BigInteger.ONE)) e = e.add(BigInteger.ONE);
        BigInteger d = e.modInverse(phi);
        System.out.println("public key(e,n): " + e + "," + n);
        System.out.println("private key(d,n): " + d + "," + n);
        System.out.println("enter a number:");
        BigInteger msg = sc.nextBigInteger();
        BigInteger enc = msg.modPow(e, n);
        BigInteger dec = enc.modPow(d, n);
        System.out.println("original: " + msg);
        System.out.println("encrypted: " + enc);
        System.out.println("decrypted: " + dec);
    }
}

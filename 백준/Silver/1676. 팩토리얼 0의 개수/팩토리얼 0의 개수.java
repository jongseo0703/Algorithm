import java.io.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        BigInteger N = new BigInteger(br.readLine());

        BigInteger fact = factorial(N);

        String s;

        s = fact.toString();

        char[] c = new char[s.length()];

        for(int i = 0; i < c.length; i++) {
            c[c.length - 1 - i] = s.charAt(i);
        }

        int zeroCount = 0;

        for(int i = 0; i < c.length; i++) {
            if(c[i] == '0') zeroCount++;
            else break;
        }

        sb.append(zeroCount);

        System.out.print(sb);

    }

    public static BigInteger factorial(BigInteger N) {

        if(N.equals(BigInteger.ZERO) || N.equals(BigInteger.ONE)) return BigInteger.ONE;
        else return N.multiply(factorial(N.subtract(BigInteger.ONE)));
    }

}
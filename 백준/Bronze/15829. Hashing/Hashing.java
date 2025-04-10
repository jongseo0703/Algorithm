import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int L = Integer.parseInt(br.readLine());

        HashMap<Character, Long> map = new HashMap<>();

        for(long i = 1; i <= 26; i++) {
            map.put((char)('a' + i - 1), i);
        }

        char[] c = new char[L];

        String k = br.readLine();

        for(int i = 0; i < c.length; i++) {
            c[i] = k.charAt(i);
        }

        long sumHashing = 0;
        int mod = 1234567891;

        for(int i = 0; i < c.length; i++) {
            sumHashing += map.get(c[i]) * multiple(L, i);
            sumHashing %= mod;
        }

        sb.append(sumHashing);

        System.out.print(sb);

    }

    public static long multiple(int L, int n) {

        long multi = 1;
        int mod = 1234567891;
        for(int i = L - n; i < L; i++) {
            multi *= 31;
            multi %= mod;
        }

        return multi;

    }

}
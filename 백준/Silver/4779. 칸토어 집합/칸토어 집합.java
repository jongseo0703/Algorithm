import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String k;

        while ((k = br.readLine()) != null && !k.isEmpty()) {

            int N = Integer.parseInt(k);

            int length = (int)Math.pow(3, N);

            char[] c = new char[length];

            for (int i = 0; i < c.length; i++) {
                c[i] = '-';
            }

            makeBar(0, length, c);

            for (int i = 0; i < c.length; i++) {
                sb.append(c[i]);
            }

            sb.append("\n");

        }

        System.out.print(sb);

    }

    public static void makeBar(int start, int length, char[] c) {

        if(length == 1) return;

        length /= 3;

        for (int i = start + length; i < start + 2 * length; i++) {
            c[i] = ' ';
        }

        makeBar(start, length, c);
        makeBar(start + 2 * length, length, c);

    }

}
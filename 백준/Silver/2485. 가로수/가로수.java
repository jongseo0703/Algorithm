import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr1 = new int[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(br.readLine());
        }

        int gcd = 0;
        for (int i = 0; i < N - 1; i++) {
            int distance = arr1[i+1] - arr1[i];
            gcd = gcd(distance, gcd);
        }

        int count = 0;

        for (int i = arr1[0]; i <= arr1[N-1];) {
            count++;
            i += gcd;
        }

        bw.write((count-N) + "\n");
        bw.flush();
        bw.close();

    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

}
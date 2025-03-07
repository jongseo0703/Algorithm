import java.util.*;
import java.io.*;

public class Main {

    static final int MAX = 1_000_000;
    static boolean[] isPrime = new boolean[MAX];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sieveOfEratosthenes();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int n = Integer.parseInt(br.readLine());
            int count = CountGoldBachPatitions(n);
            bw.write(count + "\n");

        }

        bw.flush();
        bw.close();

    }

    public static void sieveOfEratosthenes() {
        for (int i = 2; i < MAX; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static int CountGoldBachPatitions(int n) {

        int count = 0;

        for (int i = 2; i <= n / 2; i++) {
            if (isPrime[i] && isPrime[n-i]) {
                count++;
            }
        }

        return count;

    }

}
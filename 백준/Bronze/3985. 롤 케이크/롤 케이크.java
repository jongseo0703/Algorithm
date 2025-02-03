import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] rollCake = new boolean[L];

        for (int i = 0; i < L; i++) {
            rollCake[i] = false;
        }

        int[] counts = new int[N];
        for (int i = 0; i < N; i++) {
            counts[i] = 0;
        }

        int MAX = 0;
        int maxIndex = 0;

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            if (K - P > MAX) {
                MAX = K - P;
                maxIndex = i;
            }

            for (int j = P - 1; j <= K -1; j++) {

                if (rollCake[j] == false) {
                    rollCake[j] = true;
                    counts[i]++;
                }

            }

        }

        int realMax = counts[0];
        int realMaxIndex = 0;
        for (int i = 1; i < N; i++) {
            if (counts[i] > realMax) {
                realMax = counts[i];
                realMaxIndex = i;
            }
        }
        bw.write(maxIndex + 1 + "\n");
        bw.write(realMaxIndex + 1 + "\n");
        bw.flush();
        bw.close();


    }

}
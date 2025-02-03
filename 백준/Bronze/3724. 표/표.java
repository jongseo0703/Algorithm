import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            BigInteger MAX = BigInteger.ONE;
            int maxIndex = 0;

            int[][] arr = new int[N][M];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            MAX = BigInteger.ONE;
            for (int j = 0; j < N; j++) {
                MAX = MAX.multiply(BigInteger.valueOf(arr[j][0]));
            }

            for (int j = 0; j < M; j++) {
                BigInteger MULTI = BigInteger.ONE;
                for (int k = 0; k < N; k++) {
                    MULTI = MULTI.multiply(BigInteger.valueOf(arr[k][j]));
                }
                if (MULTI.compareTo(MAX) >= 0) {
                    MAX = MULTI;
                    maxIndex = j + 1;
                }
            }

            bw.write(maxIndex + "\n");
        }

        bw.flush();
        bw.close();
    }
}
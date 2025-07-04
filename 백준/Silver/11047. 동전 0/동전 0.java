import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int totalCount = 0;

        for(int i = N - 1; i >= 0; i--) {
            if(K >= arr[i]) {
                totalCount += K / arr[i];
                K %= arr[i];
            }
        }

        sb.append(totalCount);

        System.out.print(sb);

    }

}
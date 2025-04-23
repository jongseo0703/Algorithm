import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        arr[0] = 1;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i + 1] = arr[i] + Integer.parseInt(st.nextToken());
        }

        for(int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int range1 = Integer.parseInt(st.nextToken());
            int range2 = Integer.parseInt(st.nextToken());
            int sum = arr[range2] - arr[range1 - 1];
            sb.append(sum).append("\n");
        }

        System.out.print(sb);

    }

}
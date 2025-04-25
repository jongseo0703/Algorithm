import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        long min = 0;
        long max = 0;
        long mid;

        for(int i = 0; i < K; i++) {
            int number = Integer.parseInt(br.readLine());
            arr[i] = number;
            if(max < number) {
                max = number;
            }
        }
        max++;
        long n;
        while(min < max) {
            n = 0;
            mid = (min + max) / 2;

            for(int i = 0; i < K; i++) {
                n += arr[i] / mid;
            }

            if(n < N) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        sb.append(min - 1);

        System.out.print(sb);

    }

}
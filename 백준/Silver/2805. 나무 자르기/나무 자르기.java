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

        int min = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());

        int[] tree = new int[N];

        for(int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());

            if(max < tree[i]) max = tree[i];
        }

        while(min < max) {
            int mid = (min + max) / 2;
            long sum = 0;

            for(int woodHeight : tree) {
                if((woodHeight - mid > 0)) {
                    sum += woodHeight - mid;
                }
            }

            if(sum < M) {
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
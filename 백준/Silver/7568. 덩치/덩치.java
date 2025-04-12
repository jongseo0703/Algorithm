import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] weight = new int[N];
        int[] height = new int[N];
        int[] rank = new int[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            weight[i] = w;
            height[i] = h;
        }

        for(int i = 0; i < N; i++) {
            int cnt = 1;
            for(int j = 0; j < N; j++) {
                if(i == j) continue;

                if(weight[i] < weight[j] && height[i] < height[j]) cnt++;
            }
            rank[i] = cnt;
        }

        for(int i = 0; i < N; i++) {
            sb.append(rank[i]).append(" ");
        }

        System.out.print(sb);

    }

}
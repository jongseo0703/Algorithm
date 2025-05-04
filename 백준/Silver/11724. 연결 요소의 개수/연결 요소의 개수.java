import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int count = 0;
    static int[][] node;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        node = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a][b] = node[b][a] = 1;
        }

        for(int i = 1; i <= N; i++) {
            if(!(isVisited[i])) {
                dfs(i);
                count++;
            }
        }

        sb.append(count);

        System.out.print(sb);

    }

    static void dfs(int index) {
        isVisited[index] = true;

        for(int i = 1; i <= N; i++) {
            if(node[index][i] == 1 && !isVisited[i]) {
                dfs(i);
            }
        }
    }

}
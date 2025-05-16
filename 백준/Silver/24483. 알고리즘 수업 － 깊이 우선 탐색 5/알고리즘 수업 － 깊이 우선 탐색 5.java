import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] isVisited;
    static long[] depth;
    static long[] order;
    static int cnt = 1;

    static int N, M, R;

    public static void main(String[] args) throws IOException {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        isVisited = new boolean[N + 1];
        depth = new long[N + 1];
        order = new long[N + 1];

        Arrays.fill(depth, -1);

        for(int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        for(int i = 1; i < N + 1; i++) {
            Collections.sort(list.get(i));
        }

        long sum = 0;

        dfs(R, 0);

        for(int i = 1; i < N + 1; i++) {
            sum += (order[i] * depth[i]);
        }

        sb.append(sum);

        System.out.print(sb);

    }

    static void dfs(int node, int d) {
        isVisited[node] = true;
        depth[node] = d;
        order[node] = cnt++;

        for(int i : list.get(node)) {
            if(!isVisited[i]) {
                dfs(i, d + 1);
            }
        }
    }

}
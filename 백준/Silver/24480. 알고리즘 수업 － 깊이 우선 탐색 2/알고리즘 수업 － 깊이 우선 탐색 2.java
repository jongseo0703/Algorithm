import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> al;
    static boolean[] isVisited;
    static int[] order;

    static int cnt = 1;

    static int N, M, R;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N + 1];
        order = new int[N + 1];
        al = new ArrayList<>();

        for(int i = 0; i < N + 1; i++) {
            al.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            al.get(x).add(y);
            al.get(y).add(x);
        }

        for(int i = 1; i < N + 1; i++) {
            al.get(i).sort(Comparator.reverseOrder());
        }

        dfs(R);

        for(int i = 1; i < N + 1; i++) {
            sb.append(order[i]).append("\n");
        }

        System.out.print(sb);

    }

    static void dfs(int node) {
        isVisited[node] = true;
        order[node] = cnt++;

        for(int i : al.get(node)) {
            if(!isVisited[i]) {
                dfs(i);
            }
        }
    }

}
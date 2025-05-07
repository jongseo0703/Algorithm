import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] list;
    static boolean[] isVisited;
    static int[] parent;

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        isVisited = new boolean[N + 1];
        parent = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for(int i = 2; i < N + 1; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.print(sb);

    }

    static void dfs(int index) {
        isVisited[index] = true;

        for(int i : list[index]) {
            if(!isVisited[i]) {
                parent[i] = index;
                dfs(i);
            }
        }
    }

}
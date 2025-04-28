import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb;

    static int N, M, V;

    static int count = 0;

    static boolean[] visited;
    static int[][] map;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[1001][1001];
        visited = new boolean[1001];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[y][x] = map[x][y] = 1;
        }

        dfs(V);
        sb.append("\n");
        visited = new boolean[1001];

        bfs(V);

        System.out.print(sb);

    }

    static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        if(N == count) {
            return;
        }
        count++;

        for(int i = 1; i <= N; i++) {
            if(map[start][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while(!(queue.isEmpty())) {
            int now = queue.poll();

            for(int i = 1; i <= N; i++) {
                if(map[now][i] == 1 && visited[i] == false) {
                    queue.offer(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }

    }

}
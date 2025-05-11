import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[] isVisited;

    static int n, p1, p2, m;

    static int result = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        isVisited = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());

        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }

        dfs(p1, 0);

        sb.append(result);

        System.out.print(sb);

    }

    static void dfs(int index, int depth) {
        isVisited[index] = true;

        if(index == p2) {
            result = depth;
            return;
        }

        for(int i = 1; i < n + 1; i++) {
            if(map[index][i] == 1 & !isVisited[i]) {
                dfs(i, depth + 1);
            }
        }
    }

}
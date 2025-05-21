import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static char[][] map;
    static boolean[][] isVisited;

    static int M, N;

    static boolean flag = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        isVisited = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            String k = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = k.charAt(j);
            }
        }

        for(int i = 0; i < N; i++) {
            if(map[0][i] != '1') {
                dfs(0, i);
            }
        }

        if(flag) {
            sb.append("YES");
        }
        else {
            sb.append("NO");
        }

        System.out.print(sb);

    }

    static void dfs(int y, int x) {
        isVisited[y][x] = true;

        if(y == M - 1) {
            flag = true;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int dx = dirX[i] + x;
            int dy = dirY[i] + y;

            if(checkArray(dy, dx)) {
                if(map[dy][dx] != '1' && !isVisited[dy][dx]) {
                    dfs(dy, dx);
                }
            }
        }
    }

    static boolean checkArray(int dy, int dx) {
        if(dy >= 0 && dx >= 0 && dy < M && dx < N) {
            return true;
        }
        else {
            return false;
        }
    }

}
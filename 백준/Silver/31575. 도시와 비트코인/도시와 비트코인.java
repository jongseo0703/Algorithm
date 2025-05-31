import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 1};
    static int[] dirY = {1, 0};

    static int[][] map;
    static boolean[][] isVisited;

    static int N, M;

    static boolean flag = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        isVisited = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        if(flag) {
            sb.append("Yes");
        }
        else {
            sb.append("No");
        }

        System.out.print(sb);

    }

    static void dfs(int y, int x) {
        isVisited[y][x] = true;

        if(y == M - 1 && x == N - 1) {
            flag = true;
        }

        for(int i = 0; i < 2; i++) {
            int dx = dirX[i] + x;
            int dy = dirY[i] + y;

            if(checkArray(dy, dx)) {
                if(!isVisited[dy][dx] && map[dy][dx] != 0) {
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
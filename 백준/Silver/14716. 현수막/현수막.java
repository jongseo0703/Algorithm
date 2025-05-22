import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dirY = {-1, 1, 0, 0, -1, 1, 1, -1};

    static int[][] map;
    static boolean[][] isVisited;

    static int M, N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        isVisited = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !isVisited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        dfs(0, 0);

        sb.append(count);

        System.out.print(sb);

    }

    static void dfs(int y, int x) {
        isVisited[y][x] = true;

        for(int i = 0; i < 8; i++) {
            int dx = dirX[i] + x;
            int dy = dirY[i] + y;

            if(checkArray(dy, dx)) {
                if(map[dy][dx] == 1 && !isVisited[dy][dx]) {
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
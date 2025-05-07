import java.io.*;
import java.util.*;

public class Main {

    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static int[][] map;
    static boolean[][] isVisited;

    static int N, safeCount, max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        safeCount = 0;
        max = 0;

        int maxSafe = 0;

        map = new int[N][N];
        isVisited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if(max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }
        for(int k = 0; k <= max; k++) {
            isVisited = new boolean[N][N];
            safeCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > k && !isVisited[i][j]) {
                        dfs(i, j, k);
                        safeCount++;
                    }
                }
            }
            maxSafe = Math.max(safeCount, maxSafe);
        }

        sb.append(maxSafe);

        System.out.print(sb);

    }

    static void dfs(int x, int y, int height) {
        isVisited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int dx = dirX[i] + x;
            int dy = dirY[i] + y;
            if(checkIndex(dx, dy)) {
                if (map[dx][dy] > height && !isVisited[dx][dy]) {
                    dfs(dx, dy, height);
                }
            }
        }
    }

    static boolean checkIndex(int dx, int dy) {
        if(dx >= 0 && dy >= 0 && dx < N && dy < N) {
            return true;
        }
        else {
            return false;
        }
    }

}
import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static char[][] map;
    static boolean[][] isVisited;

    static int count = 0;

    static int R, C, K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        isVisited = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            String k = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = k.charAt(j);

            }
        }

        isVisited[R - 1][0] = true;
        dfs(R - 1, 0, 1);

        sb.append(count);

        System.out.print(sb);

    }

    static void dfs(int y, int x, int depth) {

        if(depth == K && x == C - 1 && y == 0) {
            count++;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int dx = dirX[i] + x;
            int dy = dirY[i] + y;

            if(checkArray(dy, dx)) {
                if(map[dy][dx] != 'T' && !isVisited[dy][dx]) {
                    isVisited[dy][dx] = true;
                    dfs(dy, dx, depth + 1);
                    isVisited[dy][dx] = false;
                }
            }
        }
    }

    static boolean checkArray(int dy, int dx) {
        if(dy >= 0 && dx >= 0 && dy < R && dx < C) {
            return true;
        }
        else {
            return false;
        }
    }

}
import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static char[][] map;
    static boolean[] alpha = new boolean[26];

    static int R, C;

    static int maxCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for(int i = 0; i < R; i++) {
            String k = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = k.charAt(j);
            }
        }
        alpha[map[0][0] - 'A'] = true;

        dfs(0, 0, 1);

        sb.append(maxCount);

        System.out.print(sb);

    }

    static void dfs(int x, int y, int count) {
        maxCount = Math.max(maxCount, count);

        for(int i = 0; i < 4; i++) {
            int dx = dirX[i] + x;
            int dy = dirY[i] + y;

            if(checkArray(dx, dy)) {
                int idx = map[dx][dy] - 'A';
                if (!alpha[idx]) {
                    alpha[idx] = true;
                    dfs(dx, dy, count + 1);
                    alpha[idx] = false;
                }
            }
        }
    }

    static boolean checkArray(int dx, int dy) {
        if(dx >= 0 && dy >= 0 && dx < R && dy < C) {
            return true;
        }
        else {
            return false;
        }
    }

}
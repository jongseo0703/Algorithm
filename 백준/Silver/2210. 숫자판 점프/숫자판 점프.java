import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static int[][] map;
    static Set<String> set;

    static String k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        map = new int[5][5];
        set = new HashSet<>();

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                dfs(i, j, 0,String.valueOf(map[i][j]));
            }
        }

        sb.append(set.size());

        System.out.print(sb);

    }

    static void dfs(int y, int x, int depth, String k) {
        if(depth == 5) {
            set.add(k);
            return;
        }

        for (int j = 0; j < 4; j++) {
            int dx = dirX[j] + x;
            int dy = dirY[j] + y;

            if (checkArray(dy, dx)) {
                dfs(dy, dx, depth + 1, k + map[dy][dx]);
            }
        }

    }

    static boolean checkArray(int dy, int dx) {
        if(dy >= 0 && dx >= 0 && dy < 5 && dx < 5) {
            return true;
        }
        else {
            return false;
        }
    }

}
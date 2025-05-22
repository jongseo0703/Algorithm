import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 1};
    static int[] dirY = {1, 0};

    static int[][] map;
    static boolean[][] isVisited;

    static boolean flag;

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        isVisited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        flag = false;

        dfs(0,0);

        if(flag) {
            sb.append("HaruHaru");
        }
        else {
            sb.append("Hing");
        }

        System.out.print(sb);

    }

    static void dfs(int y, int x) {
        isVisited[y][x] = true;

        if(map[y][x] == -1) {
            flag = true;
            return;
        }

        int jump = map[y][x];

        for(int i = 0; i < 2; i++) {
            int dx = dirX[i] * jump + x;
            int dy = dirY[i] * jump + y;

            if(checkArray(dy, dx)) {
                if(!isVisited[dy][dx]) {
                    dfs(dy, dx);
                }
            }
        }
    }

    static boolean checkArray(int dy, int dx) {
        if(dy >= 0 && dx >= 0 && dy < N && dx < N) {
            return true;
        }
        else {
            return false;
        }
    }

}
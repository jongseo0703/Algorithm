import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static int[][] map;
    static boolean[][] isVisited;
    static ArrayList<Integer> list;

    static int N, M, K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        isVisited = new boolean[N + 1][M + 1];
        list = new ArrayList<>();

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
        }

        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < M + 1; j++) {
                if(map[i][j] == 1 && !isVisited[i][j]) {
                    int count = dfs(i, j);
                    list.add(count);
                }
            }
        }

        sb.append(Collections.max(list));

        System.out.print(sb);

    }

    static int dfs(int y, int x) {
        isVisited[y][x] = true;
        int count = 1;

        for(int i = 0; i < 4; i++) {
            int dx = dirX[i] + x;
            int dy = dirY[i] + y;
            if(checkArray(dy, dx)) {
                if(map[dy][dx] == 1 && !isVisited[dy][dx]) {
                    count += dfs(dy, dx);
                }
            }
        }

        return count;
    }

    static boolean checkArray(int dy, int dx) {
        if(dy >= 0 && dx >= 0 && dy < N + 1 && dx < M + 1) {
            return true;
        }
        else {
            return false;
        }
    }

}
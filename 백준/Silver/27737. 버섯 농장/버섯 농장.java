import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static int[][] map;
    static boolean[][] isVisited;

    static int N, M, K;

    static int mushroomCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        isVisited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 0 && !isVisited[i][j]) {
                    int mapSize = dfs(i, j);
                    int neededMushroom = (mapSize + K - 1) / K;
                    mushroomCount += neededMushroom;
                }
            }
        }

        if(mushroomCount == 0 || mushroomCount > M) {
            sb.append("IMPOSSIBLE");
        }
        else {
            sb.append("POSSIBLE\n").append(M - mushroomCount);
        }

        System.out.print(sb);

    }

    static int dfs(int y, int x) {
        isVisited[y][x] = true;
        int count = 1;

        for(int i = 0; i < 4; i++) {
            int dx = dirX[i] + x;
            int dy = dirY[i] + y;

            if(checkArray(dy, dx)) {
                if(!isVisited[dy][dx] && map[dy][dx] != 1) {
                    count += dfs(dy, dx);
                }
            }
        }

        return count;
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
import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static int[][] map;
    static boolean[][] isVisited;

    static int N, M;

    static int maxSafe = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWall(0);

        sb.append(maxSafe);

        System.out.print(sb);

    }

    static void buildWall(int wallCount) {
        if(wallCount == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(wallCount + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        int[][] temp = new int[N][M];
        for(int i = 0; i < N; i++) {
            temp[i] = map[i].clone();
        }
        int safeCount = 0;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(temp[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int curY = now[0];
            int curX = now[1];

            for(int i = 0; i < 4; i++) {
                int dy = curY + dirY[i];
                int dx = curX + dirX[i];

                if(checkArray(dy, dx)) {
                    if(temp[dy][dx] == 0) {
                        temp[dy][dx] = 2;
                        queue.add(new int[]{dy, dx});
                    }
                }
            }

        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(temp[i][j] == 0) {
                    safeCount++;
                }
            }
        }

        maxSafe = Math.max(safeCount, maxSafe);
    }

    static boolean checkArray(int dy, int dx) {
        if(dy >= 0 && dx >= 0 && dy < N && dx < M) {
            return true;
        }
        else {
            return false;
        }
    }

}
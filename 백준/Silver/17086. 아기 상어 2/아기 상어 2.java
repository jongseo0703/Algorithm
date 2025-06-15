import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, -1, -1, 1, 1, 1};
    static int[] dirY = {-1, 1, 0, -1, 1, 0, -1, 1};

    static int[][] map;
    static boolean[][] isVisited;

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxDistance = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    maxDistance = Math.max(maxDistance, bfs(i, j));
                }
            }
        }

        sb.append(maxDistance);

        System.out.print(sb);

    }

    static int bfs(int y, int x) {
        isVisited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x, 0});
        isVisited[y][x] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int curX = now[1];
            int curY = now[0];
            int dist = now[2];

            if(map[curY][curX] == 1) {
                return dist;
            }

            for(int i = 0; i < 8; i++) {
                int dx = dirX[i] + curX;
                int dy = dirY[i] + curY;

                if(checkArray(dy, dx)) {
                    if(!isVisited[dy][dx]) {
                        isVisited[dy][dx] = true;
                        queue.add(new int[]{dy, dx, dist + 1});
                    }
                }
            }
        }
        return 0;
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
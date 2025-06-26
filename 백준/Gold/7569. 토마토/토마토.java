import java.io.*;
import java.util.*;

public class Main {
    static int[] dirZ = {0, 0, 0, 0, -1, 1};
    static int[] dirX = {0, 0, -1, 1, 0, 0};
    static int[] dirY = {-1, 1, 0, 0, 0, 0};

    static int[][][] map;

    static int M, N, H;

    static int maxDate;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        for(int h = 0; h < H; h++) {
            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m = 0; m < M; m++) {
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                }
            }
        }

        bfs();

        sb.append(maxDate);

        System.out.print(sb);

    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        for(int h = 0; h < H; h++) {
            for(int n = 0; n < N; n++) {
                for(int m = 0; m < M; m++) {
                    if(map[h][n][m] == 1) {
                        queue.add(new int[]{h, n, m, 0});
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int curZ = now[0];
            int curY = now[1];
            int curX = now[2];
            int curDate = now[3];

            maxDate = Math.max(maxDate, curDate);

            for(int i = 0; i < 6; i++) {
                int dz = curZ + dirZ[i];
                int dy = curY + dirY[i];
                int dx = curX + dirX[i];

                if(checkArray(dz, dy, dx)) {
                    if(map[dz][dy][dx] == 0) {
                        map[dz][dy][dx] = 1;
                        queue.add(new int[]{dz, dy, dx, curDate + 1});
                    }
                }
            }
        }

        for(int h = 0; h < H; h++) {
            for(int n = 0; n < N; n++) {
                for(int m = 0; m < M; m++) {
                    if(map[h][n][m] == 0) {
                        maxDate = -1;
                        return;
                    }
                }
            }
        }
    }

    static boolean checkArray(int dz, int dy, int dx) {
        if(dz >= 0 && dy >= 0 && dx >= 0 && dz < H && dy < N && dx < M) {
            return true;
        }
        else {
            return false;
        }
    }

}
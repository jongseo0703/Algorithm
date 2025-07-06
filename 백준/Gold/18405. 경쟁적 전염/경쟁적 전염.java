import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static int[][] map;

    static int N, K;
    static int S, X, Y;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        bfs();

        sb.append(map[X - 1][Y - 1]);

        System.out.print(sb);

    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 1; i <= K; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    if(map[j][k] == i) {
                        queue.add(new int[]{j, k, 0});
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int curY = now[0];
            int curX = now[1];
            int curTime = now[2];

            if(curTime == S) {
                break;
            }

            for(int i = 0; i < 4; i++) {
                int dy = curY + dirY[i];
                int dx = curX + dirX[i];
                if(checkArray(dy, dx)) {
                    if(map[dy][dx] == 0) {
                        map[dy][dx] = map[curY][curX];
                        queue.add(new int[]{dy, dx, curTime + 1});
                    }
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
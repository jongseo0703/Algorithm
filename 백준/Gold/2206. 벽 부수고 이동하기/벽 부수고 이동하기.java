import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static char[][] map;

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i = 0; i < N; i++) {
            String k = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = k.charAt(j);
            }
        }

        sb.append(bfs(0, 0));

        System.out.print(sb);

    }

    static int bfs(int y, int x) {
        int[][][] dist = new int[N][M][2];
        for(int[][] layer : dist) {
            for(int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        Deque<int[]> deque = new ArrayDeque<>();
        dist[0][0][0] = 1;
        deque.add(new int[]{0, 0, 0});

        while(!deque.isEmpty()) {
            int[] now = deque.poll();
            int curY = now[0];
            int curX = now[1];
            int brk = now[2];

            if(curY == N - 1 && curX == M - 1) {
                return dist[curY][curX][brk];
            }

            for(int i = 0; i < 4; i++) {
                int dy = curY + dirY[i];
                int dx = curX + dirX[i];

                if(checkArray(dy, dx)) {
                    if(map[dy][dx] == '0' && dist[dy][dx][brk] == -1) {
                        dist[dy][dx][brk] = dist[curY][curX][brk] + 1;
                        deque.add(new int[]{dy, dx, brk});
                    }
                }

                if(checkArray(dy, dx)) {
                    if(map[dy][dx] == '1' && brk == 0 && dist[dy][dx][1] == -1) {
                        dist[dy][dx][1] = dist[curY][curX][0] + 1;
                        deque.add(new int[]{dy, dx, 1});
                    }
                }
            }
        }
        return -1;
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
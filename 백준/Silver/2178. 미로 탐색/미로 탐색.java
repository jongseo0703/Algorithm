import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

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
        isVisited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String k = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = k.charAt(j) - '0';
            }
        }

        sb.append(bfs(0, 0));

        System.out.print(sb);

    }

    static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        isVisited[y][x] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int cx = now[1];
            int cy = now[0];

            for (int i = 0; i < 4; i++) {
                int dx = dirX[i] + cx;
                int dy = dirY[i] + cy;

                if (checkArray(dy, dx)) {
                    if (!isVisited[dy][dx] && map[dy][dx] == 1) {
                        isVisited[dy][dx] = true;
                        map[dy][dx] = map[cy][cx] + 1;
                        queue.add(new int[]{dy, dx});
                    }
                }
            }
        }

        return map[N - 1][M - 1];
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
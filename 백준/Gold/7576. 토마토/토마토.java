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

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        isVisited = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 0) {
                    System.out.print("-1");
                    return;
                }
            }
        }

        System.out.print(result);

    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int maxDate = 0;

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    queue.add(new int[]{i, j, 0});
                    isVisited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int curY = now[0];
            int curX = now[1];
            int curDate = now[2];

            maxDate = Math.max(maxDate, curDate);

            for(int i = 0; i < 4; i++) {
                int dy = curY + dirY[i];
                int dx = curX + dirX[i];

                if(checkArray(dy, dx)) {
                    if(!isVisited[dy][dx] && map[dy][dx] == 0) {
                        isVisited[dy][dx] = true;
                        map[dy][dx] = 1;
                        queue.add(new int[]{dy, dx, curDate + 1});
                    }
                }
            }
        }
        return maxDate;
    }

    static boolean checkArray(int dy, int dx) {
        if(dy >= 0 && dx >= 0 && dy < M && dx < N) {
            return true;
        }
        else {
            return false;
        }
    }

}
import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static char[][] map;
    static boolean[][] isVisited;
    static int[][] timeMap;

    static int H, W;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        timeMap = new int[H][W];

        for(int i = 0; i < H; i++) {
            Arrays.fill(timeMap[i], 0);
        }

        for(int i = 0; i < H; i++) {
            String k = br.readLine();
            for(int j = 0; j < W; j++) {
                map[i][j] = k.charAt(j);
            }
        }

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                if(map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        int max = 0;

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                if(max < timeMap[i][j]) {
                    max = timeMap[i][j];
                }
            }
        }

        sb.append(max);

        System.out.print(sb);

    }

    static void bfs(int y, int x) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{y, x, 0});
        isVisited = new boolean[H][W];
        isVisited[y][x] = true;

        while(!deque.isEmpty()) {
            int[] now = deque.pollFirst();
            int curY = now[0];
            int curX = now[1];
            int time = now[2];

            timeMap[y][x] = time;

            for(int i = 0; i < 4; i++) {
                int dy = curY + dirY[i];
                int dx = curX + dirX[i];

                if(checkArray(dy, dx)) {
                    if(!isVisited[dy][dx] && map[dy][dx] == 'L') {
                        isVisited[dy][dx] = true;
                        deque.addLast(new int[]{dy, dx, time + 1});
                    }
                }
            }
        }
    }

    static boolean checkArray(int dy, int dx) {
        if(dy >= 0 && dx >= 0 && dy < H && dx < W) {
            return true;
        }
        else {
            return false;
        }
    }

}
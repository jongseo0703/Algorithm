import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {-1, -1, 1, 1, 2, 2, -2, -2};
    static int[] dirY = {2, -2, 2, -2, -1, 1, -1, 1};

    static int[][] map;
    static boolean[][] isVisited;

    static int T, I;

    static int startX, startY, targetX, targetY;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            isVisited = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            sb.append(bfs(startY, startX)).append("\n");

        }

        System.out.print(sb);

    }

    static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        isVisited[y][x] = true;
        map[y][x] = 0;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[1];
            int ny = now[0];

            if(ny == targetY && nx == targetX) {
                return map[ny][nx];
            }

            for(int i = 0; i < 8; i++) {
                int dx = dirX[i] + nx;
                int dy = dirY[i] + ny;

                if(checkArray(dy, dx)) {
                    if(!isVisited[dy][dx]) {
                        isVisited[dy][dx] = true;
                        map[dy][dx] = map[ny][nx] + 1;
                        queue.add(new int[]{dy, dx});
                    }
                }
            }
        }
        return -1;
    }

    static boolean checkArray(int dy, int dx) {
        if(dy >= 0 && dx >= 0 && dy < I && dx < I) {
            return true;
        }
        else {
            return false;
        }
    }

}
import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {-1, 1, -2, 2, -1, 1};
    static int[] dirY = {-2, -2, 0, 0, 2, 2};

    static int[][] map;
    static boolean[][] isVisited;

    static int N;

    static int r1, c1, r2, c2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        isVisited = new boolean[N][N];

        st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        sb.append(bfs(r1, c1));

        System.out.print(sb);

    }

    static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x, 0});
        isVisited[y][x] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int curX = now[1];
            int curY = now[0];
            int count = now[2];

            if(curY == r2 && curX == c2) {
                return count;
            }

            for(int i = 0; i < 6; i++) {
                int dx = dirX[i] + curX;
                int dy = dirY[i] + curY;

                if(checkArray(dy, dx)) {
                    if(!isVisited[dy][dx]) {
                        isVisited[dy][dx] = true;
                        queue.add(new int[]{dy, dx, count + 1});
                    }
                }
            }
        }
        return -1;
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
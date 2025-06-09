import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static int[][] map;
    static boolean[][] isVisited;
    static int[][] result;

    static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        isVisited = new boolean[n][m];
        result = new int[n][m];

        int startX = 0;
        int startY = 0;

        for(int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    startX = j;
                    startY = i;
                }
                result[i][j] = -1;
            }
        }

        bfs(startY, startX);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    sb.append("0").append(" ");
                }
                else {
                    sb.append(result[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }

    static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        isVisited[y][x] = true;
        result[y][x] = 0;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int curX = now[1];
            int curY = now[0];

            for(int i = 0; i < 4; i++) {
                int dx = dirX[i] + curX;
                int dy = dirY[i] + curY;

                if(checkArray(dy, dx)) {
                    if(!isVisited[dy][dx] && map[dy][dx] != 0) {
                        isVisited[dy][dx] = true;
                        result[dy][dx] = result[curY][curX] + 1;
                        queue.add(new int[]{dy, dx});
                    }
                }
            }
        }
    }

    static boolean checkArray(int dy, int dx) {
        if(dy >= 0 && dx >= 0 && dy < n && dx < m) {
            return true;
        }
        else {
            return false;
        }
    }

}
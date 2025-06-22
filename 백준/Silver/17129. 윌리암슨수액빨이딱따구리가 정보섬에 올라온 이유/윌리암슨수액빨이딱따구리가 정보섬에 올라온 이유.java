import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static char[][] map;
    static boolean[][] isVisited;

    static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        isVisited = new boolean[n][m];

        int startX = 0;
        int startY = 0;

        for(int i = 0; i < n; i++) {
            String k = br.readLine();
            for(int j = 0; j < m; j++) {
                if(k.charAt(j) == '2') {
                    startX = j;
                    startY = i;
                }
                map[i][j] = k.charAt(j);
            }
        }

        int result = bfs(startY, startX);

        if(result == - 1) {
            sb.append("NIE");
        }
        else {
            sb.append("TAK").append("\n");
            sb.append(result);
        }

        System.out.print(sb);

    }

    static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x, 0});
        isVisited[y][x] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int curY = now[0];
            int curX = now[1];
            int cnt = now[2];

            if(map[curY][curX] == '3' || map[curY][curX] == '4' || map[curY][curX] == '5') {
                return cnt;
            }

            for(int i = 0; i < 4; i++) {
                int dy = curY + dirY[i];
                int dx = curX + dirX[i];

                if(checkArray(dy, dx)) {
                    if(!isVisited[dy][dx] && map[dy][dx] != '1') {
                        isVisited[dy][dx] = true;
                        queue.add(new int[]{dy, dx, cnt + 1});
                    }
                }
            }
        }
        return -1;
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
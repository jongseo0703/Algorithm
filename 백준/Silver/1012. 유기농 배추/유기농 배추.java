import java.io.*;
import java.util.*;

public class Main {

    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] visited;

    static int M, N, K;

    static int count;

    static int now_x, now_y;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            count = 0;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == 1 && visited[i][j] == false) {
                        count++;
                        DFS(j, i);
                    }
                }
            }

            sb.append(count).append("\n");

        }

        System.out.print(sb);

    }

    static void DFS(int x, int y) {
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            now_x = x + dirX[i];
            now_y = y + dirY[i];

            if(isRange(now_x, now_y) && visited[now_y][now_x] == false && map[now_y][now_x] == 1) {
                DFS(now_x, now_y);
            }
        }
    }

    static boolean isRange(int x, int y) {
        return(x >= 0 && y >= 0 && x < M && y < N);
    }

}
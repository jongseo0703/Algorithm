import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static char[][] map;
    static boolean[][] isVisited;

    static int N, M;

    static int bSum, wSum, bCount, wCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        isVisited = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            String k = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = k.charAt(j);
            }
        }

        bSum = 0;
        wSum = 0;
        bCount = 0;
        wCount = 0;

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 'W' && !isVisited[i][j]) {
                    wDfs(i, j);
                    wSum += (wCount * wCount);
                    wCount = 0;
                }
                else if(map[i][j] == 'B' && !isVisited[i][j]) {
                    bDfs(i, j);
                    bSum += (bCount * bCount);
                    bCount = 0;
                }
            }
        }

        sb.append(wSum + " " + bSum);

        System.out.print(sb);

    }

    static void bDfs(int y, int x) {
        isVisited[y][x] = true;
        bCount++;

        for(int i = 0; i < 4; i++) {
            int dx = dirX[i] + x;
            int dy = dirY[i] + y;

            if(checkArray(dy, dx)) {
                if(map[dy][dx] == 'B' && !isVisited[dy][dx]) {
                    bDfs(dy, dx);
                }
            }
        }
    }

    static void wDfs(int y, int x) {
        isVisited[y][x] = true;
        wCount++;

        for(int i = 0; i < 4; i++) {
            int dx = dirX[i] + x;
            int dy = dirY[i] + y;

            if(checkArray(dy, dx)) {
                if(map[dy][dx] == 'W' && !isVisited[dy][dx]) {
                    wDfs(dy, dx);
                }
            }
        }
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
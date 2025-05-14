import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static char[][] map;
    static boolean[][] isVisited;

    static int personCount = 0;
    static int currentIndexX, currentIndexY;

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        isVisited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String k = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = k.charAt(j);
                if(map[i][j] == 'I') {
                    currentIndexX = j;
                    currentIndexY = i;
                }
            }
        }

        dfs(currentIndexY, currentIndexX);

        if(personCount == 0) {
            sb.append("TT");
        }
        else {
        sb.append(personCount);
        }

        System.out.print(sb);

    }

    static void dfs(int y, int x) {
        isVisited[y][x] = true;

        if(map[y][x] == 'P') {
            personCount++;
        }

        for(int i = 0; i < 4; i++) {
            int dx = dirX[i] + x;
            int dy = dirY[i] + y;

            if(checkArray(dy, dx)) {
                if(map[dy][dx] != 'X' && !isVisited[dy][dx]) {
                    dfs(dy, dx);
                }
            }
        }
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
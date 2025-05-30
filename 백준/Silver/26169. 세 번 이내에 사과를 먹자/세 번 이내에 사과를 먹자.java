import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static int[][] map = new int[5][5];
    static boolean[][] isVisited = new boolean[5][5];

    static int r, c;

    static int appleCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        dfs(r, c, 0, 0);

        if(appleCount >= 2) {
            sb.append("1");
        }
        else {
            sb.append("0");
        }

        System.out.print(sb);

    }

    static void dfs(int r, int c, int moveCount, int apple) {
        if(moveCount > 3) {
            return;
        }

        if(map[r][c] == 1) {
            apple++;
        }

        if(apple == 2) {
            appleCount = 2;
            return;
        }

        isVisited[r][c] = true;

        for(int i = 0; i < 4; i++) {
            int dr = dirY[i] + r;
            int dc = dirX[i] + c;

            if(checkArray(dr, dc)) {
                if(!isVisited[dr][dc] && map[dr][dc] != -1) {
                    dfs(dr, dc, moveCount + 1, apple);
                }
            }
        }
        isVisited[r][c] = false;
    }

    static boolean checkArray(int dr, int dc) {
        if(dr >= 0 && dc >= 0 && dr < 5 && dc < 5) {
            return true;
        }
        else {
            return false;
        }
    }

}
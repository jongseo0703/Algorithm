import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static char[][] map;
    static boolean[][] isVisited;

    static int R, C;

    static int oCount, vCount, oTotalCount, vTotalCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        isVisited = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            String k = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = k.charAt(j);
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                oCount = 0;
                vCount = 0;
                if(!isVisited[i][j]) {
                    dfs(i, j);
                    if (oCount > vCount) {
                        oTotalCount += oCount;
                    }
                    else {
                        vTotalCount += vCount;
                    }
                }
            }
        }

        sb.append(oTotalCount + " " + vTotalCount);

        System.out.print(sb);

    }

    static void dfs(int y, int x) {
        isVisited[y][x] = true;
        if(map[y][x] == 'o') {
            oCount++;
        }
        else if(map[y][x] == 'v') {
            vCount++;
        }

        for(int i = 0; i < 4; i++) {
            int dx = dirX[i] + x;
            int dy = dirY[i] + y;

            if(checkArray(dy, dx)) {
                if (map[dy][dx] != '#' && !isVisited[dy][dx]) {
                    dfs(dy, dx);
                }
            }
        }
    }

    static boolean checkArray(int dy, int dx) {
        if(dy >= 0 && dx >= 0 && dy < R && dx < C) {
            return true;
        }
        else {
            return false;
        }
    }

}
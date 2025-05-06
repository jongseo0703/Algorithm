import java.io.*;
import java.util.*;

public class Main {

    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static char[][] map;
    static boolean[][] isVisited;
    static List<Integer> list;

    static char currentColor;

    static int N, count, gCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        isVisited = new boolean[N][N];
        list = new LinkedList<>();

        count = 0;
        gCount = 0;

        for(int i = 0; i < N; i++) {
            String k = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = k.charAt(j);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!isVisited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 'G') map[i][j] = 'R';
            }
        }

        isVisited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!isVisited[i][j]) {
                    dfs(i, j);
                    gCount++;
                }
            }
        }

        sb.append(count).append(" ").append(gCount);

        System.out.print(sb);

    }

    static void dfs(int x, int y) {
        currentColor = map[x][y];
        isVisited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int dx = x + dirX[i];
            int dy = y + dirY[i];
            if(checkArray(dx, dy)) {
                if (currentColor == map[dx][dy] && !isVisited[dx][dy]) {
                    currentColor = map[dx][dy];
                    dfs(dx, dy);
                }
            }
        }
    }

    static boolean checkArray(int dx, int dy) {
        if(dx >= 0 && dy >= 0 && dx < N && dy < N) {
            return true;
        }
        else {
            return false;
        }
    }

}
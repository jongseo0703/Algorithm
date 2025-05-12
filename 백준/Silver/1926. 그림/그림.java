import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static int[][] map;
    static boolean[][] isVisited;
    static List<Integer> list;

    static int n, m;

    static int count = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        isVisited = new boolean[n][m];
        list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1 && !isVisited[i][j]) {
                    count = 1;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");

        if(list.isEmpty()) {
            sb.append("0");
        }
        else {
            sb.append(list.get(list.size() - 1));
        }

        System.out.print(sb);

    }

    static void dfs(int y, int x) {
        isVisited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int dx = dirX[i] + x;
            int dy = dirY[i] + y;
            if(checkArray(dy, dx)) {
                if(map[dy][dx] == 1 && !isVisited[dy][dx]) {
                    dfs(dy, dx);
                    count++;
                }
            }
        }
    }

    static boolean checkArray(int dy, int dx) {
        if(dx >= 0 && dy >= 0 && dx < m && dy < n) {
            return true;
        }
        else {
            return false;
        }
    }

}
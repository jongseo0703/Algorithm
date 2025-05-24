import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static char[][] map;
    static boolean[][] isVisited;
    static List<Integer> list;

    static int T, H, W;

    static int sCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            isVisited = new boolean[H][W];
            sCount = 0;

            for(int i = 0; i < H; i++) {
                String k = br.readLine();
                for(int j = 0; j < W; j++) {
                    map[i][j] = k.charAt(j);
                }
            }

            for(int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++) {
                    if(map[i][j] == '#' && !isVisited[i][j]) {
                        dfs(i, j);
                        sCount++;
                    }
                }
            }
            list.add(sCount);
        }

        for(int i : list) {
            sb.append(i+"\n");
        }

        System.out.print(sb);

    }

    static void dfs(int y, int x) {
        isVisited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int dx = dirX[i] + x;
            int dy = dirY[i] + y;

            if(checkArray(dy, dx)) {
                if(map[dy][dx] == '#' && !isVisited[dy][dx]) {
                    dfs(dy, dx);
                }
            }
        }
    }

    static boolean checkArray(int dy, int dx) {
        if(dy >= 0 && dx >= 0 && dy < H && dx < W) {
            return true;
        }
        else {
            return false;
        }
    }

}
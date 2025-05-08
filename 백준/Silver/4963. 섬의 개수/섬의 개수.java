import java.io.*;
import java.util.*;

public class Main {

    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static int[][] map;
    static boolean[][] isVisited;
    static List<Integer> list;

    static int w, h, landCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            landCount = 0;

            if(w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            isVisited = new boolean[h][w];
            list = new ArrayList<>();

            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] == 1 && !isVisited[i][j]) {
                        dfs(i,j);
                        landCount++;
                    }
                }
            }

            list.add(landCount);

            for(int i : list) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);

    }

    static void dfs(int y, int x) {
        isVisited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int dy = dirY[i] + y;
                int dx = dirX[j] + x;

                if (checkArray(dy, dx)) {
                    if (map[dy][dx] == 1 && !isVisited[dy][dx]) {
                        dfs(dy, dx);
                    }
                }
            }
        }
    }

    static boolean checkArray(int dy, int dx) {
        if(dx >= 0 && dy >= 0 && dy < h && dx < w) {
            return true;
        }
        else {
            return false;
        }
    }

}
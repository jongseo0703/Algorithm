import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static int[][] map;
    static boolean[][] isVisited;
    static List<Integer> list;

    static int count;

    static int M, N, K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        isVisited = new boolean[M][N];
        list = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = 1;
            }
        }

        int[] arr;

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            arr = new int[4];
            for(int j = 0; j < 4; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[j] = n;
            }
            for(int o = arr[1]; o < arr[3]; o++) {
                for(int k = arr[0]; k < arr[2]; k++) {
                    map[o][k] = 0;
                }
            }
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !isVisited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }

        sb.append(list.size()).append("\n");

        Collections.sort(list);

        for(int i : list) {
            sb.append(i).append(" ");
        }

        System.out.print(sb);

    }

    static void dfs(int y, int x) {
        isVisited[y][x] = true;
        count++;

        for(int i = 0; i < 4; i++) {
            int dx = dirX[i] + x;
            int dy = dirY[i] + y;

            if(checkArray(dy, dx)) {
                if(map[dy][dx] == 1 && !isVisited[dy][dx]) {
                    dfs(dy, dx);
                }
            }
        }

    }

    static boolean checkArray(int dy, int dx) {
        if(dx >= 0 && dy >= 0 && dx < N && dy < M) {
            return true;
        }
        else {
            return false;
        }
    }

}
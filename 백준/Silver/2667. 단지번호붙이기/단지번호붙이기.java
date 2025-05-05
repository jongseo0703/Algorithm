import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] isVisited;
    static List<Integer> list;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int N;
    static int count = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        list = new LinkedList<>();
        map = new int[N][N];
        isVisited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String k = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(k.split("")[j]);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!isVisited[i][j] && map[i][j] == 1) {
                    dfs(i,j);
                    list.add(count);
                    count = 1;
                }
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");

        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.print(sb);

    }

    static void dfs(int x, int y) {
        isVisited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx >= 0 && ny >= 0 && nx < N && ny < N && !isVisited[nx][ny] && map[nx][ny] == 1) {
                count++;
                dfs(nx, ny);
            }
        }
    }

}
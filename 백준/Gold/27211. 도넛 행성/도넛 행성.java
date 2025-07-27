import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static int[][] map;
  static boolean[][] isVisited;

  static int N, M;

  static int area;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    isVisited = new boolean[N][M];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(map[i][j] == 0 && !isVisited[i][j]) {
          bfs(i, j);
          area++;
        }
      }
    }

    sb.append(area);

    System.out.print(sb);

  }

  static void bfs(int y, int x) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{y, x});
    isVisited[y][x] = true;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(dy < 0) {
          dy = N - 1;
        }

        if(dx < 0) {
          dx = M - 1;
        }

        if(dy >= N) {
          dy = 0;
        }

        if(dx >= M) {
          dx = 0;
        }

        if(!isVisited[dy][dx] && map[dy][dx] == 0) {
          isVisited[dy][dx] = true;
          queue.add(new int[]{dy, dx});
        }
      }
    }
  }

}
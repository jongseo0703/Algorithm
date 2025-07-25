import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 1};
  static int[] dirY = {1, 0};

  static int[][] map;
  static boolean[][] isVisited;

  static int N, M;

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

    sb.append(bfs(0, 0));

    System.out.print(sb);

  }

  static int bfs(int y, int x) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{y, x, 0});
    isVisited[y][x] = true;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];
      int boosterCount = now[2];
      int booster = map[curY][curX];

      if(curY == N - 1 && curX == M - 1) {
        return boosterCount;
      }

      for(int i = 0; i < 2; i++) {
        for(int j = 1; j <= booster; j++) {
          int dy = curY + dirY[i] * j;
          int dx = curX + dirX[i] * j;

          if(checkArray(dy, dx)) {
            if(!isVisited[dy][dx]) {
              queue.add(new int[]{dy, dx, boosterCount + 1});
              isVisited[dy][dx] = true;
            }
          }
        }

      }
    }
    return -1;
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
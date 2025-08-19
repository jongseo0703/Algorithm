import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static int[][] map;
  static boolean[][] isVisited;

  static int N, M;

  static int X;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    map = new int[N][M];
    isVisited = new boolean[N][M];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    X = Integer.parseInt(br.readLine());

    boolean result = bfs();

    if(result) {
      sb.append("ALIVE");
    }
    else {
      sb.append("DEAD");
    }

    System.out.print(sb);
  }

  static boolean bfs() {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0});

    isVisited[0][0] = true;
    int start = map[0][0];

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      if(curY == N - 1 && curX == M - 1) {
        return true;
      }

      for(int dy = -X; dy <= X; dy++) {
        for(int dx = -X; dx <= X; dx++) {
          int ny = curY + dy;
          int nx = curX + dx;

          if(Math.abs(dy) + Math.abs(dx) > X) {
            continue;
          }
          if(checkArray(ny, nx)) {
            if (!isVisited[ny][nx] && map[ny][nx] == start) {
              isVisited[ny][nx] = true;
              queue.add(new int[]{ny, nx});
            }
          }
        }
      }
    }
    return false;
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

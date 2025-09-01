import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX1 = {0, 0, -1, 1, -1, -1};
  static int[] dirY1 = {-1, 1, 0, 0, -1, 1};

  static int[] dirX2 = {0, 0, -1, 1, 1, 1};
  static int[] dirY2 = {-1, 1, 0, 0, -1, 1};

  static int[][] map;
  static boolean[][] isVisited;

  static int N, M, K;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    isVisited = new boolean[N][M];

    for(int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int Y = Integer.parseInt(st.nextToken());
      int X = Integer.parseInt(st.nextToken());

      map[Y][X] = 1;
    }

    int result = bfs();

    sb.append(result);

    System.out.print(sb);
  }

  static int bfs() {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0, 0});
    isVisited[0][0] = true;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];
      int cnt = now[2];

      if(curY == N - 1 && curX == M - 1) {
        return cnt;
      }

      for(int i = 0; i < 6; i++) {
        int dy;
        int dx;
        if(curY % 2 == 0) {
          dy = curY + dirY1[i];
          dx = curX + dirX1[i];
        }
        else {
          dy = curY + dirY2[i];
          dx = curX + dirX2[i];
        }

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx] && map[dy][dx] != 1) {
            isVisited[dy][dx] = true;
            queue.add(new int[]{dy, dx, cnt + 1});
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

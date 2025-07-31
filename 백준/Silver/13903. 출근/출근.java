import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX;
  static int[] dirY;

  static int[][] map;
  static boolean[][] isVisited;

  static int R, C;

  static int N;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new int[R][C];
    isVisited = new boolean[R][C];

    for(int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < C; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    N = Integer.parseInt(br.readLine());

    dirX = new int[N];
    dirY = new int[N];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());

      dirY[i] = y;
      dirX[i] = x;
    }

    sb.append(bfs());

    System.out.print(sb);

  }

  static int bfs() {
    Queue<int[]> queue = new LinkedList<>();

    for(int i = 0; i < C; i++) {
      if(map[0][i] == 1) {
        queue.add(new int[]{0, i, 0});
        isVisited[0][i] = true;
      }
    }

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];
      int cnt = now[2];

      if(curY == R - 1) {
        return cnt;
      }

      for(int i = 0; i < N; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx] && map[dy][dx] == 1) {
            queue.add(new int[]{dy, dx, cnt + 1});
            isVisited[dy][dx] = true;
          }
        }
      }
    }
    return -1;
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < R && dx < C) {
      return true;
    }
    else {
      return false;
    }
  }

}
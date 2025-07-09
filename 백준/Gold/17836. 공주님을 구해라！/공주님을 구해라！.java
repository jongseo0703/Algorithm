import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static int[][] map;
  static boolean[][][] isVisited;

  static int N, M, T;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    map = new int[N][M];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int ans = bfs();

    if(ans == -1) {
      sb.append("Fail");
    }
    else {
      sb.append(ans);
    }

    System.out.print(sb);

  }

  static int bfs() {
    Queue<int[]> queue = new LinkedList<>();
    isVisited = new boolean[N][M][2];
    queue.add(new int[]{0, 0, 0, 0});
    isVisited[0][0][0] = true;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];
      int curTime = now[2];
      int sword = now[3];

      if(curTime <= T && (curY == N - 1 && curX == M - 1)) {
        return curTime;
      }

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];
        int ns = sword;

        if(checkArray(dy, dx)) {
          if(map[dy][dx] == 1 && sword == 0) {
            continue;
          }
          
          if(map[dy][dx] == 2) {
            ns = 1;
          }

          if(!isVisited[dy][dx][ns]) {
            queue.add(new int[]{dy, dx, curTime + 1, ns});
            isVisited[dy][dx][ns] = true;
          }
        }
      }
    }
    return -1;
  }

  static boolean checkArray(int dy, int dx) {
    if(dx >= 0 && dy >= 0 && dy < N && dx < M) {
      return true;
    }
    else {
      return false;
    }
  }

}
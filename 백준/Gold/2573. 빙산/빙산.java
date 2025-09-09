import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static int[][] iceMountain;
  static boolean[][] isVisited;

  static int N, M;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    iceMountain = new int[N][M];
    isVisited = new boolean[N][M];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        iceMountain[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int year = 0;

    while(true) {
      int count = iceArea();

      if(count >= 2) {
        sb.append(year);
        break;
      }

      if(count == 0) {
        sb.append(0);
        break;
      }

      melt();
      year++;
    }

    System.out.print(sb);
  }

  static int iceArea() {
    isVisited = new boolean[N][M];
    int count = 0;

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(!isVisited[i][j] && iceMountain[i][j] > 0) {
          bfs(i, j);
          count++;
        }
      }
    }

    return count;
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

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx] && iceMountain[dy][dx] > 0) {
            isVisited[dy][dx] = true;
            queue.add(new int[]{dy, dx});
          }
        }
      }
    }
  }

  static void melt() {
    int[][] melt = new int[N][M];

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(iceMountain[i][j] > 0) {
          int sea = 0;
          for(int k = 0; k < 4; k++) {
            int dy = i + dirY[k];
            int dx = j + dirX[k];

            if(checkArray(dy, dx) && iceMountain[dy][dx] == 0) {
              sea++;
            }
          }
          melt[i][j] = sea;
        }
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        iceMountain[i][j] = Math.max((iceMountain[i][j] - melt[i][j]), 0);
      }
    }
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

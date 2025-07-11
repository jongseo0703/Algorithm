import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, -1, 1, 1, -1, 1};
  static int[] dirY = {-1, 1, -1, 1, -1, 1, 0, 0};

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

    int peekCount = 0;

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(!isVisited[i][j]) {
          if(bfs(i, j)) {
            peekCount++;
          }
        }
      }
    }

    sb.append(peekCount);

    System.out.print(sb);

  }

  static boolean bfs(int y, int x) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{y, x});
    isVisited[y][x] = true;

    boolean isPeek = true;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      for(int i = 0; i < 8; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          int curMount = map[curY][curX];
          int nextMount = map[dy][dx];

          if(nextMount > curMount) {
            isPeek = false;
          }

          if(!isVisited[dy][dx] && curMount == nextMount) {
            queue.add(new int[]{dy, dx});
            isVisited[dy][dx] = true;
          }
        }
      }
    }
    return isPeek;
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
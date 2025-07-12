import java.io.*;
import java.util.*;

public class Main {
  static char[][] map;
  static boolean[][] isVisited;

  static int N, K;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new char[2][N];
    isVisited = new boolean[2][N];

    for(int i = 0; i < 2; i++) {
      String k = br.readLine();
      for(int j = 0; j < N; j++) {
        map[i][j] = k.charAt(j);
      }
    }

    boolean result = bfs(0, 0);

    if(result) {
      sb.append("1");
    }
    else {
      sb.append("0");
    }

    System.out.print(sb);

  }

  static boolean bfs(int y, int x) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{y, x, 0});
    isVisited[y][x] = true;

    int[] dirX = {-1, 1, K, K};
    int[] dirY = {0, 0, 1, -1};

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];
      int time = now[2];

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(dx >= N) {
          return true;
        }

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx] && dx >= time + 1 && map[dy][dx] == '1') {
            queue.add(new int[]{dy, dx, time + 1});
            isVisited[dy][dx] = true;
          }
        }
      }
    }
    return false;
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < 2 && dx < N) {
      return true;
    }
    else {
      return false;
    }
  }

}
import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {-2, -2, -1, -1, 1, 1, 2, 2};
  static int[] dirY = {-1, 1, -2, 2, -2, 2, -1, 1};

  static boolean[][] isVisited;
  static int[][] dist;

  static int N, M;
  static int X, Y;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    Y = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());

    isVisited = new boolean[N][N];
    dist = new int[N][N];

    bfs(Y - 1, X - 1);

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int B = Integer.parseInt(st.nextToken());
      int A = Integer.parseInt(st.nextToken());

      sb.append(dist[B - 1][A - 1]).append(" ");
    }

    System.out.print(sb);

  }

  static void bfs(int knightY, int knightX) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{knightY, knightX});
    isVisited[knightY][knightX] = true;
    dist[knightY][knightX] = 0;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      for(int i = 0; i < 8; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx]) {
            queue.add(new int[]{dy, dx});
            isVisited[dy][dx] = true;
            dist[dy][dx] = dist[curY][curX] + 1;
          }
        }
      }
    }
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < N && dx < N) {
      return true;
    }
    else {
      return false;
    }
  }

}
import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static int[][] map;
  static boolean[][] isVisited;

  static int N, M, A, B, K;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new int[N + 1][M + 1];
    isVisited = new boolean[N + 1][M + 1];

    for(int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());

      map[y][x] = 1;
    }

    st = new StringTokenizer(br.readLine());
    int startY = Integer.parseInt(st.nextToken());
    int startX = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int endY = Integer.parseInt(st.nextToken());
    int endX = Integer.parseInt(st.nextToken());

    int result = bfs(startY, startX, endY, endX);

    sb.append(result);

    System.out.print(sb);
  }

  static int bfs(int startY, int startX, int endY, int endX) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{startY, startX, 0});

    isVisited[startY][startX] = true;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];
      int cnt = now[2];

      if(curY == endY && curX == endX) {
        return cnt;
      }

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(!canMove(dy, dx)) continue;

        if(!isVisited[dy][dx]) {
          isVisited[dy][dx] = true;
          queue.add(new int[]{dy, dx, cnt + 1});
        }
      }

    }

    return -1;
  }

  static boolean canMove(int dy, int dx) {
    if(dy <= 0 || dx <= 0 || dy + A - 1 > N || dx + B - 1 > M) return false;

    for(int i = dy; i < dy + A; i++) {
      for(int j = dx; j < dx + B; j++) {
        if(map[i][j] == 1) return false;
      }
    }
    return true;
  }

}

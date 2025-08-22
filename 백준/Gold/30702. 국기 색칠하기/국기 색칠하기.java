import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static char[][] mapA;
  static char[][] mapB;
  static boolean[][] isVisited;

  static int N, M;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    mapA = new char[N][M];
    mapB = new char[N][M];
    isVisited = new boolean[N][M];

    for(int i = 0; i < N; i++) {
      String s = br.readLine();
      for(int j = 0; j < M; j++) {
        mapA[i][j] = s.charAt(j);
      }
    }

    for(int i = 0; i < N; i++) {
      String s = br.readLine();
      for(int j = 0; j < M; j++) {
        mapB[i][j] = s.charAt(j);
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(!isVisited[i][j]) {
          if(!bfs(i, j)) {
            sb.append("NO");

            System.out.print(sb);

            return;
          }
        }
      }
    }

    sb.append("YES");

    System.out.print(sb);
  }

  static boolean bfs(int y, int x) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{y, x});
    isVisited[y][x] = true;

    char cA = mapA[y][x];
    char cB = mapB[y][x];

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      if(mapB[curY][curX] != cB) {
        return false;
      }

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx] && mapA[dy][dx] == cA) {
            queue.add(new int[]{dy, dx});
            isVisited[dy][dx] = true;
          }
        }
      }
    }

    return true;
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
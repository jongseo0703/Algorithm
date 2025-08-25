import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static char[][] rect;
  static boolean[][] isVisited;

  static int N, M;

  static int minX, minY, maxX, maxY;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    rect = new char[N][M];
    isVisited = new boolean[N][M];

    for(int i = 0; i < N; i++) {
      String s = br.readLine();
      for(int j = 0; j < M; j++) {
        rect[i][j] = s.charAt(j);
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(!isVisited[i][j]) {
          bfs(i, j);
          boolean flag = checkRect(minY, minX, maxY, maxX);
          if(!flag) {
            sb.append("BaboBabo");
            System.out.print(sb);
            return;
          }
        }
      }
    }

    sb.append("dd");

    System.out.print(sb);
  }

  static void bfs(int y, int x) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{y, x});

    isVisited[y][x] = true;

    char first = rect[y][x];

    minX = x;
    minY = y;
    maxX = x;
    maxY = y;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx] && rect[dy][dx] == first) {
            if(dy > maxY) {
              maxY = dy;
            }
            if(dx > maxX) {
              maxX = dx;
            }
            if(dy < minY) {
              minY = dy;
            }
            if(dx < minX) {
              minX = dx;
            }
            isVisited[dy][dx] = true;
            queue.add(new int[]{dy, dx});
          }
        }
      }
    }
  }

  static boolean checkRect(int minY, int minX, int maxY, int maxX) {
    char startRect = rect[minY][minX];

    for(int i = minY; i <= maxY; i++) {
      for(int j = minX; j <= maxX; j++) {
        if(rect[i][j] != startRect) {
          return false;
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
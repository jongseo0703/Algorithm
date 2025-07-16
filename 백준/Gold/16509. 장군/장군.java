import java.io.*;
import java.util.*;

public class Main {
  static int[] dirY = {-3, -3, -2, -2, 2, 2, 3, 3};
  static int[] dirX = {-2, 2, -3, 3, -3, 3, -2, 2};

  static int[][] checkY = {
    {-1, -2}, {-1, -2}, {-1, -1}, {-1, -1},
    {1, 1}, {1, 1}, {1, 2}, {1, 2}
  };
  static int[][] checkX = {
    {0, -1}, {0, 1}, {-1, -2}, {1, 2},
    {-1, -2}, {1, 2}, {0, -1}, {0, 1}
  };

  static boolean[][] isVisited;

  static int R1, C1, R2, C2;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    R1 = Integer.parseInt(st.nextToken());
    C1 = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    R2 = Integer.parseInt(st.nextToken());
    C2 = Integer.parseInt(st.nextToken());

    isVisited = new boolean[10][9];

    sb.append(bfs(R1, C1));

    System.out.print(sb);

  }

  static int bfs(int y, int x) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{y, x, 0});
    isVisited[y][x] = true;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];
      int cnt = now[2];

      if(curY == R2 && curX == C2) {
        return cnt;
      }

      for(int i = 0; i < 8; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        int midY1 = curY + checkY[i][0];
        int midX1 = curX + checkX[i][0];
        int midY2 = curY + checkY[i][1];
        int midX2 = curX + checkX[i][1];

        if(!checkArray(midY1, midX1) || !checkArray(midY2, midX2)) {
          continue;
        }

        if((midY1 == R2 && midX1 == C2) || (midY2 == R2 && midX2 == C2)) {
          continue;
        }

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx]) {
            isVisited[dy][dx] = true;
            queue.add(new int[]{dy, dx, cnt + 1});
          }
        }
      }
    }
    return -1;
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < 10 && dx < 9) {
      return true;
    }
    else {
      return false;
    }
  }

}

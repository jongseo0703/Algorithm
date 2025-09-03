import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {-1, -1, 1, 1, -2, -2, 2, 2};
  static int[] dirY = {-2, 2, -2, 2, -1, 1, -1, 1};

  static int[][] map = new int[8][8];
  static boolean[][] isVisited = new boolean[8][8];

  static int startX, startY, targetX, targetY;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    String start = br.readLine();
    String target = br.readLine();

    startX = start.charAt(0) - 'a';
    startY = 8 - (start.charAt(1) - '0');
    targetX = target.charAt(0) - 'a';
    targetY = 8 - (target.charAt(1) - '0');

    int result = bfs();

    sb.append(result);

    System.out.print(sb);
  }

  static int bfs() {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{startY, startX, 0});
    isVisited[startY][startX] = true;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];
      int cnt = now[2];

      if(curY == targetY && curX == targetX) {
        return cnt;
      }

      for(int i = 0; i < 8; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

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
    if(dy >= 0 && dx >= 0 && dy < 8 && dx < 8) {
      return true;
    }
    else {
      return false;
    }
  }

}

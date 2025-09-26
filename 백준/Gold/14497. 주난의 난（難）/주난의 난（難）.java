import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static int[][] map;
  static boolean[][] isVisited;

  static int N, M;

  static int x1, y1, x2, y2;

  static class Node {
    int x, y, level;

    Node(int x, int y, int level) {
      this.x = x;
      this.y = y;
      this.level = level;
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    isVisited = new boolean[N][M];

    st = new StringTokenizer(br.readLine());

    y1 = Integer.parseInt(st.nextToken()) - 1;
    x1 = Integer.parseInt(st.nextToken()) - 1;
    y2 = Integer.parseInt(st.nextToken()) - 1;
    x2 = Integer.parseInt(st.nextToken()) - 1;

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        char val = line.charAt(j);

        if(val == '#' || val == '*') {
          continue;
        }

        map[i][j] = val - '0';
      }
    }

    map[y2][x2] = 1;

    int result = bfs();

    sb.append(result);

    System.out.print(sb);
  }

  static int bfs() {
    ArrayDeque<Node> queue = new ArrayDeque<>();
    queue.add(new Node(x1, y1, 0));

    isVisited[y1][x1] = true;

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      int curY = node.y;
      int curX = node.x;
      int curLevel = node.level;

      if (curY == y2 && curX == x2) {
        return curLevel;
      }

      for (int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx]) {
            isVisited[dy][dx] = true;

            if(map[dy][dx] == 0) {
              queue.offerFirst(new Node(dx, dy, curLevel));
            }
            else {
              queue.offerLast(new Node(dx, dy, curLevel + 1));
            }
          }
        }
      }
    }
    return -1;
  }

  static boolean checkArray(int dy, int dx) {
    if (dy >= 0 && dx >= 0 && dy < N && dx < M) {
      return true;
    } else {
      return false;
    }
  }
}

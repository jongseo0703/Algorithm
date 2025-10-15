import java.io.*;
import java.util.*;

public class Main {
  static int[][] oddDir = {{0, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}};
  static int[][] evenDir = {{0, -1}, {-1, -1}, {-1, 0}, {0, 1}, {1, 0}, {1, -1}};

  static int[][] map;
  static boolean[][] isVisited;
  static int[][] result;

  static int W, H;

  static class Node {
    int x;
    int y;
    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    map = new int[H + 2][W + 2];
    isVisited = new boolean[H + 2][W + 2];
    result = new int[H + 2][W + 2];

    for(int i = 1; i <= H; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 1; j <= W; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());

        if(map[i][j] == 1) {
          isVisited[i][j] = true;
        }
      }
    }

    bfs(0, 0);

    int answer = 0;

    for(int i = 0; i < H + 2; i++) {
      for(int j = 0; j < W + 2; j++) {
        answer += result[i][j];
      }
    }

    sb.append(answer);

    System.out.print(sb);
  }

  static void bfs(int y, int x) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(x, y));
    isVisited[y][x] = true;

    while(!queue.isEmpty()) {
      Node node = queue.poll();
      int curY = node.y;
      int curX = node.x;

      for(int i = 0; i < 6; i++) {
        int dy = 0;
        int dx = 0;

        if(curY % 2 == 0) {
          dy = curY + evenDir[i][0];
          dx = curX + evenDir[i][1];
        }
        else {
          dy = curY + oddDir[i][0];
          dx = curX + oddDir[i][1];
        }

        if(checkArray(dy, dx)) {
          if(map[dy][dx] == 1) {
            result[curY][curX] += 1;
            continue;
          }

          if(!isVisited[dy][dx]) {
            isVisited[dy][dx] = true;
            queue.add(new Node(dx, dy));
          }
        }
      }
    }
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < H + 2 && dx < W + 2) {
      return true;
    }
    else {
      return false;
    }
  }

}

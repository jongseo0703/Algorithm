import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static int[][] map = new int[1001][1001];
  static boolean[][] isVisited = new boolean[1001][1001];

  static int X, Y, N;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    X = Integer.parseInt(st.nextToken());
    Y = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());

      map[500 + B][500 + A] = 1;
    }

    int result = bfs();

    sb.append(result);

    System.out.print(sb);

  }

  static int bfs() {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{500, 500, 0});
    isVisited[500][500] = true;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];
      int dist = now[2];

      if(curY == 500 + Y && curX == 500 + X) {
        return dist;
      }

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx] && map[dy][dx] != 1) {
            isVisited[dy][dx] = true;
            queue.add(new int[]{dy, dx, dist + 1});
          }
        }
      }
    }

    return -1;
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < 1001 && dx < 1001) {
      return true;
    }
    else {
      return false;
    }
  }

}
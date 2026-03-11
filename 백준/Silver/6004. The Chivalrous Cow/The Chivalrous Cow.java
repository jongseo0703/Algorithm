import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  static int[] dirX = {-2, -2, -1, -1, 1, 1, 2, 2};
  static int[] dirY = {-1, 1, -2, 2, -2, 2, -1, 1};

  static char[][] map;
  static boolean[][] isVisited;

  static int X, Y;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    X = Integer.parseInt(st.nextToken());
    Y = Integer.parseInt(st.nextToken());

    map = new char[Y][X];
    isVisited = new boolean[Y][X];

    for(int i = 0; i < Y; i++) {
      String line = br.readLine();
      for(int j = 0; j < X; j++) {
        map[i][j] = line.charAt(j);
      }
    }

    int result = 0;

    for(int i = 0; i < Y; i++) {
      for(int j = 0; j < X; j++) {
        if(map[i][j] == 'K') {
          result = bfs(i, j);
        }
      }
    }

    sb.append(result);

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

      if(map[curY][curX] == 'H') return cnt;

      for(int i = 0; i < 8; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx] && map[dy][dx] != '*') {
            queue.add(new int[]{dy, dx, cnt + 1});
            isVisited[dy][dx] = true;
          }
        }
      }
    }

    return -1;
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < Y && dx < X) return true;
    return false;
  }

}

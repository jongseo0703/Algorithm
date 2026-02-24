import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  static int[] dirX = {0, 0, -1, -1, 1, 1, -1, 1};
  static int[] dirY = {-1, 1, -1, 1, -1, 1, 0, 0};

  static char[][] map;
  static boolean[][] isVisited;

  static int m, n;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    while(true) {
      st = new StringTokenizer(br.readLine());
      m = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());

      int cnt = 0;

      if(m == 0 && n == 0) break;

      map = new char[m][n];
      isVisited = new boolean[m][n];

      for(int i = 0; i < m; i++) {
        String line = br.readLine();
        for(int j = 0; j < n; j++) {
          map[i][j] = line.charAt(j);
        }
      }

      for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
          if(map[i][j] == '@' && !isVisited[i][j]) {
            bfs(i, j);
            cnt++;
          }
        }
      }

      sb.append(cnt + "\n");
    }

    System.out.print(sb);
  }

  static void bfs(int y, int x) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{y, x});
    isVisited[y][x] = true;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      for(int i = 0; i < 8; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx] && map[dy][dx] == '@') {
            isVisited[dy][dx] = true;
            queue.add(new int[]{dy, dx});
          }
        }
      }
    }
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < m && dx < n) return true;
    return false;
  }

}

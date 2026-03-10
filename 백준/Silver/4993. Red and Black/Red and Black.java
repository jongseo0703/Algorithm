import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static char[][] map;
  static boolean[][] isVisited;

  static int W, H;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    while(true) {
      st = new StringTokenizer(br.readLine());
      W = Integer.parseInt(st.nextToken());
      H = Integer.parseInt(st.nextToken());

      if(W == 0 && H == 0) break;

      map = new char[H][W];
      isVisited = new boolean[H][W];

      for(int i = 0; i < H; i++) {
        String line = br.readLine();
        for(int j = 0; j < W; j++) {
          map[i][j] = line.charAt(j);
        }
      }

      int result = 0;

      for(int i = 0; i < H; i++) {
        for(int j = 0; j < W; j++) {
          if(map[i][j] == '@') {
            result = bfs(i, j);
          }
        }
      }

      sb.append(result + "\n");
    }

    System.out.print(sb);

  }

  static int bfs(int y, int x) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{y, x});

    isVisited[y][x] = true;

    int cnt = 1;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx] && map[dy][dx] != '#') {
            queue.add(new int[]{dy, dx});
            isVisited[dy][dx] = true;
            cnt++;
          }
        }
      }
    }
    return cnt;
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < H && dx < W) return true;
    return false;
  }

}

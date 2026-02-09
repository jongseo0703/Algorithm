import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  static int[] dirY = {0, 0, -1, 1};
  static int[] dirX = {-1, 1, 0, 0};

  static char[][] map;
  static boolean[][] isVisited;

  static int R, C;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new char[R][C];
    isVisited = new boolean[R][C];

    for(int i = 0; i < R; i++) {
      String line = br.readLine();
      for(int j = 0; j < C; j++) {
        map[i][j] = line.charAt(j);
      }
    }

    int area = 0;

    for(int i = 0; i < R; i++) {
      for(int j = 0; j < C; j++) {
        if(map[i][j] == '#' && !isVisited[i][j]) {
          bfs(i, j);
          area++;
        }
      }
    }

    sb.append(area);

    System.out.print(sb);
  }

  static void bfs(int y, int x) {
    Queue<int[]> queue = new LinkedList<>();
    isVisited[y][x] = true;
    queue.add(new int[]{y, x});

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx] && map[dy][dx] == '#') {
            queue.add(new int[]{dy, dx});
            isVisited[dy][dx] = true;
          }
        }
      }
    }
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < R && dx < C) {
      return true;
    }
    return false;
  }

}
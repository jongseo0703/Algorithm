import java.io.*;
import java.util.*;

public class Main {
  static int[] dirC = {0, 0, -1, 1};
  static int[] dirR = {-1, 1, 0, 0};

  static int[][] map = new int[5][5];
  static boolean[][] isVisited = new boolean[5][5];

  static int r, c;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    for(int i = 0; i < 5; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < 5; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());

    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    int result = bfs();

    sb.append(result);

    System.out.print(sb);
  }

  static int bfs() {
    int totalCnt = 0;

    for(int targetN = 1; targetN <= 6; targetN++) {
      Queue<int[]> queue = new LinkedList<>();
      queue.add(new int[]{r, c, 0});

      isVisited = new boolean[5][5];
      isVisited[r][c] = true;

      boolean found = false;

      while (!queue.isEmpty()) {
        int[] now = queue.poll();
        int curR = now[0];
        int curC = now[1];
        int cnt = now[2];

        if (map[curR][curC] == targetN) {
          totalCnt += cnt;
          r = curR;
          c = curC;
          found = true;
          break;
        }

        for (int i = 0; i < 4; i++) {
          int dr = curR + dirR[i];
          int dc = curC + dirC[i];

          if (checkArray(dr, dc)) {
            if (!isVisited[dr][dc] && map[dr][dc] != -1) {
              isVisited[dr][dc] = true;
              queue.add(new int[]{dr, dc, cnt + 1});
            }
          }
        }
      }

      if(!found) {
        return -1;
      }
    }

    return totalCnt;
  }

  static boolean checkArray(int dr, int dc) {
    if(dr >= 0 && dc >= 0 && dr < 5 && dc < 5) {
      return true;
    }
    else {
      return false;
    }
  }

}

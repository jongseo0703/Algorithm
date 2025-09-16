import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static char[][] map;
  static int[][] fireTime;
  static int[][] personTime;

  static int T;

  static int w, h;

  static int startY, startX;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    while(T-- > 0) {
      st = new StringTokenizer(br.readLine());
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      map = new char[h][w];
      fireTime = new int[h][w];
      personTime = new int[h][w];

      for(int i = 0; i < h; i++) {
        String line = br.readLine();
        for(int j = 0; j < w; j++) {
          map[i][j] = line.charAt(j);
          fireTime[i][j] = -1;
          personTime[i][j] = -1;

          if(map[i][j] == '@') {
            startY = i;
            startX = j;
          }
        }
      }

      fire();

      int result = bfs();

      if(result == -1) {
        sb.append("IMPOSSIBLE").append("\n");
      }
      else {
        sb.append(result).append("\n");
      }
    }

    System.out.print(sb);
  }

  static void fire() {
    Queue<int[]> queue = new LinkedList<>();

    for(int i = 0; i < h; i++) {
      for(int j = 0; j < w; j++) {
        if(map[i][j] == '*') {
          queue.add(new int[]{i, j});
          fireTime[i][j] = 0;
        }
      }
    }

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(fireTime[dy][dx] == -1 && map[dy][dx] != '#') {
            fireTime[dy][dx] = fireTime[curY][curX] + 1;
            queue.add(new int[]{dy, dx});
          }
        }
      }
    }
  }

  static int bfs() {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{startY, startX});

    personTime[startY][startX] = 0;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      if(curY == 0 || curX == 0 || curY == h - 1 || curX == w - 1) {
        return personTime[curY][curX] + 1;
      }

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(personTime[dy][dx] == -1 && map[dy][dx] == '.') {
            if (fireTime[dy][dx] == -1 || fireTime[dy][dx] > personTime[curY][curX] + 1) {
              personTime[dy][dx] = personTime[curY][curX] + 1;
              queue.add(new int[]{dy, dx});
            }
          }
        }
      }
    }

    return -1;
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < h && dx < w) {
      return true;
    }
    else {
      return false;
    }
  }

}

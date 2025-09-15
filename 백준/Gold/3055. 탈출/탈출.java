import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static char[][] map;
  static int[][] waterTime;
  static boolean[][] isVisited;

  static int R, C;

  static int startY, startX, targetY, targetX;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new char[R][C];
    waterTime = new int[R][C];
    isVisited = new boolean[R][C];

    for(int i = 0; i < R; i++) {
      String k = br.readLine();
      for(int j = 0; j < C; j++) {
        map[i][j] = k.charAt(j);
        waterTime[i][j] = -1;

        if(map[i][j] == 'S') {
          startY = i;
          startX = j;
        }

        if(map[i][j] == 'D') {
          targetY = i;
          targetX = j;
        }
      }
    }

    watering();

    int result = bfs();

    if(result == -1) {
      sb.append("KAKTUS");
    }
    else {
      sb.append(result);
    }

    System.out.print(sb);
  }

  static void watering() {
    Queue<int[]> queue = new LinkedList<>();

    for(int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if(map[i][j] == '*') {
          queue.add(new int[]{i, j});
          waterTime[i][j] = 0;
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
          if(map[dy][dx] == '.' && waterTime[dy][dx] == -1) {
            waterTime[dy][dx] = waterTime[curY][curX] + 1;
            queue.add(new int[]{dy, dx});
          }
        }
      }
    }
  }

  static int bfs() {
    Queue<int[]> queue = new LinkedList<>();
    int[][] dist = new int[R][C];

    for(int i = 0; i < R; i++) {
      Arrays.fill(dist[i], -1);
    }

    queue.add(new int[]{startY, startX});
    isVisited[startY][startX] = true;
    dist[startY][startX] = 0;

    int t = 0;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      if(curY == targetY && curX == targetX) {
        return dist[curY][curX];
      }

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx] && map[dy][dx] == '.' || map[dy][dx] == 'D') {
            int nextTime = dist[curY][curX] + 1;

            if(waterTime[dy][dx] == -1 || waterTime[dy][dx] > nextTime) {
              isVisited[dy][dx] = true;
              dist[dy][dx] = nextTime;
              queue.add(new int[]{dy, dx});
            }
          }
        }
      }
    }
    return -1;
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < R && dx < C) {
      return true;
    }
    else {
      return false;
    }
  }

}

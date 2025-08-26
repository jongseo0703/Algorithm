import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static int[][] map;
  static int[][] electroMap;
  static boolean[][] isVisited;

  static int W, H, N;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    map = new int[H][W];
    electroMap = new int[H][W];
    isVisited = new boolean[H][W];

    N = Integer.parseInt(br.readLine());

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      String type = st.nextToken();
      int X = Integer.parseInt(st.nextToken());
      int Y = Integer.parseInt(st.nextToken());

      switch(type) {
        case "redstone_block" : {
          map[Y][X] = 3;
          electroMap[Y][X] = 15;
          break;
        }
        case "redstone_dust" : {
          map[Y][X] = 2;
          break;
        }
        case "redstone_lamp" : {
          map[Y][X] = 1;
          break;
        }
      }
    }

    bfs();

    boolean flag = true;

    for(int i = 0; i < H; i++) {
      for(int j = 0; j < W; j++) {
        if(map[i][j] == 1 && electroMap[i][j] != 1) {
          flag = false;
          break;
        }
      }
    }

    if(flag) {
      sb.append("success");
    }
    else {
      sb.append("failed");
    }

    System.out.print(sb);

  }

  static void bfs() {
    Queue<int[]> queue = new LinkedList<>();

    for(int i = 0; i < H; i++) {
      for(int j = 0; j < W; j++) {
        if(map[i][j] == 3) {
          queue.add(new int[]{i, j});
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
          if(map[dy][dx] == 2 && !isVisited[dy][dx]) {
            int newPower = electroMap[curY][curX] - 1;
            electroMap[dy][dx] = Math.max(electroMap[dy][dx], newPower);
            if(newPower > 0) {
              queue.add(new int[]{dy, dx});
              isVisited[dy][dx] = true;
            }
          }
          else if(map[dy][dx] == 1) {
            electroMap[dy][dx] = 1;
          }
        }
      }
    }
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < H && dx < W) {
      return true;
    }
    else {
      return false;
    }
  }

}
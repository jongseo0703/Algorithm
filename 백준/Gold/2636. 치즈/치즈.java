import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static int[][] map;
  static boolean[][] isVisited;

  static int N, M;

  static int time, lastCheese;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    while(true) {
      int cheese = countCheese();

      if(cheese == 0) {
        sb.append(time).append("\n").append(lastCheese);
        System.out.print(sb);
        return;
      }
      lastCheese = cheese;
      bfs();
      time++;
    }

  }

  static void bfs() {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0});

    isVisited = new boolean[N][M];
    isVisited[0][0] = true;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx] && map[dy][dx] == 0) {
            isVisited[dy][dx] = true;
            queue.add(new int[]{dy, dx});
          }
        }
      }
    }

    int[][] next = new int[N][M];

    for(int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 1) {
          boolean melt = false;
          for (int k = 0; k < 4; k++) {
            int dy = i + dirY[k];
            int dx = j + dirX[k];

            if (checkArray(dy, dx)) {
              if(isVisited[dy][dx] && map[dy][dx] == 0) {
                melt = true;
                break;
              }
            }
          }
          if (!melt) {
            next[i][j] = 1;
          }
        }
      }
    }
    map = next;
  }

  static int countCheese() {
    int cnt = 0;

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(map[i][j] == 1) {
          cnt++;
        }
      }
    }
    return cnt;
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < N && dx < M) {
      return true;
    }
    else {
      return false;
    }
  }

}

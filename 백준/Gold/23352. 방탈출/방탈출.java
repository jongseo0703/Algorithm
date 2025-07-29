import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static int[][] map;
  static boolean[][] isVisited;
  static int[][] maxDistSave;
  static int[][] secret;

  static int N, M;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    maxDistSave = new int[N][M];
    secret = new int[N][M];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(map[i][j] != 0) {
          bfs(i, j);
        }
      }
    }

    int max = 0;
    int maxY = 0;
    int maxX = 0;

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(max < maxDistSave[i][j]) {
          max = maxDistSave[i][j];
          maxY = i;
          maxX = j;
        }
        else if(max == maxDistSave[i][j]) {
          if(secret[i][j] > secret[maxY][maxX]) {
            maxY = i;
            maxX = j;
          }
        }
      }
    }

    sb.append(secret[maxY][maxX]);

    System.out.print(sb);

  }

  static void bfs(int y, int x) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{y, x});
    isVisited = new boolean[N][M];
    isVisited[y][x] = true;
    int[][] maxDist = new int[N][M];

    int startY = y;
    int startX = x;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx] && map[dy][dx] != 0) {
            queue.add(new int[]{dy, dx});
            maxDist[dy][dx] = maxDist[curY][curX] + 1;
            isVisited[dy][dx] = true;
          }
        }
      }
    }

    int maxDistance = 0;
    int targetY = startY;
    int targetX = startX;

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(maxDistance < maxDist[i][j]) {
          maxDistance = maxDist[i][j];
          targetY = i;
          targetX = j;
        }
      }
    }

    maxDistSave[startY][startX] = maxDistance;
    secret[startY][startX] = map[startY][startX] + map[targetY][targetX];
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
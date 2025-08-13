import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 1, -1, 1, -1, -1, 1};
  static int[] dirY = {-1, 1, 0, 0, 1, -1, -1};

  static char[][] map;
  static boolean[][] isVisited;

  static int N;

  static int n;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());

    map = new char[N][N];
    isVisited = new boolean[N][N];
    Queue<int[]> queue = new LinkedList<>();

    for(int i = 0; i < N; i++) {
      String k = br.readLine();
      for(int j = 0; j < N; j++) {
        map[i][j] = k.charAt(j);

        if(map[i][j] == 'F') {
          queue.add(new int[]{i, j});
          isVisited[i][j] = true;
        }
      }
    }

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      if(map[curY][curX] == '.') {
        n++;
      }

      for(int i = 0 ; i < 7; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx] && map[dy][dx] != '#') {
            queue.add(new int[]{dy, dx});
            isVisited[dy][dx] = true;
          }
        }
      }
    }

    sb.append(n);

    System.out.print(sb);

  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < N && dx < N) {
      return true;
    }
    else {
      return false;
    }
  }

}
import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static char[][] map;
  static char[][] ans;
  static boolean[][] isVisited;

  static int R, C;

  static int Hr, Hc;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new char[R][C];
    isVisited = new boolean[R][C];
    ans = new char[R][C];

    for(int i = 0; i < R; i++) {
      String k = br.readLine();
      for(int j = 0; j < C; j++) {
        map[i][j] = k.charAt(j);
        ans[i][j] = '#';
      }
    }

    st = new StringTokenizer(br.readLine());

    Hr = Integer.parseInt(st.nextToken()) - 1;
    Hc = Integer.parseInt(st.nextToken()) - 1;

    String k = br.readLine();

    char[] c = new char[k.length()];

    for(int i = 0; i < k.length(); i++) {
      c[i] = k.charAt(i);
    }

    for(char ch : c) {
      if(ch == 'W') {
        bfs(Hr, Hc);
      } else {
        int newHr = Hr;
        int newHc = Hc;
        switch (ch) {
          case 'U':
            newHr = Hr - 1;
            break;
          case 'D':
            newHr = Hr + 1;
            break;
          case 'L':
            newHc = Hc - 1;
            break;
          case 'R':
            newHc = Hc + 1;
            break;
        }
        if(checkArray(newHr, newHc)) {
          if(map[newHr][newHc] != '#') {
            Hr = newHr;
            Hc = newHc;
          }
        }
      }
    }

    ans[Hr][Hc] = '.';
    for(int i = 0; i < 4; i++) {
      int dy = Hr + dirY[i];
      int dx = Hc + dirX[i];
      if(checkArray(dy, dx)) {
        ans[dy][dx] = '.';
      }
    }

    for(int i = 0; i < R; i++) {
        sb.append(ans[i]).append("\n");
    }

    System.out.print(sb);
  }

  static void bfs(int startY, int startX) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{startY, startX});

    isVisited[startY][startX] = true;
    ans[startY][startX] = '.';

    char c = map[startY][startX];

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if (!isVisited[dy][dx] && map[dy][dx] == c) {
            ans[dy][dx] = '.';
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
    else {
      return false;
    }
  }

}
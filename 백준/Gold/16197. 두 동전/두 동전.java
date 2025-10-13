import java.util.*;
import java.io.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static char[][] map;
  static boolean[][] isVisited;

  static int N, M;

  static class Coin {
    int x;
    int y;
    public Coin(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new char[N][M];
    isVisited = new boolean[N][M];

    Coin one = null;
    Coin two = null;

    for(int i = 0; i < N; i++) {
      String line = br.readLine();
      for(int j = 0; j < M; j++) {
        map[i][j] = line.charAt(j);

        if(map[i][j] == 'o') {
          if(one == null) {
            one = new Coin(j, i);
          }
          else if(two == null) {
            two = new Coin(j, i);
          }
        }
      }
    }

    int result = bfs(one, two);

    sb.append(result);

    System.out.print(sb);
  }

  static int bfs(Coin one, Coin two) {
    Queue<Coin[]> queue = new LinkedList<>();
    queue.add(new Coin[]{one, two});

    HashSet<String> visit = new HashSet<>();

    String key = one.x + "," + one.y + "," + two.x + "," + two.y;

    visit.add(key);

    int cnt = 0;

    while(!queue.isEmpty()) {
      int size = queue.size();

      cnt++;

      for(int s = 0; s < size; s++) {
        Coin[] coins = queue.poll();
        Coin c1 = coins[0];
        Coin c2 = coins[1];

        if (cnt > 10) {
          return -1;
        }

        for (int i = 0; i < 4; i++) {
          int c1dx = c1.x + dirX[i];
          int c1dy = c1.y + dirY[i];

          int c2dx = c2.x + dirX[i];
          int c2dy = c2.y + dirY[i];

          boolean out1 = !checkArray(c1dy, c1dx);
          boolean out2 = !checkArray(c2dy, c2dx);

          if(out1 && out2) continue;

          if(out1 || out2) return cnt;

          if (map[c1dy][c1dx] == '#') {
            c1dx = c1.x;
            c1dy = c1.y;
          }

          if (map[c2dy][c2dx] == '#') {
            c2dx = c2.x;
            c2dy = c2.y;
          }

          String key1 = c1dx + "," + c1dy + "," + c2dx + "," + c2dy;
          String key2 = c2dx + "," + c2dy + "," + c1dx + "," + c1dy;

          if (visit.contains(key1) || visit.contains(key2)) {
            continue;
          }

          visit.add(key1);
          queue.add(new Coin[]{new Coin(c1dx, c1dy), new Coin(c2dx, c2dy)});
        }
      }
    }
    return -1;
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

import java.io.*;
import java.util.*;

public class Main {
  static int[] smallStone;
  static boolean[][] isVisited;

  static int N, M;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    smallStone = new int[10001];

    for(int i = 0; i < M; i++) {
      int n = Integer.parseInt(br.readLine());

      smallStone[n] = 1;
    }

    if(N == 1) {
      sb.append(0);
      System.out.print(sb);
      return;
    }

    int result = bfs();

    sb.append(result);

    System.out.print(sb);
  }

  static int bfs() {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{1, 0, 0});

    isVisited = new boolean[10001][150];
    isVisited[1][0] = true;

    while(!queue.isEmpty()) {
      int[] cur = queue.poll();
      int x = cur[0];
      int jump = cur[1];
      int cnt = cur[2];

      int[] next = {x + (jump - 1), x + jump, x + (jump + 1)};

      if(x == N) {
        return cnt;
      }

      for(int i = 0; i < 3; i++) {
        int dx = next[i];

        int curJump = next[i] - x;

        if(dx >= 1 && dx <= 10000 && curJump > 0 && curJump < 150) {
          if(!isVisited[dx][curJump] && smallStone[dx] != 1) {
            queue.add(new int[]{dx, curJump, cnt + 1});
            isVisited[dx][curJump] = true;
          }
        }
      }
    }

    return -1;
  }

}

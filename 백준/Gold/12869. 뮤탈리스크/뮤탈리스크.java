import java.io.*;
import java.util.*;

public class Main {
  static int[][] attackPattern = {
    {9, 3, 1}, {9, 1, 3}, {3, 9, 1},
    {3, 1, 9}, {1, 9, 3}, {1, 3, 9}
  };

  static boolean[][][] isVisited;

  static int[] hp;

  static int N;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    hp = new int[3];
    isVisited = new boolean[61][61][61];

    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < N; i++) {
      hp[i] = Integer.parseInt(st.nextToken());
    }

    int result = bfs();

    sb.append(result);

    System.out.print(sb);
  }

  static int bfs() {
    Queue<int[]> queue = new LinkedList<>();

    queue.add(new int[]{hp[0], hp[1], hp[2], 0});

    isVisited[hp[0]][hp[1]][hp[2]] = true;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int a = now[0];
      int b = now[1];
      int c = now[2];
      int cnt = now[3];

      if(a == 0 && b == 0 && c == 0) {
        return cnt;
      }

      for(int[] atk : attackPattern) {
        int na = Math.max(0, a - atk[0]);
        int nb = Math.max(0, b - atk[1]);
        int nc = Math.max(0, c - atk[2]);

        if(!isVisited[na][nb][nc]) {
          isVisited[na][nb][nc] = true;
          queue.add(new int[]{na, nb, nc, cnt + 1});
        }
      }
    }
    return -1;
  }

}

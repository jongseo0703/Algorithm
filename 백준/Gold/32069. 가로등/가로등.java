import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {-1, 1};

  static int[] map;
  static boolean[] isVisited;
  static int[] dist;

  static int L, N, K;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    L = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new int[L + 1];
    dist = new int[L + 1];
    isVisited = new boolean[L + 1];

    Arrays.fill(dist, Integer.MAX_VALUE);

    Queue<Integer> queue = new LinkedList<>();

    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < N; i++) {
      int x = Integer.parseInt(st.nextToken());

      map[x] = 1;
      queue.add(x);
      dist[x] = 0;
      isVisited[x] = true;
    }

    bfs(queue);

    Arrays.sort(dist);

    for(int i = 0; i < K; i++) {
      sb.append(dist[i]).append("\n");
    }

    System.out.print(sb);

  }

  static void bfs(Queue<Integer> queue) {
    while(!queue.isEmpty()) {
      int curX = queue.poll();

      for(int i = 0; i < 2; i++) {
        int nextX = curX + dirX[i];

        if(nextX >= 0 && nextX <= L) {
          if (!isVisited[nextX]) {
            dist[nextX] = dist[curX] + 1;
            queue.add(nextX);
            isVisited[nextX] = true;
          }
        }
      }
    }
  }

}

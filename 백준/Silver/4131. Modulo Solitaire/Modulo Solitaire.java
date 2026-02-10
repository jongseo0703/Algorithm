import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  static boolean[] isVisited;

  static int m, n, s0;

  static int[] a, b;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    s0 = Integer.parseInt(st.nextToken());

    isVisited = new boolean[m];

    a = new int[n];
    b = new int[n];

    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      a[i] = Integer.parseInt(st.nextToken());
      b[i] = Integer.parseInt(st.nextToken());
    }

    int result = bfs(s0);

    sb.append(result);

    System.out.print(sb);
  }

  static int bfs(int s) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);
    isVisited[s] = true;

    int step = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();

      for(int i = 0; i < size; i++) {
        int curS = queue.poll();

        if (curS == 0) {
          return step;
        }

        for (int j = 0; j < n; j++) {
          int nextS = (int)(((long)curS * a[j] + b[j]) % m);

          if (nextS < m && !isVisited[nextS]) {
            queue.add(nextS);
            isVisited[nextS] = true;
          }
        }
      }

      step++;

    }
    return -1;
  }
}
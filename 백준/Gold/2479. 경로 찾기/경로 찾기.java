import java.io.*;
import java.util.*;

public class Main {
  static char[][] map;

  static int[] parent;
  static boolean[] isVisited;

  static int N, K;

  static int A, B;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new char[N][K];

    for(int i = 0; i < N; i++) {
      String line = br.readLine();
      for(int j = 0; j < K; j++) {
        map[i][j] = line.charAt(j);
      }
    }

    parent = new int[N];
    isVisited = new boolean[N];

    Arrays.fill(parent, -1);

    st = new StringTokenizer(br.readLine());

    A = Integer.parseInt(st.nextToken()) - 1;
    B = Integer.parseInt(st.nextToken()) - 1;

    bfs();

    if(!isVisited[B]) {
      sb.append(-1);
    }
    else {
      List<Integer> path = new ArrayList<>();

      int cur = B;

      while(cur != -1) {
        path.add(cur + 1);
        cur = parent[cur];
      }

      Collections.reverse(path);

      for(int node : path) {
        sb.append(node + " ");
      }
    }

    System.out.print(sb);
  }

  static void bfs() {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(A);
    isVisited[A] = true;

    while(!queue.isEmpty()) {
      int cur = queue.poll();

      if(cur == B) {
        return;
      }

      for(int i = 0; i < N; i++) {
        if(!isVisited[i] && diffOne(map[cur], map[i])) {
          isVisited[i] = true;
          parent[i] = cur;
          queue.add(i);
        }
      }
    }
  }

  static boolean diffOne(char[] a, char[] b) {
    int diffCnt = 0;
    for(int i = 0; i < K; i++) {
      if(a[i] != b[i]) {
        diffCnt++;
      }

      if(diffCnt > 1) {
        return false;
      }
    }

    if(diffCnt == 1) {
      return true;
    }

    return false;
  }
}

import java.io.*;
import java.util.*;

public class Main {
  static int[] time = new int[100001];
  static int[] prev = new int[100001];

  static int N, K;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    Arrays.fill(time, -1);
    Arrays.fill(prev, -1);

    bfs();

    sb.append(time[K] + "\n");

    List<Integer> path = new ArrayList<>();
    int cur = K;
    while(cur != -1) {
      path.add(cur);
      cur = prev[cur];
    }
    Collections.reverse(path);

    for(int i = 0; i < path.size(); i++) {
      sb.append(path.get(i) + " ");
    }

    System.out.print(sb);
  }

  static void bfs() {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(N);

    time[N] = 0;
    prev[N] = -1;

    while(!queue.isEmpty()) {
      int curN = queue.poll();

      int[] dirN = {curN - 1, curN + 1, curN * 2};

      for(int i = 0; i < 3; i++) {
        int dN = dirN[i];

        if(dN >= 0 && dN <= 100000) {
          if(time[dN] == -1) {
            time[dN] = time[curN] + 1;
            prev[dN] = curN;
            queue.add(dN);
          }
        }
      }
    }
  }

}

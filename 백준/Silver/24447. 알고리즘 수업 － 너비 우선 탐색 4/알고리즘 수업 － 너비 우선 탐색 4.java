import java.io.*;
import java.util.*;

public class Main {
  static int N, M, R;

  static List<List<Integer>> list;
  static boolean[] isVisited;
  static long[] depth;
  static long[] visitedOrder;

  static int order = 1;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    list = new ArrayList<>();
    isVisited = new boolean[N + 1];
    depth = new long[N + 1];
    visitedOrder = new long[N + 1];

    for(int i = 0; i < N + 1; i++) {
      list.add(new ArrayList<>());
    }

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list.get(a).add(b);
      list.get(b).add(a);
    }

    Arrays.fill(depth, -1);

    for(int i = 1; i <= N; i++) {
      Collections.sort(list.get(i));
    }

    bfs(R);

    long sum = 0;

    for(int i = 1; i <= N; i++) {
      sum += (visitedOrder[i] * depth[i]);
    }

    sb.append(sum);

    System.out.print(sb);

  }

  static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    isVisited[start] = true;
    depth[start] = 0;
    visitedOrder[start] = order++;

    while(!queue.isEmpty()) {
      int curIndex = queue.poll();

      for(int next : list.get(curIndex)) {
        if(!isVisited[next]) {
          depth[next] = depth[curIndex] + 1;
          visitedOrder[next] = order++;
          isVisited[next] = true;
          queue.add(next);
        }
      }
    }
  }

}
import java.io.*;
import java.util.*;

public class Main {
  static List<List<Integer>> list;
  static boolean[] isVisited;
  static int[] depth;

  static int N, M, R;

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
    depth = new int[N + 1];

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

    bfs(R);

    for(int i = 1; i <= N; i++) {
      sb.append(depth[i]).append("\n");
    }

    System.out.print(sb);

  }

  static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    isVisited[start] = true;
    depth[start] = 0;

    while(!queue.isEmpty()) {
      int curNode = queue.poll();

      for(int next : list.get(curNode)) {
        if(!isVisited[next]) {
          queue.add(next);
          depth[next] = depth[curNode] + 1;
          isVisited[next] = true;
        }
      }
    }
  }

}
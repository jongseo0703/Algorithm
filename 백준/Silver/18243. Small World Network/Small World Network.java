import java.io.*;
import java.util.*;

public class Main {
  static List<List<Integer>> list;
  static boolean[] isVisited;
  static int[] dist;

  static int N, K;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    list = new ArrayList<>();

    for(int i = 0; i < N + 1; i++) {
      list.add(new ArrayList<>());
    }

    for(int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list.get(a).add(b);
      list.get(b).add(a);
    }

    boolean flag = true;

    for(int i = 1; i <= N; i++) {
      bfs(i);
      for(int j = 1; j <= N; j++) {
        if(i == j) {
          continue;
        }
        if(!isVisited[j] || dist[j] > 6) {
          flag = false;
          break;
        }
      }
      if(!flag) {
        break;
      }
    }

    if(flag) {
      sb.append("Small World!");
    }
    else {
      sb.append("Big World!");
    }

    System.out.print(sb);

  }

  static void bfs(int start) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{start, 0});
    isVisited = new boolean[N + 1];
    isVisited[start] = true;
    dist = new int[N + 1];

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curNode = now[0];
      int depth = now[1];

      for(int next : list.get(curNode)) {
        if(!isVisited[next]) {
          isVisited[next] = true;
          queue.add(new int[]{next, depth + 1});
          dist[next] = dist[curNode] + 1;
        }
      }
    }
  }

}
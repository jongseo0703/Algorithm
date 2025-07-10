import java.io.*;
import java.util.*;

public class Main {
  static List<List<Integer>> list;
  static List<List<Integer>> depth;
  static boolean[] isVisited;

  static int N, Q;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());

    list = new ArrayList<>();
    depth = new ArrayList<>();

    for(int i = 0; i < N + 1; i++) {
      list.add(new ArrayList<>());
      depth.add(new ArrayList<>());
    }

    for(int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());

      list.get(x).add(y);
      list.get(y).add(x);

      depth.get(x).add(d);
      depth.get(y).add(d);
    }

    for(int i = 0; i < Q; i++) {
      st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      sb.append(bfs(k, v)).append("\n");
    }

    System.out.print(sb);

  }

  static int bfs(int k, int start) {
    Queue<Integer> queue = new LinkedList<>();
    isVisited = new boolean[N + 1];
    queue.add(start);
    isVisited[start] = true;

    int count = 0;

    while(!queue.isEmpty()) {
      int curNode = queue.poll();

      List<Integer> l = list.get(curNode);
      List<Integer> dist = depth.get(curNode);

      for(int i = 0; i < l.size(); i++) {
        int t = l.get(i);
        int weight = dist.get(i);

        if(!isVisited[t] && weight >= k) {
          isVisited[t] = true;
          count++;
          queue.add(t);
        }
      }
    }
    return count;
  }

}
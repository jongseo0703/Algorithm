import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Main {
  static int[] money;
  static boolean[] isVisited;
  static List<List<Integer>> list;

  static int n, m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    money = new int[n];
    isVisited = new boolean[n];
    list = new ArrayList<>();
    for(int i = 0; i < n; i++) {
      list.add(new ArrayList<>());
    }

    for(int i = 0; i < n; i++) {
      money[i] = Integer.parseInt(br.readLine());
    }

    for(int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list.get(a).add(b);
      list.get(b).add(a);
    }

    for(int i = 0; i < n; i++) {
      if(!isVisited[i]) {
        int result = bfs(i);

        if(result != 0) {
          sb.append("IMPOSSIBLE");
          System.out.print(sb);
          return;
        }
      }
    }

    sb.append("POSSIBLE");

    System.out.print(sb);
  }

  static int bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);

    isVisited[start] = true;

    int sum = money[start];

    while(!queue.isEmpty()) {
      int curNode = queue.poll();

      for(int node : list.get(curNode)) {
        if(!isVisited[node]) {
          isVisited[node] = true;
          queue.add(node);
          sum += money[node];
        }
      }
    }

    return sum;
  }

}

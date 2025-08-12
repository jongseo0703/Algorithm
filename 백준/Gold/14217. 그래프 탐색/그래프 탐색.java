import java.io.*;
import java.util.*;

public class Main {
  static List<List<Integer>> list;
  static boolean[] isVisited;

  static int[] visit;

  static int n, m;

  static int q;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    list = new ArrayList<>();

    for(int i = 0; i <= n; i++) {
      list.add(new ArrayList<>());
    }

    for(int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list.get(a).add(b);
      list.get(b).add(a);
    }

    q = Integer.parseInt(br.readLine());

    for(int k = 0; k < q; k++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());

      if(a == 1) {
        if(!list.get(i).contains(j)) {
          list.get(i).add(j);
        }

        if(!list.get(j).contains(i)) {
          list.get(j).add(i);
        }
      }
      else if(a == 2) {
        list.get(i).remove(Integer.valueOf(j));
        list.get(j).remove(Integer.valueOf(i));
      }

      bfs(1);
      for(int city = 1; city <= n; city++) {
        sb.append(visit[city] + " ");
      }
      sb.append("\n");
    }

    System.out.print(sb);

  }

  static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);

    isVisited = new boolean[n + 1];
    isVisited[start] = true;

    visit = new int[n + 1];
    Arrays.fill(visit, -1);
    visit[start] = 0;

    while(!queue.isEmpty()) {
      int curCity = queue.poll();

      for(int next : list.get(curCity)) {
        if(!isVisited[next]) {
          queue.add(next);
          isVisited[next] = true;
          visit[next] = visit[curCity] + 1;
        }
      }
    }
  }

}
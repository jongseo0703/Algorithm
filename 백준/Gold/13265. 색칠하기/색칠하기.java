import java.io.*;
import java.util.*;

public class Main {
  static List<List<Integer>> list;
  static int[] color;

  static int T, n, m;

  static boolean isDiff;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    while(T-- > 0) {
      st = new StringTokenizer(br.readLine());

      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());

      color = new int[n + 1];

      list = new ArrayList<>();

      isDiff = true;

      for(int i = 0; i < n + 1; i++) {
        list.add(new ArrayList<>());
      }

      for(int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        list.get(a).add(b);
        list.get(b).add(a);
      }

      for(int i = 1; i <= n; i++) {
        if(color[i] == 0) {
          bfs(i);
        }
      }

      if(isDiff) {
        sb.append("possible").append("\n");
      }
      else {
        sb.append("impossible").append("\n");
      }
    }

    System.out.print(sb);

  }

  static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    color[start] = 1;

    while(!queue.isEmpty() && isDiff) {
      int now = queue.poll();

      for(int next : list.get(now)) {
        if(color[next] == 0) {
          color[next] = -color[now];
          queue.add(next);
        }
        else if(color[next] == color[now]){
          isDiff = false;
          return;
        }
      }
    }
  }

}
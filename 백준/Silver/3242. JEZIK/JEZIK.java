import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  static List<List<Integer>> list = new ArrayList<>();
  static boolean[] isVisited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    List<String> lines = new ArrayList<>();

    while(true) {
      String line = br.readLine();
      if(line == null) break;
      if(line.equals(".")) break;
      lines.add(line);
    }

    int n = lines.size();

    for(int i = 0; i < n; i++) {
      list.add(new ArrayList<>());
    }

    isVisited = new boolean[n];

    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(lines.get(i));
      String cmd = st.nextToken();

      if(cmd.equals("RADI")) {
        if(i + 1 < n) {
          list.get(i).add(i + 1);
        }
      }
      else if(cmd.equals("IDI")) {
        int a = Integer.parseInt(st.nextToken()) - 1;
        if(a >= 0 && a < n) list.get(i).add(a);

        if(st.hasMoreTokens()) {
          st.nextToken();
          int b = Integer.parseInt(st.nextToken()) - 1;
          if(b >= 0 && b < n) list.get(i).add(b);
        }
      }
    }

    bfs(0);

    int cnt = 0;

    for(int i = 0; i < n; i++) {
      if(!isVisited[i]) cnt++;
    }

    sb.append(cnt);

    System.out.print(sb);
  }

  static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    isVisited[start] = true;

    while(!queue.isEmpty()) {
      int node = queue.poll();

      for(int next : list.get(node)) {
        if(!isVisited[next]) {
          queue.add(next);
          isVisited[next] = true;
        }
      }
    }
  }

}

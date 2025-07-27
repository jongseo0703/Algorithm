import java.io.*;
import java.util.*;

public class Main {
  static final int[][] flipIdx = {
    {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
    {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
    {0, 4, 8}, {2, 4, 6}
  };

  static final String TARGET1 = "HHHHHHHHH";
  static final String TARGET2 = "TTTTTTTTT";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      String[] map = new String[3];

      for (int i = 0; i < 3; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String k = "";
        for (int j = 0; j < 3; j++) {
          k += st.nextToken();
        }
        map[i] = k;
      }

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 3; i++) {
        sb.append(map[i]);
      }
      String start = sb.toString();

      System.out.println(bfs(start));
    }
  }

  static int bfs(String start) {
    Queue<String> queue = new LinkedList<>();
    Map<String, Integer> visited = new HashMap<>();

    queue.add(start);
    visited.put(start, 0);

    while (!queue.isEmpty()) {
      String cur = queue.poll();
      int depth = visited.get(cur);

      if (cur.equals(TARGET1) || cur.equals(TARGET2)) {
        return depth;
      }

      for (int[] flip : flipIdx) {
        char[] next = cur.toCharArray();
        for (int idx : flip) {
          next[idx] = (next[idx] == 'H') ? 'T' : 'H';
        }

        String nextStr = new String(next);
        if (!visited.containsKey(nextStr)) {
          visited.put(nextStr, depth + 1);
          queue.add(nextStr);
        }
      }
    }

    return -1;
  }
}

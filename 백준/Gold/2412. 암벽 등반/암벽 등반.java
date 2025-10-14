import java.io.*;
import java.util.*;

public class Main {
  static int n, T;

  static class Home {
    int x;
    int y;
    public Home(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    Map<Integer, List<Home>> map = new HashMap<>();

    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      map.computeIfAbsent(y, k -> new ArrayList<>()).add(new Home(x, y));
    }

    int result = bfs(map);

    sb.append(result);

    System.out.print(sb);
  }

  static int bfs(Map<Integer, List<Home>> map) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0, 0});

    Set<String> isVisited = new HashSet<>();
    isVisited.add("0,0");

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int x = now[0];
      int y = now[1];
      int cnt = now[2];

      if(y == T) {
        return cnt;
      }

      for(int ny = y - 2; ny <= y + 2; ny++) {
        if(!map.containsKey(ny)) continue;

        List<Home> list = map.get(ny);

        for(Home h : list) {
          int diffX = Math.abs(x - h.x);
          int diffY = Math.abs(y - h.y);

          if(diffX <= 2 && diffY <= 2) {
            String key = h.x + "," + h.y;

            if(!isVisited.contains(key)) {
              isVisited.add(key);
              queue.add(new int[]{h.x, h.y, cnt + 1});
            }
          }
        }
      }
    }
    return -1;
  }

}

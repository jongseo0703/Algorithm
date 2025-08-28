import java.util.*;
import java.io.*;

public class Main {
  static long[] minWater = new long[1000001];
  static long[] minDay = new long[1000001];

  static int N;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());

    Arrays.fill(minWater, Integer.MAX_VALUE);
    Arrays.fill(minDay, Integer.MAX_VALUE);

    long[] result = bfs();

    sb.append(result[0] + " " + result[1]);

    System.out.print(sb);
  }

  static long[] bfs() {
    PriorityQueue<long[]> pq = new PriorityQueue<>(
      (a, b) -> {
        if(a[1] != b[1]) return Long.compare(a[1], b[1]);
        return Long.compare(a[2], b[2]);
      }
    );

    pq.add(new long[]{0, 0, 0});
    minWater[0] = 0;
    minDay[0] = 0;

    while(!pq.isEmpty()) {
      long[] now = pq.poll();
      long curNode = now[0];
      long day = now[1];
      long water = now[2];

      if(curNode == N) {
        return new long[]{day, water};
      }

      long[] behavior = {curNode + 1, curNode * 3, curNode * curNode};
      long[] watering = {1, 3, 5};

      for(int i = 0; i < 3; i++) {
        long next = behavior[i];

        long newDay = day + 1;
        long newWater = water + watering[i];
        if(next <= 1000000) {
          if(newDay < minDay[(int)next] || (newDay == minDay[(int)next]) && newWater < minWater[(int)next]) {
            minDay[(int)next] = newDay;
            minWater[(int)next] = newWater;
            pq.add(new long[]{next, newDay, newWater});
          }
        }
      }
    }

    return new long[]{-1, -1};
  }

}

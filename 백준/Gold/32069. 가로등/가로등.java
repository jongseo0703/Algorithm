import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long L = Long.parseLong(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    Queue<long[]> queue = new LinkedList<>();
    Set<Long> visited = new HashSet<>();

    for (int i = 0; i < N; i++) {
      long x = Long.parseLong(st.nextToken());
      queue.add(new long[]{x, 0});
      visited.add(x);
    }

    List<Long> answer = new ArrayList<>();
    int[] dir = {-1, 1};

    while (!queue.isEmpty() && answer.size() < K) {
      long[] cur = queue.poll();
      long x = cur[0];
      long d = cur[1];

      answer.add(d);

      for (int i = 0; i < 2; i++) {
        long nx = x + dir[i];
        if (nx >= 0 && nx <= L && !visited.contains(nx)) {
          queue.add(new long[]{nx, d + 1});
          visited.add(nx);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < K; i++) {
      sb.append(answer.get(i)).append("\n");
    }

    System.out.print(sb);
  }
}

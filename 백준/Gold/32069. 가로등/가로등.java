import java.io.*;
import java.util.*;

public class Main {
  static long[] dirX = {-1, 1};

  static Set<Long> isVisited;
  static List<Long> distList;

  static Long L;
  static int N, K;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    L = Long.parseLong(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    isVisited = new HashSet<>();
    distList = new ArrayList<>();

    Queue<long[]> queue = new LinkedList<>();

    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < N; i++) {
      long x = Long.parseLong(st.nextToken());
      queue.add(new long[]{x, 0L});
      isVisited.add(x);
    }

    bfs(queue);

    for(int i = 0; i < K; i++) {
      sb.append(distList.get(i)).append("\n");
    }

    System.out.print(sb);

  }

  static void bfs(Queue<long[]> queue) {
    while(!queue.isEmpty() && distList.size() < K) {
      long[] now = queue.poll();
      long curX = now[0];
      long dist = now[1];

      distList.add(dist);

      for(int i = 0; i < 2; i++) {
        long nextX = curX + dirX[i];

        if(nextX >= 0 && nextX <= L) {
          if (!isVisited.contains(nextX)) {
            queue.add(new long[]{nextX, dist + 1});
            isVisited.add(nextX);
          }
        }
      }
    }
  }

}

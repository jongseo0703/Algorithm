import java.io.*;
import java.util.*;

public class Main {
  static int N, K;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    System.out.println(bfs() ? "minigimbob" : "water");
  }

  static boolean bfs() {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    int[] cnt = new int[N + 1];

    while (!queue.isEmpty()) {
      int step = queue.poll();

      if(step == N && cnt[step] <= K) {
        return true;
      }

      if(cnt[step] == K) {
        continue;
      }

      int next1 = step + 1;
      if (next1 <= N && cnt[next1] == 0) {
        cnt[next1] = cnt[step] + 1;
        queue.add(next1);
      }

      if (step >= 1) {
        int next2 = step + (step / 2);
        if (next2 <= N && cnt[next2] == 0) {
          cnt[next2] = cnt[step] + 1;
          queue.add(next2);
        }
      }
    }
    return false;
  }
}

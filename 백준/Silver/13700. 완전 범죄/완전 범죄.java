import java.io.*;
import java.util.*;

public class Main {
  static int[] police;
  static boolean[] isVisited;

  static int N, S, D, F, B, K;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());
    F = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    police = new int[N + 1];
    isVisited = new boolean[N + 1];

    if(K > 0) {
      st = new StringTokenizer(br.readLine());
    }

    for(int i = 0; i < K; i++) {
      int p = Integer.parseInt(st.nextToken());
      police[p] = 1;
    }

    int result = bfs(S);

    if(result == -1) {
      sb.append("BUG FOUND");
    }
    else {
      sb.append(result);
    }

    System.out.print(sb);

  }

  static int bfs(int start) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{start, 0});
    isVisited[start] = true;

    int[] dirN = {F, -B};

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curNode = now[0];
      int cnt = now[1];

      if(curNode == D) {
        return cnt;
      }

      for(int i = 0; i < 2; i++) {
        int next = curNode + dirN[i];
        if(next >= 0 && next <= N) {
            if (!isVisited[next] && police[next] != 1) {
              isVisited[next] = true;
              queue.add(new int[]{next, cnt + 1});
            }
        }
      }
    }
    return -1;
  }

}
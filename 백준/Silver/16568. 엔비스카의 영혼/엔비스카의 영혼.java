import java.io.*;
import java.util.*;

public class Main {
  static boolean[] isVisited;

  static int N, a, b;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

    isVisited = new boolean[1000001];

    int result = bfs(N);

    sb.append(result);

    System.out.print(sb);

  }

  static int bfs(int start) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{start, 0});
    isVisited[start] = true;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curNode = now[0];
      int time = now[1];

      if(curNode == 0) {
        return time;
      }

      int next1 = curNode - (1 + a);

      if(next1 >= 0 && !isVisited[next1]) {
        isVisited[next1] = true;
        queue.add(new int[]{next1, time + 1});
      }

      int next2 = curNode - (1 + b);

      if(next2 >= 0 && !isVisited[next2]) {
        isVisited[next2] = true;
        queue.add(new int[]{next2, time + 1});
      }

      int next3 = curNode - 1;

      if(next3 >= 0 && !isVisited[next3]) {
        isVisited[next3] = true;
        queue.add(new int[]{next3, time + 1});
      }
    }
    return -1;
  }

}
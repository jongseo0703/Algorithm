import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {-1, 1};

  static List<List<Integer>> list;
  static boolean[] isVisited;

  static int N, M, S, E;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    S = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    list = new ArrayList<>();
    isVisited = new boolean[N + 1];

    for(int i = 0; i < N + 1; i++) {
      list.add(new ArrayList<>());
    }

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      list.get(x).add(y);
      list.get(y).add(x);
    }

    sb.append(bfs(S));

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

      if(curNode == E) {
        return time;
      }

      for(int next : list.get(curNode)) {
        if(!isVisited[next]) {
          isVisited[next] = true;
          queue.add(new int[]{next, time + 1});
        }
      }

      for(int i = 0; i < 2; i++) {
        int next = curNode + dirX[i];

        if(next >= 0 && next <= N) {
          if (!isVisited[next]) {
            isVisited[next] = true;
            queue.add(new int[]{next, time + 1});
          }
        }
      }
    }
    return -1;
  }

}
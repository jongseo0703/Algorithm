import java.io.*;
import java.util.*;

public class Main {
  static List<List<Integer>> list;
  static boolean[] isVisited;
  static boolean[] isLocked;

  static int N, M, K;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    list = new ArrayList<>();
    isVisited = new boolean[N + 2];
    isLocked = new boolean[N + 2];

    for(int i = 0; i <= N + 1; i++) {
      list.add(new ArrayList<>());
    }

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      list.get(u).add(v);
      list.get(v).add(u);
    }

    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < K; i++) {
      int n = Integer.parseInt(st.nextToken());

      isLocked[n] = true;
    }

    int result = bfs();

    sb.append(result);

    System.out.print(sb);
  }

  static int bfs() {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);

    isVisited[1] = true;

    int visitCount = 0;

    while(!queue.isEmpty()) {
      int curNode = queue.poll();

      for(int next : list.get(curNode)) {
        if(!isVisited[next] && !isLocked[next]) {
          isVisited[next] = true;
          queue.add(next);
          visitCount++;
        }
      }
    }

    return visitCount;
  }

}

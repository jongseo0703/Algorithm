import java.io.*;
import java.util.*;

public class Main {
  static List<List<Integer>> list;
  static int[] rumorCnt;
  static int[] time;

  static int N, M;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    list = new ArrayList<>();
    rumorCnt = new int[N + 1];
    time = new int[N + 1];

    Arrays.fill(time, -1);

    for(int i = 0; i < N + 1; i++) {
      list.add(new ArrayList<>());
    }

    for(int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());

      while(st.hasMoreTokens()) {
        int n = Integer.parseInt(st.nextToken());

        if(n != 0) {
          list.get(i).add(n);
          list.get(n).add(i);
        }
      }
    }

    M = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < M; i++) {
      int n = Integer.parseInt(st.nextToken());

      time[n] = 0;
    }

    bfs();

    for(int i = 1; i <= N; i++) {
      sb.append(time[i] + " ");
    }

    System.out.print(sb);
  }

  static void bfs() {
    Queue<Integer> queue = new LinkedList<>();

    for(int i = 1; i <= N; i++) {
      if(time[i] == 0) {
        queue.add(i);
      }
    }

    while(!queue.isEmpty()) {
      int cur = queue.poll();

      for(int next : list.get(cur)) {
        if(time[next] != -1) continue;

        rumorCnt[next]++;

        if(rumorCnt[next] * 2 >= list.get(next).size()) {
          time[next] = time[cur] + 1;
          queue.add(next);
        }
      }
    }
  }

}

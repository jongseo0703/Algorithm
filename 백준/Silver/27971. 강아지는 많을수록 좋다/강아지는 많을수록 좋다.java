import java.io.*;
import java.util.*;

public class Main {
  static boolean[] isVisited = new boolean[1000001];

  static int N, M, A, B;
  static int L, R;

  static int[] l;
  static int[] r;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());

    l = new int[M];
    r = new int[M];

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      L = Integer.parseInt(st.nextToken());
      R = Integer.parseInt(st.nextToken());

      l[i] = L;
      r[i] = R;
    }

    int result = bfs();

    sb.append(result);

    System.out.print(sb);

  }

  static int bfs() {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0});
    isVisited[0] = true;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curPuppy = now[0];
      int cnt = now[1];

      boolean flag = true;

      for(int i = 0; i < M; i++) {
        if(curPuppy >= l[i] && curPuppy <= r[i]) {
          flag = false;
        }
      }

      if(flag == false) {
        continue;
      }

      if(curPuppy == N) {
        return cnt;
      }

      int[] dirP = {A, B};

      for(int i = 0; i < 2; i++) {
        int dPuppy = curPuppy + dirP[i];

        if(dPuppy < 1000001) {
          if (!isVisited[dPuppy]) {
            isVisited[dPuppy] = true;
            queue.add(new int[]{dPuppy, cnt + 1});
          }
        }
      }
    }
    return -1;
  }

}
import java.io.*;
import java.util.*;

public class Main {
  static boolean[] isVisited;

  static int T;
  static int N, A, B;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    while(T-- > 0) {
      st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());

      isVisited = new boolean[1000001];

      sb.append(bfs(N)).append("\n");
    }

    System.out.print(sb);

  }

  static int bfs(int N) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{N, 0});
    isVisited[N] = true;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curNode = now[0];
      int cnt = now[1];

      if(curNode >= A && curNode <= B && isPrime(curNode)) {
        return cnt;
      }

      int[] d1 = {2, 3};

      for(int i = 0; i < 2; i++) {
        int nextNode = curNode / d1[i];

        if(!isVisited[nextNode]) {
          queue.add(new int[]{nextNode, cnt + 1});
          isVisited[nextNode] = true;
        }
      }

      int[] d2 = {1, -1};

      for(int i = 0; i < 2; i++) {
        int nextNode = curNode + d2[i];

        if(nextNode >= 0 && nextNode <= 1000000 && !isVisited[nextNode]) {
          queue.add(new int[]{nextNode, cnt + 1});
          isVisited[nextNode] = true;
        }
      }
    }
    return -1;
  }

  static boolean isPrime(int n) {
    if(n < 2) {
      return false;
    }

    for(int i = 2; i < n; i++) {
      if(n % i == 0) {
        return false;
      }
    }
    return true;
  }

}
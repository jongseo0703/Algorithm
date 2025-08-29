import java.io.*;
import java.util.*;

public class Main {
  static boolean[] isVisited;

  static int T;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    T = Integer.parseInt(br.readLine());

    while(T-- > 0) {
      int k = Integer.parseInt(br.readLine());

      int result = bfs(k);

      if(result == -1) {
        sb.append("Wrong proof!").append("\n");
      }
      else {
        sb.append(result).append("\n");
      }
    }

    System.out.print(sb);
  }

  static int bfs(int k) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{1, 0});

    isVisited = new boolean[4000001];
    isVisited[1] = true;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curK = now[0];
      int cnt = now[1];

      if(curK == k) {
        return cnt;
      }

      int[] nextStep = {curK - 1, curK * 2};

      for(int i = 0; i < 2; i++) {
        int nextK = nextStep[i];

        if(nextK >= 0 && nextK <= 4000000) {
          if(!isVisited[nextK]) {
            isVisited[nextK] = true;
            queue.add(new int[]{nextK, cnt + 1});
          }
        }
      }
    }
    return -1;
  }

}
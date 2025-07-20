import java.io.*;
import java.util.*;

public class Main {
  static boolean[][] isVisited;

  static int C, S, T;

  public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringBuilder sb = new StringBuilder();

      StringTokenizer st;

      C = Integer.parseInt(br.readLine());

      while(C-- > 0) {
        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        isVisited = new boolean[1001][1001];

        sb.append(bfs(S, T)).append("\n");
      }

      System.out.print(sb);

  }

  static int bfs(int score, int target) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{score, target, 0});
    isVisited[score][target] = true;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curScore = now[0];
      int targetScore = now[1];
      int cnt = now[2];

      if(curScore == targetScore) {
        return cnt;
      }

      if(curScore > targetScore) {
        continue;
      }

      int nextScore = curScore * 2;
      int nextTarget = targetScore + 3;

      if(nextScore < 1001 && nextTarget < 1001) {
        if(!isVisited[nextScore][nextTarget]) {
          queue.add(new int[]{nextScore, nextTarget, cnt + 1});
          isVisited[nextScore][nextTarget] = true;
        }
      }

      int nextScore2 = curScore + 1;
      int nextTarget2 = targetScore;

      if(nextScore2 < 1001 && nextTarget2 < 1001) {
        if(!isVisited[nextScore2][nextTarget2]) {
          queue.add(new int[]{nextScore2, nextTarget2, cnt + 1});
          isVisited[nextScore2][nextTarget2] = true;
        }
      }
    }
    return -1;
  }

}

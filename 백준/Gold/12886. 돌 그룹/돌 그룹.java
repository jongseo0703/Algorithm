import java.io.*;
import java.util.*;

public class Main {
  static boolean[][] isVisited = new boolean[1501][1501];

  static int A, B, C;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    boolean result = bfs();

    if(result) {
      sb.append(1);
    }
    else {
      sb.append(0);
    }

    System.out.print(sb);
  }

  static boolean bfs() {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{A, B});
    isVisited[A][B] = true;

    int total = A + B + C;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curA = now[0];
      int curB = now[1];
      int curC = total - curA - curB;

      if(curA == curB && curB == curC) {
        return true;
      }

      int[] abc = {curA, curB, curC};

      for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
          if(abc[i] < abc[j]) {
            int[] next = Arrays.copyOf(abc, 3);
            next[i] += abc[i];
            next[j] -= abc[i];

            int dA = next[0];
            int dB = next[1];
            int dC = next[2];

            if(!isVisited[dA][dB]) {
              isVisited[dA][dB] = true;
              queue.add(new int[]{dA, dB});
            }
          }
        }
      }


    }

    return false;
  }

}

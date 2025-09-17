import java.io.*;
import java.util.*;

public class Main {
  static char[] command = {'D', 'S', 'L', 'R'};

  static int T;

  static int A, B;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    while(T-- > 0) {
      st = new StringTokenizer(br.readLine());
      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());

      String result = bfs();

      sb.append(result).append("\n");
    }

    System.out.print(sb);
  }

  static String bfs() {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(A, ""));

    boolean[] isVisited = new boolean[10000];
    isVisited[A] = true;

    while(!queue.isEmpty()) {
      Node node = queue.poll();
      int curA = node.num;
      String cmd = node.cmd;

      if(curA == B) {
        return cmd;
      }

      for(int i = 0; i < 4; i++) {
        int dA = cal(curA, command[i]);

        if(!isVisited[dA]) {
          isVisited[dA] = true;
          queue.add(new Node(dA, cmd + command[i]));
        }
      }
    }
    return "";
  }

  static int cal(int n, char command) {
    int result = 0;

    int d1 = 0;
    int d2 = 0;
    int d3 = 0;
    int d4 = 0;

    d1 = n / 1000;
    d2 = (n % 1000) / 100;
    d3 = ((n % 1000) % 100) / 10;
    d4 = ((n % 1000) % 100) % 10;

    switch(command) {
      case 'D' :
        result = n * 2;
        if(result > 9999) {
          result = result % 10000;
        }
        break;
      case 'S' :
        if(n == 0) {
          result = 9999;
        }
        else {
          result = n - 1;
        }
        break;
      case 'L' :
        result = d2 * 1000 + d3 * 100 + d4 * 10 + d1;
        break;
      case 'R' :
        result = d4 * 1000 + d1 * 100 + d2 * 10 + d3;
        break;
    }
    return result;
  }

  static class Node {
    int num;
    String cmd;
    Node(int num, String cmd) {
      this.num = num;
      this.cmd = cmd;
    }
  }

}

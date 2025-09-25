import java.io.*;
import java.util.*;

public class Main {

  static class Node {
    long n;
    String path;

    Node(long n, String path) {
      this.n = n;
      this.path = path;
    }
  }

  static long s, t;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    s = Long.parseLong(st.nextToken());
    t = Long.parseLong(st.nextToken());

    if(s == t) {
      sb.append(0);
      System.out.print(sb);
      return;
    }

    String result = bfs();

    if(result == null) {
      sb.append(-1);
    }
    else {
      sb.append(result);
    }

    System.out.print(sb);
  }

  static String bfs() {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(s, ""));

    Set<Long> isVisited = new HashSet<>();
    isVisited.add(s);

    while(!queue.isEmpty()) {
      Node node = queue.poll();
      long curS = node.n;
      String curPath = node.path;

      String[] dirS = {"*", "+", "-", "/"};

      if(curS == t) {
        return curPath;
      }

      for(int i = 0; i < 4; i++) {
        long dS = calc(dirS[i], curS);

        if(dS >= 1 && dS <= 1_000_000_000 && !isVisited.contains(dS)) {
          isVisited.add(dS);
          queue.add(new Node(dS, curPath + dirS[i]));
        }
      }
    }
    return null;
  }

  static long calc(String k, long s) {
    long n = 0;

    switch(k) {
      case "+" :
        n = s + s;
        break;
      case "*" :
        n = s * s;
        break;
      case "-" :
        n = s - s;
        break;
      case "/" :
        if(s != 0) {
          n = s / s;
          break;
        }
    }

    return n;
  }

}

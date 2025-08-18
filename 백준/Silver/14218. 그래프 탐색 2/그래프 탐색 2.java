import java.io.*;
import java.util.*;

public class Main {
  static List<List<Integer>> list;
  static boolean[] isVisited;
  static int[] visitedCity;

  static int n, m, q;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    list = new ArrayList<>();

    for(int i = 0; i < n + 1; i++) {
      list.add(new ArrayList<>());
    }

    for(int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int city1 = Integer.parseInt(st.nextToken());
      int city2 = Integer.parseInt(st.nextToken());

      list.get(city1).add(city2);
      list.get(city2).add(city1);
    }

    q = Integer.parseInt(br.readLine());

    for(int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int city1 = Integer.parseInt(st.nextToken());
      int city2 = Integer.parseInt(st.nextToken());

      list.get(city1).add(city2);
      list.get(city2).add(city1);

      isVisited = new boolean[n + 1];
      visitedCity = new int[n + 1];

      bfs();

      for(int j = 1; j < visitedCity.length; j++) {
        sb.append(visitedCity[j] + " ");
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }

  static void bfs() {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    isVisited[1] = true;
    Arrays.fill(visitedCity, -1);
    visitedCity[1] = 0;

    while(!queue.isEmpty()) {
      int curCity = queue.poll();

      for(int next : list.get(curCity)) {
        if(!isVisited[next]) {
          queue.add(next);
          isVisited[next] = true;
          visitedCity[next] = visitedCity[curCity] + 1;
        }
      }
    }
  }

}
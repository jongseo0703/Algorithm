import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static int[][] map;
  static boolean[][] isVisited;

  static int N, M;

  static int answer = Integer.MAX_VALUE;

  static List<int[]> virusList = new ArrayList<>();
  static int[] selected;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][N];;
    selected = new int[M];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());

        if(map[i][j] == 2) {
          virusList.add(new int[]{i, j});
        }
      }
    }

    combination(0, 0);

    if(answer == Integer.MAX_VALUE) {
      sb.append("-1");
    }
    else {
      sb.append(answer);
    }

    System.out.print(sb);
  }

  static void combination(int depth, int start) {
    if(depth == M) {
      bfs();
      return;
    }

    for(int i = start; i < virusList.size(); i++) {
      selected[depth] = i;
      combination(depth + 1, i + 1);
    }
  }

  static void bfs() {
    Queue<int[]> queue = new LinkedList<>();

    isVisited = new boolean[N][N];

    int[][] time = new int[N][N];

    for(int[] row : time) {
      Arrays.fill(row, -1);
    }

    for(int idx : selected) {
      int[] v = virusList.get(idx);
      queue.add(v);
      isVisited[v[0]][v[1]] = true;
      time[v[0]][v[1]] = 0;
    }

    int maxTime = 0;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx] && map[dy][dx] != 1) {
            isVisited[dy][dx] = true;
            time[dy][dx] = time[curY][curX] + 1;
            queue.add(new int[]{dy, dx});
          }
        }
      }
    }

    if(allSpread(time)) {
      for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
          if(map[i][j] != 1) {
            if(time[i][j] != -1) {
              maxTime = Math.max(maxTime, time[i][j]);
            }
          }
        }
      }
      answer = Math.min(maxTime, answer);
    }
  }

  static boolean allSpread(int[][] time) {
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        if(map[i][j] != 1 && time[i][j] == -1) {
          return false;
        }
      }
    }

    return true;
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < N && dx < N) {
      return true;
    }
    else {
      return false;
    }
  }

}

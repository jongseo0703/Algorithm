import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static int[][] map;
  static int[][] cloneMap;
  static boolean[][] isVisited;

  static List<int[]> changed = new ArrayList<>();

  static int N, M;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    cloneMap = new int[N][M];
    isVisited = new boolean[N][M];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        cloneMap[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(map[i][j] != cloneMap[i][j]) {
          changed.add(new int[]{i, j});
        }
      }
    }

    if(changed.isEmpty()) {
      sb.append("YES");
      System.out.print(sb);
      return;
    }

    int startY = changed.get(0)[0];
    int startX = changed.get(0)[1];
    int origin = map[startY][startX];
    int target = cloneMap[startY][startX];

    bfs(startY, startX, origin, target);

    boolean flag = true;


    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(map[i][j] != cloneMap[i][j]) {
          flag = false;
          break;
        }
      }
    }


    if(flag) {
      sb.append("YES");
    }
    else {
      sb.append("NO");
    }

    System.out.print(sb);

  }

  static void bfs(int y, int x, int origin, int target) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{y, x});
    isVisited[y][x] = true;
    map[y][x] = target;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx] && map[dy][dx] == origin) {
            queue.add(new int[]{dy, dx});
            map[dy][dx] = target;
            isVisited[dy][dx] = true;
          }
        }
      }
    }
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < N && dx < M) {
      return true;
    }
    else {
      return false;
    }
  }

}
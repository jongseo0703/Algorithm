import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static int[][] map;
  static boolean[][] isVisited;

  static int N, L, R;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    map = new int[N][N];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int result = move();

    sb.append(result);

    System.out.print(sb);
  }

  static int move() {
    int days = 0;

    while(true) {
      boolean moved = false;
      isVisited = new boolean[N][N];

      for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
          if(!isVisited[i][j]) {
            List<int[]> union = bfs(i, j);

            if(union.size() > 1) {
              moved = true;
              int sum = 0;
              for(int[] pos : union) {
                sum += map[pos[0]][pos[1]];
              }
              int newA = sum / union.size();
              for(int[] pos : union) {
                map[pos[0]][pos[1]] = newA;
              }
            }
          }
        }
      }
      if(!moved) {
        break;
      }
      days++;
    }

    return days;
  }

  static List<int[]> bfs(int y, int x) {
    Queue<int[]> queue = new LinkedList<>();
    List<int[]> union = new ArrayList<>();

    queue.add(new int[]{y, x});
    isVisited[y][x] = true;
    union.add(new int[]{y, x});

    int diff = 0;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        int curN = map[curY][curX];

        if(checkArray(dy, dx) && !isVisited[dy][dx]) {
          diff = Math.abs(map[dy][dx] - curN);
          if(diff >= L && diff <= R) {
            isVisited[dy][dx] = true;
            queue.add(new int[]{dy, dx});
            union.add(new int[]{dy, dx});
          }
        }
      }
    }
    return union;
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
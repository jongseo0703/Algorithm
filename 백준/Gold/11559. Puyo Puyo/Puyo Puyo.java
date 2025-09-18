import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, -1, 1};
  static int[] dirY = {-1, 1, 0, 0};

  static char[][] map;

  static int combo;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    map = new char[12][6];

    for(int i = 0; i < 12; i++) {
      String line = br.readLine();
      for(int j = 0; j < 6; j++) {
        map[i][j] = line.charAt(j);
      }
    }

    while(true) {
      boolean exploded = false;
      List<int[]> allToExplode = new ArrayList<>();

      for (int i = 0; i < 12; i++) {
        for (int j = 0; j < 6; j++) {
          if (map[i][j] != '.') {
            List<int[]> group = bfs(i, j);

            if(group.size() >= 4) {
              exploded = true;
              allToExplode.addAll(group);
            }
          }
        }
      }

      if(!exploded) {
        break;
      }

      for(int[] i : allToExplode) {
        map[i[0]][i[1]] = '.';
      }

      gravity();
      combo++;
    }

    sb.append(combo);

    System.out.print(sb);
  }

  static List<int[]> bfs(int y, int x) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{y, x});

    boolean[][] isVisited = new boolean[12][6];
    isVisited[y][x] = true;

    List<int[]> group = new ArrayList<>();
    group.add(new int[]{y, x});

    char c = map[y][x];

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];

      for(int i = 0; i < 4; i++) {
        int dy = curY + dirY[i];
        int dx = curX + dirX[i];

        if(checkArray(dy, dx)) {
          if(!isVisited[dy][dx] && map[dy][dx] == c) {
            group.add(new int[]{dy, dx});
            isVisited[dy][dx] = true;
            queue.add(new int[]{dy, dx});
          }
        }
      }
    }

    return group;
  }

  static void gravity() {
    for(int i = 0; i < 6; i++) {
      int n = 11;
      for(int j = 11; j >= 0; j--) {
        if(map[j][i] != '.') {
          char temp = map[j][i];
          map[j][i] = '.';
          map[n--][i] = temp;
        }
      }
    }
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < 12 && dx < 6) {
      return true;
    }
    else {
      return false;
    }
  }

}

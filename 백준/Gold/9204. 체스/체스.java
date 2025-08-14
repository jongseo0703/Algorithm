import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {-1, -1, 1, 1};
  static int[] dirY = {-1, 1, -1, 1};

  static List<String> stepX;
  static List<Integer> stepY;

  static int[][] map;
  static boolean[][] isVisited;

  static int[][][] parent;

  static int T;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    while(T-- > 0) {
      st = new StringTokenizer(br.readLine());
      String a = st.nextToken();
      int b = Integer.parseInt(st.nextToken()) - 1;
      String c = st.nextToken();
      int d = Integer.parseInt(st.nextToken()) - 1;

      int startX = mapping(a);
      int startY = b;
      int targetX = mapping(c);
      int targetY = d;

      map = new int[8][8];
      isVisited = new boolean[8][8];
      stepX = new LinkedList<>();
      stepY = new LinkedList<>();

      int result = bfs(startY, startX, targetY, targetX);

      if(result == -1) {
        sb.append("Impossible");
      }
      else {
        sb.append(result + " ");
        for(int i = 0; i < stepX.size(); i++) {
          sb.append(stepX.get(i) + " " + stepY.get(i) + " ");
        }
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }

  static int bfs(int startY, int startX, int targetY, int targetX) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{startY, startX, 0});

    parent = new int[8][8][2];

    for(int i = 0; i < 8; i++) {
      for(int j = 0; j < 8; j++) {
        parent[i][j][0] = -1;
        parent[i][j][1] = -1;
      }
    }

    isVisited[startY][startX] = true;

    while(!queue.isEmpty()) {
      int[] now = queue.poll();
      int curY = now[0];
      int curX = now[1];
      int cnt = now[2];

      if(curY == targetY && curX == targetX) {
        List<String> tempX = new ArrayList<>();
        List<Integer> tempY = new ArrayList<>();
        int ty = curY, tx = curX;
        while (!(ty == startY && tx == startX)) {
          tempX.add(mapping(tx));
          tempY.add(ty + 1);
          int py = parent[ty][tx][0];
          int px = parent[ty][tx][1];
          ty = py;
          tx = px;
        }
        tempX.add(mapping(startX));
        tempY.add(startY + 1);
        Collections.reverse(tempX);
        Collections.reverse(tempY);
        stepX.addAll(tempX);
        stepY.addAll(tempY);
        return cnt;
      }

      for(int i = 0; i < 4; i++) {
        for(int j = 1; j < 8; j++) {
          int dy = curY + dirY[i] * j;
          int dx = curX + dirX[i] * j;

          if (checkArray(dy, dx)) {
            if (!isVisited[dy][dx]) {
              queue.add(new int[]{dy, dx, cnt + 1});
              isVisited[dy][dx] = true;
              parent[dy][dx][0] = curY;
              parent[dy][dx][1] = curX;
            }
          }
        }
      }
    }
    return -1;
  }

  static String mapping(int n) {
    if(n == 0) {
      return "A";
    }
    else if (n == 1) {
      return "B";
    }
    else if (n == 2) {
      return "C";
    }
    else if (n == 3) {
      return "D";
    }
    else if (n == 4) {
      return "E";
    }
    else if (n == 5) {
      return "F";
    }
    else if (n == 6) {
      return "G";
    }
    else if (n == 7) {
      return "H";
    }
    return "A";
  }

  static int mapping(String n) {
    if(n.equals("A")) {
      return 0;
    } else if (n.equals("B")) {
      return 1;
    } else if (n.equals("C")) {
      return 2;
    } else if (n.equals("D")) {
      return 3;
    } else if (n.equals("E")) {
      return 4;
    } else if (n.equals("F")) {
      return 5;
    } else if (n.equals("G")) {
      return 6;
    } else if (n.equals("H")) {
      return 7;
    }
    return 0;
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < 8 && dx < 8) {
      return true;
    }
    else {
      return false;
    }
  }

}
import java.io.*;
import java.util.*;

public class Main {
  static int[] dirX = {0, 0, 0, -1, 1};
  static int[] dirY = {0, -1, 1, 0, 0};

  static char[][] map1;
  static char[][] map2;

  static int P;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    P = Integer.parseInt(br.readLine());

    while(P-- > 0) {
      map2 = new char[3][3];

      for(int i = 0; i < 3; i++) {
        String k = br.readLine();
        for(int j = 0; j < 3; j++) {
          map2[i][j] = k.charAt(j);
        }
      }

      int minClick = Integer.MAX_VALUE;

      for(int i = 0; i < (1 << 9); i++) {
        map1 = new char[3][3];
        for(int j = 0; j < 3; j++) {
          Arrays.fill(map1[j], '.');
        }

        int count = 0;

        for(int j = 0; j < 9; j++) {
          if((i & (1 << j)) != 0) {
            int y = j / 3;
            int x = j % 3;
            toggle(y, x);
            count++;
          }
        }

        if(isSame()) {
          minClick = Math.min(minClick, count);
        }
      }
      sb.append(minClick).append("\n");
    }

    System.out.print(sb);
  }

  static void toggle(int y, int x) {
      for(int i = 0; i < 5; i++) {
        int dy = y + dirY[i];
        int dx = x + dirX[i];

        if(checkArray(dy, dx)) {
          map1[dy][dx] = (map1[dy][dx] == '*') ? '.' : '*';
        }
    }
  }

  static boolean checkArray(int dy, int dx) {
    if(dy >= 0 && dx >= 0 && dy < 3 && dx < 3) {
      return true;
    }
    else {
      return false;
    }
  }

  static boolean isSame() {
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        if(map1[i][j] != map2[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

}
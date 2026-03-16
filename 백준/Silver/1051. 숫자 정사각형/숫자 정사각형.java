import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] rect;

  static int N, M;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    rect = new int[N][M];

    for(int i = 0; i < N; i++) {
      String line = br.readLine();
      for(int j = 0; j < M; j++) {
        rect[i][j] = line.charAt(j) - '0';
      }
    }

    int max = 0;

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        for(int size = 0; size < Math.min(N, M); size++) {
          if(i + size >= N || j + size >= M) break;

          if(rect[i][j] == rect[i + size][j] &&
          rect[i][j] == rect[i][j + size] &&
          rect[i][j] == rect[i + size][j + size]) {
            max = Math.max(max, (size + 1) * (size + 1));
          }
        }
      }
    }

    sb.append(max);

    System.out.print(sb);
  }

}

import java.io.*;
import java.util.*;

public class Main {
  static List<Integer> A, B;

  static int N, S;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    A = new ArrayList<>();
    B = new ArrayList<>();

    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < N; i++) {
      A.add(Integer.parseInt(st.nextToken()));
    }

    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < N; i++) {
      B.add(Integer.parseInt(st.nextToken()));
    }

    Collections.sort(A);

    Collections.sort(B, Collections.reverseOrder());

    for(int i = 0; i < N; i++) {
      S += (A.get(i) * B.get(i));
    }

    sb.append(S);

    System.out.print(sb);
  }

}

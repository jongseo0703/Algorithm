import java.util.*;
import java.io.*;

public class Main {
    public static int calculateTurns(int N, int M) {
        int turns = 0;
        while (M > 0 && N > 0) {
            // 벌레가 오른쪽으로 이동한 후
            N--;
            if (N == 0) break;
            turns++;

            // 벌레가 아래로 이동한 후
            M--;
            if (M == 0) break;
            turns++;

            // 벌레가 왼쪽으로 이동한 후
            N--;
            if (N == 0) break;
            turns++;

            // 벌레가 위로 이동한 후
            M--;
            if (M == 0) break;
            turns++;
        }
        return turns;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(calculateTurns(N, M));
    }

}

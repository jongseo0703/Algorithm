import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int x;
            int y;

            if (N % H == 0) {
                x = H * 100;
                y = N / H;
            }
            else {
                x = (N % H) * 100;
                y = (N / H) + 1;
            }

            sb.append(x+y).append("\n");
        }

        System.out.print(sb);

    }

}
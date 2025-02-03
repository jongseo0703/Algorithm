import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        char[] colors = {'R', 'B', 'Y'};

        StringTokenizer st;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            int layer = Math.min(Math.min(row - 1, N - row), Math.min(col - 1, N - col));

            char color = colors[layer % 3];
            if (color == 'R') bw.write("1\n");
            else if (color == 'B') bw.write("2\n");
            else if (color == 'Y') bw.write("3\n");
            
        }

        bw.flush();
        bw.close();
    }
}
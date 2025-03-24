import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] board = new char[M][N];

        for (int i = 0; i < M; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int minRepaint = Integer.MAX_VALUE;

        for (int i = 0; i <= M - 8; i++) {
            for (int j = 0; j <= N - 8; j++) {
                int repaint = getRepaint(board, i, j);
                minRepaint = Math.min(repaint, minRepaint);
            }
        }

        sb.append(minRepaint);

        System.out.println(sb);
    }

    public static int getRepaint(char[][] board, int x, int y) {

        int repaint1 = 0;
        int repaint2 = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                char current = board[x + i][y + j];

                if ((i + j) % 2 == 0) {
                    if (current != 'W') repaint1++;
                    if (current != 'B') repaint2++;
                }
                else {
                    if (current != 'B') repaint1++;
                    if (current != 'W') repaint2++;
                }
            }
        }

        return Math.min(repaint1, repaint2);

    }

}
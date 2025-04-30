import java.io.*;
import java.util.*;

public class Main {

    static int[][] rect;

    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        rect = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                rect[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        sb.append(white).append("\n");
        sb.append(blue);

        System.out.print(sb);

    }

    static void partition(int row, int col, int size) {
        int midSize = size / 2;

        if (colorCheck(row, col, size)) {
            if (rect[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        partition(row, col, midSize);
        partition(row, col + midSize, midSize);
        partition(row + midSize, col, midSize);
        partition(row + midSize, col + midSize, midSize);
    }

    static boolean colorCheck(int row, int col, int size) {
        int color = rect[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (rect[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

}





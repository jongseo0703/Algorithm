import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] arr = new String[n][m];
        String[][] arr2 = new String[n * 2][m * 2];

        for (int i = 0; i < n; i++) {
            String k = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = k.charAt(j) + "";
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr2[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            int l = m - 1;
            for (int j = (m * 2) / 2; j < m * 2; j++) {
                arr2[i][j] = arr[i][l--];
            }
        }

        int l = n;

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < m * 2; j++) {
                arr2[l][j] = arr2[i][j];
            }
            l++;
        }
        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n * 2; i++) {
            for (int j = 0; j < m * 2; j++) {
                if (i == x - 1 && j == y - 1) {
                    if (arr2[i][j].equals(".")) {
                        arr2[i][j] = "#";
                    }
                    else if (arr2[i][j].equals("#")) {
                        arr2[i][j] = ".";
                    }
                }
            }
        }

        for (int i = 0; i < n * 2; i++) {
            for (int j = 0; j < m * 2; j++) {
                bw.write(arr2[i][j] + "");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

}
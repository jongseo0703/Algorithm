import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][10];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = 0;

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < 10; k++) {
                for (int j = 0; j < 10; j++) {
                    if (j == 9) break;
                    if (arr[i][j] > arr[i][j + 1]) {
                        num = arr[i][j];
                        arr[i][j] = arr[i][j + 1];
                        arr[i][j + 1] = num;
                    }
                }
            }
            bw.write(arr[i][7] + "\n");
        }

        bw.flush();
        bw.close();

    }

}
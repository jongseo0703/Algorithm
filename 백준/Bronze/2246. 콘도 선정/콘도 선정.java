import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int count = 0;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        for (int i = 0; i < n; i++) {

            int lMin = arr[i][0];
            int cMin = arr[i][1];

            boolean flag = true;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (lMin >= arr[j][0] && cMin >= arr[j][1]) {
                    flag = false;
                    break;
                }
            }

            if (flag) count += 1;

        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();

    }

}
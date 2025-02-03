import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        int[] score = new int[N];
        boolean flag = true;
        StringTokenizer st;

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                flag = true;
                for (int k = 0; k < N; k++) {
                    if (j == k) continue;
                    if (arr[j][i] == arr[k][i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) score[j] += arr[j][i];
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(score[i] + "\n");
        }

        bw.flush();
        bw.close();

    }

}
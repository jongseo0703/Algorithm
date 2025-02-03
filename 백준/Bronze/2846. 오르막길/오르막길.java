import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        boolean flag = true;
        int count = 0;
        int max = 0;
        int len = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }

        for (int i = 0; i < n; i++) {

            if (i == n - 1) break;

            if (arr[i + 1] > arr[i]) {
                len += arr[i + 1] - arr[i];
                flag = true;
            }
            else  flag = false;

            if (max < len) max = len;

            if (flag == false) len = 0;
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();

    }

}
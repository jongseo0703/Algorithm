import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int sum = 0;

        int[] temp = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[n - m + 1];

        for (int i = 0; i < n - m + 1; i++) {
            sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += temp[j];
            }
            temp[i] = sum;

            arr[i] = temp[i];
        }

        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();

    }

}
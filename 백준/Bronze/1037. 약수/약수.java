import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int min;
        int max;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {

            arr[i] = Integer.parseInt(st.nextToken());

        }

        min = arr[0];
        max = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];

        }

        if (n == 1) {
            bw.write((arr[0] * arr[0]) + "\n");
        }
        else {
            bw.write((min * max) + "\n");
        }

        bw.flush();
        bw.close();

    }

}
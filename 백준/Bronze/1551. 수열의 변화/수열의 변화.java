import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int count = 0;
        st = new StringTokenizer(br.readLine(),",");

        int[] arr = new int[a];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int j = 0; j < b; j++) {
            for (int i = 0; i < arr.length - count; i++) {
                if (i == arr.length - count - 1) break;
                arr[i] = arr[i + 1] - arr[i];
            }
            count += 1;
        }

        for (int i = 0; i < arr.length - count; i++) {
            if (i == arr.length - count - 1) bw.write(arr[i]+"");
            else bw.write(arr[i] + ",");
        }

        bw.flush();
        bw.close();

    }

}
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        int counter = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 2; j < arr[i]; j++) {
                if (arr[i] % j == 0) count+=1;
            }
            if (count == 0) counter+=1;
            if (arr[i] == 1) counter-=1;
        }
        bw.write(String.valueOf(counter));
        bw.flush();
        bw.close();

    }

}
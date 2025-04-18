import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        Arrays.sort(arr);

        int k = 0;
        while(true) {
            if(k == arr.length) break;

            for(int i = 0; i <= k; i++) {
                sum += arr[i];
            }
            k++;
        }

        sb.append(sum);

        System.out.print(sb);

    }

}
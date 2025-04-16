import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            arr[i] = k;
        }

        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            map.put(i, arr[i]);
        }

        int count = (int)Math.round(n * 0.15);

        int sum = 0;

        for(int i = count; i < n - count; i++) {
            sum += map.get(i);
        }
        
        double average = (double)sum / (n - count * 2);

        sb.append(Math.round(average));

        System.out.print(sb);
    }

}
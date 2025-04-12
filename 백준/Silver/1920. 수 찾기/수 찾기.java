import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());

            if(binarySearch(a, n) >= 0) sb.append("1").append("\n");
            else sb.append("0").append("\n");
        }

        System.out.print(sb);

    }

    static int binarySearch(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(target < arr[mid]) {
                high = mid - 1;
            }
            else if(target > arr[mid]) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }

        return -1;

    }

}
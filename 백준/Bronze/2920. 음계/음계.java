import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        boolean a_state = true;
        boolean d_state = true;

        int[] arr = new int[8];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) break;
            if (arr[i] - arr[i + 1] == -1) d_state = false;
            else if (arr[i] - arr[i + 1] == 1) a_state = false;
            else {
                a_state = false;
                d_state = false;
                break;
            }
        }

        if (a_state) sb.append("ascending");
        else if (d_state) sb.append("descending");
        else sb.append("mixed");

        System.out.print(sb);

    }

}
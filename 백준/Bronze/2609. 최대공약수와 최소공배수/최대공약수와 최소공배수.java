import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int num = 0;
        int num2 = 0;
        boolean flag = false;
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = n * (i + 1);
        }

        if(n > m) {
            for (int i = 1; i <= m; i++) {
                if(n % i == 0 && m % i == 0) num = i;
            }
        }
        else {
            for (int i = 1; i <= n; i++) {
                if(n % i == 0 && m % i == 0) num = i;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((m * (j+1)) == arr[i]) {
                    num2 = arr[i];
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        bw.write(num + "\n");
        bw.write(num2 + "\n");
        bw.flush();
        bw.close();

    }

}
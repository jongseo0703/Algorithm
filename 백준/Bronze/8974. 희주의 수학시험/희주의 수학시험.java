import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int sum = 0;
        int count = 0;
        boolean flag = true;
        int[] arr = new int[1000];

        for (int i = 1; i < 1000; i++) {
            for (int j = i; j > 0; j--) {
                if(count == 1000) {
                    flag = false;
                    break;
                }
                arr[count] = i;
                count++;
            }

            if(flag == false) break;

        }

        for (int i = A - 1; i <= B - 1; i++) {
            sum += arr[i];
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();

    }

}
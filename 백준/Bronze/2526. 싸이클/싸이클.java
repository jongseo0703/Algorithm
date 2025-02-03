import java.util.*;
import java.io.*;

public class Main {



    public static void main (String args[]) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int idx = 0;

        int temp = N;

        int arr[] = new int[P + 1];

        boolean isFound = false;

        while (!isFound) {

            temp = N * temp % P;

            for (int i = 0; i < idx; i++) {

                if (arr[i] == temp) {

                    isFound = true;
                    bw.write(String.valueOf(idx - i));
                    break;

                }

            }

            arr[idx] = temp;
            idx++;

        }

        bw.flush();

    }

}
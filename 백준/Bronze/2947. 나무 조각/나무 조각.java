import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[5];
        int n = 0;
        int correctCount = 0;
        boolean flag = true;

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (flag) {
            for (int i = 0; i < 4; i++) {
                correctCount = 0;

                if (arr[i] > arr[i + 1]) {
                    n = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = n;

                    for (int j = 0; j < 5; j++) {
                        bw.write(arr[j] + " ");
                    }
                    bw.newLine();
                }

                for (int j = 0; j < 5; j++) {
                    if (arr[j] == j + 1) correctCount += 1;
                }

                if (correctCount == 5) {
                    flag = false;
                    break;
                }
            }
        }

        bw.flush();
        bw.close();


    }

}
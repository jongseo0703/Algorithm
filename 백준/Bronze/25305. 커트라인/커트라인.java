import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int person[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        int min = 0;
        int num = 0;

        for (int i = 0; i < n; i++) {
            min = person[i];
            for (int j = i + 1; j < n; j++) {
                if (min > person[j]) {
                    min = person[j];
                    num = person[i];
                    person[i] = min;
                    person[j] = num;
                }
            }
        }

        bw.write(person[n - m] + "\n");
        bw.flush();
        bw.close();

    }

}
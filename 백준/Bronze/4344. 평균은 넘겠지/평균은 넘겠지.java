import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {

            double sum = 0;
            double avg = 0;
            double count = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] students = new int[N];
            for (int j = 0; j < N; j++) {
                students[j] = Integer.parseInt(st.nextToken());
                sum += students[j];
            }

            avg = sum / N;

            for (int j = 0; j < N; j++) {
                if (students[j] > avg) count++;
            }

            BigDecimal bd = new BigDecimal((count / N * 100));
            bd = bd.setScale(3, RoundingMode.HALF_UP);

            bw.write(bd +"%\n");

        }

        bw.flush();
        bw.close();

    }

}
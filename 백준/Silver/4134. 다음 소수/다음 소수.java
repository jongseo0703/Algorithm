import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            long n = Long.parseLong(br.readLine());

            while (true) {
                int count = 0;
                if (n <= 1) n = 2;
                for (int j = 2; j <= Math.sqrt(n); j++) {
                    if (n % j == 0) {
                        count++;
                        break;
                    }
                }

                if (count == 0) {
                    bw.write(n + "\n");
                    break;
                }
                n++;
            }

        }

        bw.flush();
        bw.close();

    }

}
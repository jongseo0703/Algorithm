import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {

            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int n_count = 0;

            for (int i = n + 1; i <= 2 * n; i++) {

                int count = 0;

                for (int j = 2; j <= Math.sqrt(i); j++) {

                    if (i % j == 0) {
                        count++;
                        break;
                    }

                }

                if (count == 0) {
                    n_count++;
                }
            }

            bw.write(n_count + "\n");

        }

        bw.flush();
        bw.close();

    }

}
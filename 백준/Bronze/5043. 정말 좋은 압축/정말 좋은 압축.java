import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        long sum = 1;
        for (int i = 1; i <= b; i++) {
            sum += (1L << i);
        }

        if (N <= sum) bw.write("yes\n");
        else bw.write("no\n");

        bw.flush();
        bw.close();
    }
}
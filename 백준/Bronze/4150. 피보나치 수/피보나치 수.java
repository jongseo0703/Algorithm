import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        BigInteger[] arr = new BigInteger[N];

        if (N == 1) {
            bw.write("1");
        }
        else {
            arr[0] = BigInteger.ONE;
            arr[1] = BigInteger.ONE;

            for (int i = 1; i < N; i++) {
                if (i == N - 1) break;
                arr[i + 1] = arr[i].add(arr[i - 1]);

            }

            sb.append(arr[N - 1].toString());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

}
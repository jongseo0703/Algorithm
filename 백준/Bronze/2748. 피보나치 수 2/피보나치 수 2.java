import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        BigInteger [] arr = new BigInteger[n + 1];
        arr[0] = BigInteger.ZERO;
        arr[1] = BigInteger.ONE;

        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i - 1].add(arr[i - 2]);
        }
        bw.write(arr[n] + "\n");
        bw.flush();
        bw.close();

    }

}
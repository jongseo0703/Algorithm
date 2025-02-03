import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            BigInteger B = new BigInteger(st.nextToken());
            if (B.intValue() == 0) break;

            String P = st.nextToken();
            String M = st.nextToken();

            BigInteger a = BigInteger.ZERO;
            BigInteger b = BigInteger.ZERO;
            BigInteger basePower;

            // Base 10 case
            if (B.intValue() == 10) {
                bw.write((new BigInteger(P)).remainder(new BigInteger(M)).toString() + "\n");
            } else {
                // Calculate value of P in base B
                basePower = BigInteger.ONE;
                for (int i = P.length() - 1; i >= 0; i--) {
                    a = a.add(new BigInteger(P.charAt(i) + "").multiply(basePower));
                    basePower = basePower.multiply(B);
                }

                // Calculate value of M in base B
                basePower = BigInteger.ONE;
                for (int i = M.length() - 1; i >= 0; i--) {
                    b = b.add(new BigInteger(M.charAt(i) + "").multiply(basePower));
                    basePower = basePower.multiply(B);
                }

                // Calculate a % b
                BigInteger k = a.remainder(b);

                // Convert result back to base B
                if (k.equals(BigInteger.ZERO)) {
                    bw.write("0\n");
                } else {
                    StringBuilder result = new StringBuilder();
                    while (k.compareTo(BigInteger.ZERO) > 0) {
                        result.append(k.remainder(B).toString());
                        k = k.divide(B);
                    }
                    bw.write(result.reverse().toString() + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}

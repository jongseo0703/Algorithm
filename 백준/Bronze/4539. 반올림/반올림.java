import java.io.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            int number = Integer.parseInt(br.readLine());
            int len = Integer.toString(number).length();
            int multi = 10;

            for (int j = 0; j < len; j++) {
                if (number >= multi) {
                    BigDecimal bd = new BigDecimal(number);

                    bd = bd.setScale(-1 + (-1 * j), RoundingMode.HALF_UP);

                    number = bd.intValue();
                }
                multi *= 10;
            }

            bw.write(number + "\n");

        }

        bw.flush();
        bw.close();

    }

}
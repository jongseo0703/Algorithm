import java.util.*;
import java.io.*;

public class Main {

    // 주어진 숫자 문자열을 해당 진법에서 10진수로 변환하는 함수
    public static int toDecimal(String num, int base) {
        int decimal = 0;
        int power = 1;

        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = Character.digit(num.charAt(i), base);
            if (digit >= base) {
                return -1; // 유효하지 않은 숫자가 있으면 -1 반환
            }
            decimal += digit * power;
            power *= base;
        }

        return decimal;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            String pStr = st.nextToken();
            String qStr = st.nextToken();
            String rStr = st.nextToken();

            boolean found = false;

            for (int base = 2; base <= 16; base++) {
                int pDecimal = toDecimal(pStr, base);
                int qDecimal = toDecimal(qStr, base);
                int rDecimal = toDecimal(rStr, base);

                if (pDecimal == -1 || qDecimal == -1 || rDecimal == -1) {
                    continue; // 유효하지 않은 숫자가 있으면 해당 진법 건너뜀
                }

                if (pDecimal * qDecimal == rDecimal) {
                    bw.write(base + "\n");
                    found = true;
                    break;
                }
            }

            if (!found) {
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
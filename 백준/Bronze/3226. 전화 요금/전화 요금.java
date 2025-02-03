import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        String k = "";
        int money = 0;
        int H = 0;

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            k = st.nextToken();
            int hour = Integer.parseInt(k.split(":")[0]);
            int minute = Integer.parseInt(k.split(":")[1]);
            int D = Integer.parseInt(st.nextToken());

            for (int j = 0; j < D; j++) {
                int currentMinute = hour * 60 + minute + j;
                // 하루를 기준으로 현재 시간을 계산 (0-1439분)
                currentMinute %= 1440;
                H = currentMinute / 60; // 시간 계산

                if (H >= 7 && H < 19) money += 10;
                else money += 5;

            }

        }

        bw.write(money + "");
        bw.flush();
        bw.close();

    }

}
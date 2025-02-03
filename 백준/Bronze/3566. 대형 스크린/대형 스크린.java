import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int RH = Integer.parseInt(st.nextToken()); // 요구 가로 해상도
        int RV = Integer.parseInt(st.nextToken()); // 요구 세로 해상도
        int SH = Integer.parseInt(st.nextToken()); // 요구 가로 크기
        int SV = Integer.parseInt(st.nextToken()); // 요구 세로 크기
        int minCost = Integer.MAX_VALUE; // 최소 비용

        int n = Integer.parseInt(br.readLine()); // 모니터 종류 수

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            int rhi = Integer.parseInt(st.nextToken()); // 모니터 가로 해상도
            int rvi = Integer.parseInt(st.nextToken()); // 모니터 세로 해상도
            int shi = Integer.parseInt(st.nextToken()); // 모니터 가로 크기
            int svi = Integer.parseInt(st.nextToken()); // 모니터 세로 크기
            int cost = Integer.parseInt(st.nextToken()); // 모니터 가격

            // 첫 번째 방향
            int horizontal1 = Math.max((int)Math.ceil(RH / (double)rhi), (int)Math.ceil(SH / (double)shi));
            int vertical1 = Math.max((int)Math.ceil(RV / (double)rvi), (int)Math.ceil(SV / (double)svi));
            int price1 = horizontal1 * vertical1 * cost;
            if (price1 < minCost) minCost = price1;

            // 두 번째 방향 (회전)
            int horizontal2 = Math.max((int)Math.ceil(RH / (double)rvi), (int)Math.ceil(SH / (double)svi));
            int vertical2 = Math.max((int)Math.ceil(RV / (double)rhi), (int)Math.ceil(SV / (double)shi));
            int price2 = horizontal2 * vertical2 * cost;
            if (price2 < minCost) minCost = price2;
        }

        bw.write(minCost + "\n");
        bw.flush();
        bw.close();
    }
}
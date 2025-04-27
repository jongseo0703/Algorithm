import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[500001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        int min;
        for(int i = 4; i < 500001; i++) {
            min = Integer.MAX_VALUE;

            for(int j = 1; j*j <= i; j++) {
                min = Math.min(dp[i - j * j], min);
            }

            dp[i] = min + 1;
        }

        sb.append(dp[n]);

        System.out.print(sb);

    }

}
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int l = 1;
        int n = 1;
        int m = 1;

        for (int i = 1; i <= N- K; i++) {
            l *= i;
        }

        for (int i = 1; i <= N; i++) {
            n *= i;
        }

        for (int i = 1; i <= K; i++) {
            m *= i;
        }

        sb.append(n / (l * m));

        System.out.println(sb);

    }

}
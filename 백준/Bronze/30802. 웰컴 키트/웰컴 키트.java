import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] tshirt = new int[6];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < tshirt.length; i++) {
            tshirt[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int totalTshirt = 0;

        for(int i = 0; i < tshirt.length; i++) {
            totalTshirt += Math.ceil((double)tshirt[i] / T);
        }

        sb.append(totalTshirt).append("\n");
        sb.append(N / P).append(" ").append(N % P);

        System.out.print(sb);

    }

}
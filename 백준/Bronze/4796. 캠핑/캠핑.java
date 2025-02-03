import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int N = 1;

        while (true) {

            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if (L == 0 && P == 0 && V == 0) break;
            int cycles = V / P;
            int usable_day = L * cycles;
            int remainDay = V % P;
            int total_day = usable_day + Math.min(L, remainDay);

            bw.write("Case "+N+": " + total_day + "\n");
            N+=1;
        }

        bw.flush();
        bw.close();

    }

}
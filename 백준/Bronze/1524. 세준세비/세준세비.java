import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int sMax = 0;
        int bMax = 0;

        for (int i = 0; i < n; i++) {
            String l = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int[] sArr = new int[S];
            int[] bArr = new int[B];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < S; j++) {
                sArr[j] = Integer.parseInt(st1.nextToken());
                if (sArr[j] > sMax) sMax = sArr[j];
            }
            for (int j = 0; j < B; j++) {
                bArr[j] = Integer.parseInt(st2.nextToken());
                if (bArr[j] > bMax) bMax = bArr[j];
            }
            if (bMax <= sMax) bw.write("S" + "\n");
            else bw.write("B" + "\n");
            sMax = 0;
            bMax = 0;
            S = 0;
            B = 0;
        }

        bw.flush();
        bw.close();

    }

}
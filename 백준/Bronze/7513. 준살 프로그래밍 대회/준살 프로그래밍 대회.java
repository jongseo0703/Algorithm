import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            int m = Integer.parseInt(br.readLine());

            String[] arr = new String[m];

            for (int j = 0; j < m; j++) {
                arr[j] = br.readLine();
            }

            int n = Integer.parseInt(br.readLine());
            bw.write("Scenario #"+(i+1)+":\n");
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                while (st.hasMoreTokens()) {
                    bw.write(arr[Integer.parseInt(st.nextToken())]);
                }
                bw.write("\n");
            }
            bw.write("\n");

        }

        bw.flush();
        bw.close();

    }

}
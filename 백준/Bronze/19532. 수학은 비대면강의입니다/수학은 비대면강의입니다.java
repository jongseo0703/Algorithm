import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int x = 0;
        int y = 0;

        boolean flag = false;

        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                if (a * i + b * j == c) {
                    if (d * i + e * j == f) {
                        x = i;
                        y = j;
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) break;
        }

        if (flag) bw.write(x + " " + y + "\n");
        bw.flush();
        bw.close();


    }

}
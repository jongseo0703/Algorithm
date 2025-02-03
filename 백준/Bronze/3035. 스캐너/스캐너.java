import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int ZR = Integer.parseInt(st.nextToken());
        int ZC = Integer.parseInt(st.nextToken());

        String[][] arr = new String[R][C];
        String[][] arr2 = new String[R*ZR][C*ZC];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j) + "";
            }
        }

        for (int i = 0; i < R*ZR; i++) {
            for (int j = 0; j < C*ZC; j++) {
                arr2[i][j] = arr[i/ZR][j/ZC];
            }
        }

        for (int i = 0; i < R*ZR; i++) {
            for (int j = 0; j < C*ZC; j++) {
                bw.write(arr2[i][j]+"");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();

    }

}
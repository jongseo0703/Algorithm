import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        String[][] arr = new String[b.length()][a.length()];

        int n = 0;
        int m = 0;
        boolean flag = false;

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    n = i;
                    m = j;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == m) arr[i][j] = a.charAt(j) + "";
                else if (j == n) arr[i][j] = b.charAt(i) + "";
                else arr[i][j] = ".";
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                bw.write(arr[i][j]);
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }

}
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String m = br.readLine();
        String k = "";

        int starCount = 2;

        String[] arr = m.trim().split("");

        for (int i = 0; i < n; i++) {
            if (arr[i].equals("S")) {
                k += "*S*";
            }

            else if (arr[i].equals("L")) {
                i += 1;
                k += "*LL*";
            }

        }

        for (int i = 1; i < k.length() - 1; i++) {
            if (i == k.length() - 2) break;
            if (k.charAt(i) == '*') {
                if (k.charAt(i+1) == '*') {
                    i += 1;
                    starCount += 1;
                }
                else starCount += 1;
            }
        }

        if (starCount < n) bw.write(starCount + "");
        else bw.write(n + "");

        bw.flush();
        bw.close();

    }

}
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int min = 0;

        if (x == y) {
            if (w == h) {
                if (x > w - x) min = w - x;
                else min = x;
            }
            if (w - x > x && h - y > x) min = x;
        }
        else {
            if (x > y && w - x > y && h - y > y) min = y;
            else if (y > x && w - x > x && h - y > x) min = x;
            else if (x > w - x && y > w - x && h - y > w - x) min = w - x;
            else if (x > h - y && y > h - y && w - x > h - y) min = h - y;
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }

}
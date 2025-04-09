import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 0) break;

            int k = Math.max(Math.max(a, b), c);

            if(k == a) {
                if((b * b + c * c) == k * k) sb.append("right").append("\n");
                else sb.append("wrong").append("\n");
            }
            else if(k == b) {
                if((a * a + c * c) == k * k) sb.append("right").append("\n");
                else sb.append("wrong").append("\n");
            }
            else {
                if((a * a + b * b) == k * k) sb.append("right").append("\n");
                else sb.append("wrong").append("\n");
            }
        }

        System.out.print(sb);

    }

}
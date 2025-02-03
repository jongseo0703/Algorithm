import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int maxLength = Math.max(A, Math.max(B, C));
        int totalLength = A + B + C;
        int remainLength = totalLength - maxLength;
        while (true) {
            if (maxLength >= remainLength) {
                maxLength -= 1;
            }
            else break;
        }

        bw.write((remainLength + maxLength)+"\n");
        bw.flush();
        bw.close();


    }

}
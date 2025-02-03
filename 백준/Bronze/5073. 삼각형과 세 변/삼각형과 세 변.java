import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        while (true) {

            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (A == 0 && B == 0 && C == 0) break;

            int maxLength = Math.max(A, Math.max(B, C));
            int lenSum = A + B + C;
            int len = lenSum - maxLength;
            if (maxLength >= len) bw.write("Invalid");
            else {
                if (A == B && A == C) bw.write("Equilateral");
                else if (A == C || A == B || B == C) bw.write("Isosceles");
                else bw.write("Scalene");
            }
            bw.newLine();

        }

        bw.flush();
        bw.close();


    }

}
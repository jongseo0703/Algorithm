import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        double sum = 0;
        int grade = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            String y = st.nextToken();

            grade += x;

            switch (y) {
                case "A+": sum = sum + x * 4.3; break;
                case "A0": sum = sum + x * 4.0; break;
                case "A-": sum = sum + x * 3.7; break;
                case "B+": sum = sum + x * 3.3; break;
                case "B0": sum = sum + x * 3.0; break;
                case "B-": sum = sum + x * 2.7; break;
                case "C+": sum = sum + x * 2.3; break;
                case "C0": sum = sum + x * 2.0; break;
                case "C-": sum = sum + x * 1.7; break;
                case "D+": sum = sum + x * 1.3; break;
                case "D0": sum = sum + x * 1.0; break;
                case "D-": sum = sum + x * 0.7; break;
                case "F": sum = sum + x * 0.0; break;
            }

        }

        double gpa = sum / grade;
        gpa = Math.round(gpa * 100.0) / 100.0;

        bw.write(String.format("%.2f\n", gpa));
        bw.flush();
        bw.close();

    }

}
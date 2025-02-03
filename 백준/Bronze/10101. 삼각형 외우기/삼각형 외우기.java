import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        if (A == 60 && B == 60 && C == 60) bw.write("Equilateral");
        else if ((A + B + C == 180) && (A == B || B == C || A == C)) bw.write("Isosceles");
        else if (A + B + C == 180) bw.write("Scalene");
        else bw.write("Error");

        bw.flush();
        bw.close();


    }

}
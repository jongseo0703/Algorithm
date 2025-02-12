import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        bw.write(((A*B) / gcd(A, B))+"\n");
        bw.flush();
        bw.close();

    }

    public static long gcd(long a, long b) {
       while (b != 0) {
           long c = a % b;
           a = b;
           b = c;
       }
       return a;
    }

}
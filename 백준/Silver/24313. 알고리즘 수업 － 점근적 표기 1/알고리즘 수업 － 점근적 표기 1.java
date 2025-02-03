import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        long a1 = Long.parseLong(st.nextToken());
        long a0 = Long.parseLong(st.nextToken());

        long c = Long.parseLong(br.readLine());
        long n0 = Long.parseLong(br.readLine());

        boolean flag = true;
        long n = n0;
        for (long i = n; i <= 100; i++) {
            if ((a1 * i + a0) <= (c * i)) {
                continue;
            }
            else {
                flag = false;
                break;
            }
        }

        if (flag) bw.write("1\n");
        else bw.write("0\n");

        bw.flush();
        bw.close();

    }

}
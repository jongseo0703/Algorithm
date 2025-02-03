import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int a = k / 25;
            int b = (k % 25) / 10;
            int c = ((k % 25) % 10) / 5;
            int d = ((k % 25) % 10) % 5;

            bw.write(a + " " + b + " " + c + " " + d+"\n");
        }

        bw.flush();
        bw.close();

    }

}
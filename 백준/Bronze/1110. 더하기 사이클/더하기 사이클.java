import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = 0;
        int k = 0;
        m = n;
        int count = 0;

        while(true) {
            count += 1;
            k = n % 10;
            n = (n / 10) + k;
            if(n < 10) {
                n = (k*10) + n;
            }
            else {
                n = (k*10) + (n - 10);
            }
            if (m == n) break;
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();

    }

}
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 2; i <= n; i++) {

            if (n == 1) {
                break;
            }

            if (n % i == 0) {
                n = n / i;
                bw.write(i + "\n");
                i -= 1;
            }

        }
        bw.flush();
        bw.close();
    }

}
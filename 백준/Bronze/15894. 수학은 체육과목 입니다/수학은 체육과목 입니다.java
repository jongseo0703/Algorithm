import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Integer.parseInt(br.readLine());

        long len = 1 + 3 * n + n - 1;

        bw.write(len + "\n");
        bw.flush();
        bw.close();


    }

}
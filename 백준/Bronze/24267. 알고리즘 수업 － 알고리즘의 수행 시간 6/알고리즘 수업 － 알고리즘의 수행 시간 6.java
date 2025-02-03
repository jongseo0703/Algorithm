import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n =  Integer.parseInt(br.readLine());

        bw.write(n * (n - 1) * (n - 2) / 6 + "\n");
        bw.write("3\n");
        bw.flush();
        bw.close();

    }

}
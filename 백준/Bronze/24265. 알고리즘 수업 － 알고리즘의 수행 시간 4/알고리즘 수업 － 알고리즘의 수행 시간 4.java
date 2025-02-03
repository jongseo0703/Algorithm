import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n =  Integer.parseInt(br.readLine());

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        bw.write(sum + "\n");
        bw.write("2\n");
        bw.flush();
        bw.close();

    }

}